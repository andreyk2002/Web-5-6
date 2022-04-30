package by.fpmi.web.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

public class Server {

    private static final Logger LOGGER = LogManager.getLogger(Server.class);
    private static final int SERVER_PORT = 13666;
    private static final int PERIOD_TIME_MS = 10000;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = server.accept();
                try {
                    ServerRunner serverRunner = new ServerRunner(socket, PERIOD_TIME_MS);
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}
