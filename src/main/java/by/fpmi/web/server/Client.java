package by.fpmi.web.server;

import java.util.ArrayList;
import java.util.List;


public class Client {

    private static final int CLIENTS_COUNT = 2;


    public static void main(String[] args) {
        List<ClientRunner> helpers = new ArrayList<>();
        for (int i = 0; i < CLIENTS_COUNT; i++) {
            ClientRunner clientHelper = new ClientRunner(i);
            helpers.add(clientHelper);
            clientHelper.start();
        }

    }
}
