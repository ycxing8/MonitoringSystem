package com.seu.monitor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

import com.seu.monitor.entity.ComponentLog;
import com.seu.monitor.entity.Machine;
import com.seu.monitor.socket.utils.MachineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;

import static com.seu.monitor.socket.utils.ComponentLogUtils.addComponentLog;

public class SocketProcessThread extends Thread{

    Socket socket;

    public SocketProcessThread(Socket socket) {
        this.socket = socket;
        System.out.println("Connection accept socket:" + socket);
    }

    public void run() {

        BufferedReader br = null;
        PrintWriter pw = null;
        String machineIdentifier;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            pw.println("you connected");
            pw.flush();
            String identityCode = br.readLine();//readLine会堵塞，直到遇到‘\n’
            System.out.println("Machine: " + identityCode + " connect");

            Machine machine = MachineUtils.machineUtils.findByMachineIdentityCode(identityCode);
            if(machine != null){
                machineIdentifier = machine.getIdentifier();
                System.out.println("A machine connect." +
                        "ID: " + machine.getId() +
                        " Name: " + machine.getName() +
                        " IdentityCode: " + machine.getIdentityCode());
                pw.println("Correct identity");
                pw.flush();

                while (true){
                    String str = br.readLine();
                    pw.println("Server get a log!");
                    pw.flush();

                    String [] arr = str.split("\\s+");
                    System.out.println(str);
                    ComponentLog componentLog = new ComponentLog();
                    componentLog.setMachineIdentifier(machineIdentifier);
                    int index = 0;
                    for(String ss : arr){
                        System.out.println(ss);
                        index++;
                        switch (index){

                            case 1:
                                componentLog.setComponentIdentifier(ss);
                                break;

                            case 2:
                                componentLog.setData(ss);
                                break;
                            case 3:
                                componentLog.setUnit(ss);
                                break;
                            default:
                                System.out.println("Error data form");
                                break;
                        }
                    }
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    componentLog.setTime(dateFormat.format(new Date()));
                    addComponentLog(componentLog);

                }


            } else {
                pw.println("Error identity");
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
