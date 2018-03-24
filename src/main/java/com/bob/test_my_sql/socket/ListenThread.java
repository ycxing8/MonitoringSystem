package com.bob.test_my_sql.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;

public class ListenThread extends Thread{
    ServerSocket serverSocket;
    public ListenThread(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void run(){
        while(true){
            try {
                Socket socket = serverSocket.accept();
                SocketProcessThread socketProcessThread = new SocketProcessThread(socket);
                socketProcessThread.start();
            }catch (IOException e){
                System.out.println("socket accept fail");
            }
        }
    }

}
