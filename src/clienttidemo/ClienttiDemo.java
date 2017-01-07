/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttidemo;

import java.io.*;
import java.net.*;
import devicemanager.DeviceManager;
import filemanager.FileManager;

/**
 *
 * @author Pievi
 */
public class ClienttiDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        devicemanager.DeviceManager thisDevice = new devicemanager.DeviceManager();
        filemanager.FileManager currrentFiles = new filemanager.FileManager();
        
        thisDevice.getEthernetMacNumber();
        
        currrentFiles.checkCurrentFilesSameAsServer();
        
        /*
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
        */
    }
    
}
