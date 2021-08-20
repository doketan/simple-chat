package com.doketan.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7878);
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            String inputMsg = "", outputMsg = "";

            while(!inputMsg.equals("end!!!")){
                inputMsg = dataInputStream.readUTF();
                System.out.println(inputMsg);
                outputMsg = scanner.nextLine();
                dataOutputStream.writeUTF(outputMsg);
                dataOutputStream.flush();
            }

            socket.close();;
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
