package com.force.the.smartmail2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 25/7/2015.
 */
public class EmailDBServer {

    String CSV_PATH = "mailingList.txt";

    public String searchEmail(String companyName){
        companyName = companyName.toLowerCase();

        File file = new File(CSV_PATH);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] tempList;
            while ((line=br.readLine())!=null){
                tempList = line.split(",");
                if (tempList[0].toLowerCase().equals(companyName)){
                    return tempList[1];
                }

            }
            return "cannot find email";

        }catch (IOException e){
            return null;

        }
    }

}
