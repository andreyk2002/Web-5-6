package by.fpmi.web.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;

/**
 * ClientRunner class accepts messages from server
 */
public class ClientRunner {
    private static final Logger LOGGER = LogManager.getLogger(ClientRunner.class);
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private long id;

    private static final String ADDRESS = "localhost";
    private static final int PORT = 13666;

    public ClientRunner(long id) {
        try {
            this.id = id;
            this.socket = new Socket(ADDRESS, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            ClientRunner.this.shutdown();
        }
    }

    public void start() {
        new MessageReader().start();
    }


    private void shutdown() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private class MessageReader extends Thread {
        /**
         * Reading messages from server
         */
        @Override
        public void run() {
            String string;
            try {
                while (true) {
                    string = in.readLine();
                    System.out.printf("Message for client %d - %s%n", id, string);
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
                ClientRunner.this.shutdown();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
