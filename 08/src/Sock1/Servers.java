package Sock1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servers {
    public static void main(String[] args) {
        new Server(45000);
    }
}

// главный класс для сервера, хранит список подлкючений и выполняет переадресацию сообщений
class Server {
    public boolean alive = true;
    public ArrayList<ServerConnectionThread> clients = new ArrayList<ServerConnectionThread>();

    Server(int port) {
        System.out.println("Запуск сервера: " + port);
        new ServerConnectionInitThread(port, this).start();
    }

    // вызывается, когда клиент подключается или отключается
    public void onClientChange(ServerConnectionThread clientThread) {
        System.out.println("onClientChange: " + clientThread);
        System.out.println("active client list:");
        String clientsList = "";
        for (int i=0; i<clients.size(); i++) {
            clientsList += i+". "+clients.get(i) + "\r\n";
        }
        for (ServerConnectionThread c: clients) {
            try {
                PrintStream ps = new PrintStream(c.socket.getOutputStream());
                c.sendMessage("Clients count="+clients.size());
                c.sendMessage(clientsList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.print(clientsList);
        //System.out.println("Клиент: " + clientThread.socket.getInetAddress().toString() + " порт:" +clientThread.socket.getPort() + " подключен:" + connected);
    }

    public void onClientMessage(ServerConnectionThread clientThread, String message) {
        System.out.println("Cообщение от (" + clientThread + "): " + message);
        if (message.startsWith("to ")) {
            int msgPos = message.indexOf(" ",3);
            int clientIndex = Integer.parseInt(message.substring(3, msgPos));
            clients.get(clientIndex).sendMessage(message.substring(msgPos+1));
        }
    }
}

//ждет подключения от нового клиента и потом для каждого подключения создает экземпляр ServerConnectionThread
class ServerConnectionInitThread extends Thread {
    Server server;
    int port;

    ServerConnectionInitThread(int port, Server server) {
        this.server = server;
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(port);
            while (this.server.alive) {
                Socket socket = ss.accept();
                ServerConnectionThread sst = new ServerConnectionThread(socket, this.server);
                this.server.clients.add(sst);
                this.server.onClientChange(sst);
                sst.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ждет сообщения от одного клиента
// для каждого клиентского подключения, создается свой экземпляр ServerConnectionThread
class ServerConnectionThread extends Thread {
    boolean connected = true;
    Socket socket;
    Server server;

    ServerConnectionThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        System.out.println("Ожидание сообщений от клиента (" + this + ")");
        while (this.server.alive) {
            try {
                String msg = new BufferedReader (new InputStreamReader (socket.getInputStream())).readLine();
                if (msg != null) {
                    server.onClientMessage(this, msg);
                }
            } catch (IOException e) {
                server.clients.remove(this);
                this.connected = false;
                this.server.onClientChange(this);
                return;
            }
        }
    }

    public String toString() {
        return "Клиент: " + this.socket.getInetAddress().toString() + " порт:" +this.socket.getPort() + " подключен:" + this.connected;
    }

    public void sendMessage(String message) {
        try {
            PrintStream ps = new PrintStream(this.socket.getOutputStream());
            ps.println(message);
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
