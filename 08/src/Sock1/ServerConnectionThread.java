package Sock1;

import java.io.*;
        import java.net.*;

// класс - поток, который ждет сообщеня от одного клиента
// для каждого клиентского подключения, создается свой экземпляр ServerConnectionThread
public class ServerConnectionThread extends Thread {
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
                BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = dis.readLine();
                if (msg == null) {
                    server.clients.remove(this);
                    this.connected = false;
                    this.server.onClientChange(this);
                    return;
                } else {
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




