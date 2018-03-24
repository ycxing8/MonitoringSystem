package com.bob.test_my_sql.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

import com.bob.test_my_sql.controller.MachineController;
import com.bob.test_my_sql.entity.Machine;
import com.bob.test_my_sql.reposirity.MachineRepository;
import com.bob.test_my_sql.reposirity.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

public class SocketProcessThread extends Thread{

    Socket socket;

    public SocketProcessThread(Socket socket) {
        this.socket = socket;
        System.out.println("Connection accept socket:" + socket);
    }

    public void run() {

        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            pw.println("you connected");
            pw.flush();
            String identityCode = br.readLine();//readLine会堵塞，直到遇到‘\n’
            System.out.println("Machine: " + identityCode + " connect");

            Machine machine = MachineUtils.machineUtils.findByMachineIdentityCode(identityCode);
            System.out.println("A machine connect." +
                    "ID: " + machine.getId() +
                    " Name: " + machine.getMachineName() +
                    " IdentityCode: " + machine.getMachineIdentityCode());

            if (machine != null) {
                pw.println("Correct identity");
                pw.flush();
            } else {
                pw.println("Correct error");
                pw.flush();
            }


        }catch (Exception e){
            System.out.println("One socket use to connect machine disconnect");
            e.getStackTrace();
        }finally {
            try{
                br.close();
                pw.close();
                socket.close();
            }catch (Exception e){
                System.out.println("One socket can't be close");
                e.getStackTrace();
            }

        }

    }
}
