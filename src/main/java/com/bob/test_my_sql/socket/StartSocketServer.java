package com.bob.test_my_sql.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;
import com.bob.test_my_sql.socket.SocketProcessThread;

public class StartSocketServer {

    public static int PORT = 8082;

    public static void start() {
        ServerSocket serverSocket = null;
        try {
            InetAddress address =InetAddress.getLocalHost();
            serverSocket = new ServerSocket(PORT);
            System.out.println("ServerSocket Start:" + address.getHostAddress() +  ":"+ serverSocket);

        } catch (IOException e) {
            System.out.println("start socket server fail");
            e.printStackTrace();
        }
        try {
            ListenThread listenThread = new ListenThread(serverSocket);
            listenThread.start();
        }catch(Exception e){
            System.out.println("listen thread start fail");
        }
    }

}
