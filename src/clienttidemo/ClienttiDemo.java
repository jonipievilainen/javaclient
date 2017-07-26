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
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


/**
 *
 * @author Pievi
 */
public class ClienttiDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        File f = new File("config.properties");
        Properties prop = new Properties();
        
        if(f.exists() && !f.isDirectory()) { 
            
            InputStream input = null;
            
            try {
                input = new FileInputStream("config.properties");
                prop.load(input);
                System.out.println(prop.getProperty("deviceName"));
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            Scanner scanner = new Scanner(System.in);
            String deviceName;
            
            System.out.println("Enter device name:");
            deviceName=scanner.nextLine();
            
            OutputStream output = null;
            
            try {
                output = new FileOutputStream("config.properties");
                prop.setProperty("deviceName", deviceName); // dublicate if you need more´settings
                // save properties to project root folder
                prop.store(output, null);
            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        devicemanager.DeviceManager thisDevice = new devicemanager.DeviceManager();
        filemanager.FileManager currrentFiles = new filemanager.FileManager();
        
        // thisDevice.getEthernetMacNumber();
        
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
