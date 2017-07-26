/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displaymanager;

import java.awt.FlowLayout;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        while(!start) { 
            
            ArrayList conf = (ArrayList) configuers.get(adCounter);
            time = (String) conf.get(1);
            String file = (String) conf.get(0);
            
            System.out.println("here");
            BufferedImage img=ImageIO.read(new File("CurrentData/"+file));
            ImageIcon icon=new ImageIcon(img);
            
            lbl.setIcon(icon);
            
            Thread.sleep(Integer.parseInt(time));
            
            if((adCounter+1) >= configuers.size()){
                adCounter = 0;
            }else{
                adCounter++;
            }
        }
    }
}
