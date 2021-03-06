/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displaymanager;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jonipievilainen
 */
public class DisplayManager {
    public static void main(String avg[]) throws IOException
    {
//        DisplayManager abc = new DisplayManager();
    }

    public DisplayManager(ArrayList configuers) throws IOException, InterruptedException
    {
        
        
        
        Boolean start = false;
        Integer adCounter = 0;
        Integer taimdfe = 1000;
        String time = "";  

        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        JLabel lbl=new JLabel();
        
        frame.add(lbl);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.setVisible(true);   
        frame.setResizable(true);
        
        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        device.setFullScreenWindow(frame);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(!start) { 
            
            ArrayList conf = (ArrayList) configuers.get(adCounter);
            time = (String) conf.get(1);
            
            String file = (String) conf.get(0);
            
            System.out.println(time);
            
            if(time.equals("0")){
                
                // https://github.com/samicemalone/tv/blob/master/src/main/java/uk/co/samicemalone/tv/player/OMXPlayer.java
                
                Desktop.getDesktop().open(new File("CurrentData/"+file));
                
                System.out.println("video");
                time = "1000";
            }else{
                System.out.println("here");
                BufferedImage img=ImageIO.read(new File("CurrentData/"+file));
                ImageIcon icon=new ImageIcon(img);

                lbl.setIcon(icon);
            }
            
            Thread.sleep(Integer.parseInt(time));
            
            if((adCounter+1) >= configuers.size()){
                adCounter = 0;
            }else{
                adCounter++;
            }
        }
    }
}
