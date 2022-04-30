package by.fpmi.web.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Class ServerRunner sents messages to clients in specific periods of time
 */
public class ServerRunner extends TimerTask {
    private static final String MESSAGE = "Hello from server!";
    private static final Logger LOGGER = LogManager.getLogger(ServerRunner.class);

    private final Socket socket;
    private final BufferedReader in;
    private final BufferedWriter out;
    private final long periodTime;

    public ServerRunner(Socket socket, long periodTime) throws IOException {
        this.socket = socket;
        this.periodTime = periodTime;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, 0, periodTime);
    }

    @Override
    public void run() {
        try {
            out.write(ServerRunner.MESSAGE + "\n");
            out.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                Thread.currentThread().interrupt();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
