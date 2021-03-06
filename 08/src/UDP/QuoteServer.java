package UDP;
import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteServer {
    private DatagramSocket datagramSocket;
    private List<String> listQuotes = new ArrayList<String>();
    private Random random;

    public QuoteServer(int port) throws SocketException {
        datagramSocket = new DatagramSocket(port);
        random = new Random();
    }

    public static void main(String[] args) {
        String quoteFile = "Messages.txt";
        int port = 17;

        try {
            QuoteServer server = new QuoteServer(port);
            server.loadQuotesFromFile(quoteFile);
            server.service();
        } catch (SocketException ex) {
            System.out.println("Socket error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    private void service() throws IOException {
        while (true) {
            DatagramPacket request = new DatagramPacket(new byte[1], 1);
            datagramSocket.receive(request);

            byte[] buffer = getRandomQuote().getBytes();

            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();

            DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            datagramSocket.send(response);
        }
    }

    private void loadQuotesFromFile(String quoteFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(quoteFile));
        String aQuote;

        while ((aQuote = reader.readLine()) != null) {
            listQuotes.add(aQuote);
        }

        reader.close();
    }

    private String getRandomQuote() {
        int randomIndex = random.nextInt(listQuotes.size());
        String randomQuote = listQuotes.get(randomIndex);
        return randomQuote;
    }
}
