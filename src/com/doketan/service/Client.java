package com.doketan.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1",7878);

            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            String msgIn="",msgOut="";

            while(!msgIn.equals("end!!!")){
                msgOut = scanner.nextLine();
                dout.writeUTF(msgOut);
                msgIn = din.readUTF();
                System.out.println(msgIn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
