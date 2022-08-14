package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    public static void main(String args[]){

        startServer();

    }

    private static void startServer(){
        ServerSocket server = null;
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
             server = new ServerSocket(1234);
             server.setReuseAddress(true);

             while(true){
                 Socket client = server.accept();
                 System.out.println("client connection created");
                 ClientHandler handler = new ClientHandler(client);
                 service.submit(handler);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            service.shutdown();
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
