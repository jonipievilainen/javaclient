/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import displaymanager.DisplayManager;

/**
 *
 * @author Pievi
 */
public class FileManager {
    public Boolean checkCurrentFilesSameAsServer() throws IOException, InterruptedException{
        
//        getCurrentFiles();
        
       
        displaymanager.DisplayManager imgManager = new displaymanager.DisplayManager(getJsonConfig());
        
        
        return false;
    }
    
    private ArrayList getJsonConfig() throws IOException{
        ArrayList<List> configs = new ArrayList<List>();
        
//        http://stackoverflow.com/questions/39689507/how-to-parse-json-array-from-file
        
        
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try {

            jsonObject = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir")+"/CurrentData/data.json"));

//            System.out.println("<br>"+jsonObject);

            JSONArray settings = (JSONArray)jsonObject.get("settings");
            
            for (int i = 0; i < settings.size(); i++) {

                JSONObject jsonObjectRow = (JSONObject) settings.get(i);
                String displayTimes = (String) jsonObjectRow.get("displayTime");
                String file = (String) jsonObjectRow.get("file");
                
                List<String> listdata = new ArrayList<String>();
                listdata.add(file);
                listdata.add(displayTimes);
                
                configs.add(listdata);
//                System.out.println("<br>displayTime="+displayTime+"; file="+file);
            }
            
            System.out.println(configs);
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
        return configs;
    }
    
    private ArrayList getCurrentFiles(){
        ArrayList<String> files = new ArrayList<String>();
        
        System.out.println(System.getProperty("user.dir"));
        
        File folder = new File(System.getProperty("user.dir")+"/CurrentData");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        
        return files;
    }
}
