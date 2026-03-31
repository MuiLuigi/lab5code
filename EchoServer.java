// Name: Fahad Arif (N01729165)
// Course: Networking & Telecomm (CPAN-226)

import java.net.*;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        // Step A: Create a socket to listen on port 5000
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("Server is listening on port 5000...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // TODO: Use the socket to 'receive' the packet here
            socket.receive(packet);
            
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received by Fahad: " + received);

            Scanner s = new Scanner(new URL("http://api.quotable.io/random?tags=technology").openStream());
            String webData = s.useDelimiter("\\A").next();
            s.close();

            byte[] responseData = webData.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());

            // TODO: Use the socket to 'send' the packet back to the client
            socket.send(responsePacket);
        }
    }
}