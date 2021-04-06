package Sock1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Clients {
    public static void main(String[] args) {
        new Client("127.0.0.1", 45000);
    }
}
// главный класс клиента
class Client {
    public boolean alive = true;
    public String server_address;
    public int server_port;

    Client(String server_address, int server_port) {
        this.server_address = server_address;
        this.server_port = server_port;
        ClientConnectionThread cct = new ClientConnectionThread(this);
        cct.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            try {
                PrintStream ps = new PrintStream(cct.socket.getOutputStream());
                ps.println(cmd);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
//класс - поток, который ждет сообщений от сервера, создается в единственном экземпляре
class ClientConnectionThread extends Thread {
    Client client;
    Socket socket;

    ClientConnectionThread(Client client) {
        this.client = client;
    }

    public void run() {
        try {
            System.out.println("Подключение к серверу "+this.client.server_address+" порт:"+this.client.server_port);
            socket = new Socket(this.client.server_address, this.client.server_port);
            BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (this.client.alive) {
                String msg = dis.readLine();
                if (msg == null) return;
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

