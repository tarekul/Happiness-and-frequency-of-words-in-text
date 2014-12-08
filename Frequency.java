package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.io.*;
import java.util.HashMap;



/**
 * Created by tarekulislam on 11/22/14.
 */
public class Frequency {
    private String fileInput;

    public Frequency(String file) {
        fileInput = file;


    }

    String aLine;
    HashMap<String, String> map = new HashMap<String, String>();
    HashMap<String,Integer>map2=new HashMap<String, Integer>();

    public void freqWords() throws IOException {
        FileReader file_to_read = new FileReader(fileInput);
        BufferedReader lineToRead = new BufferedReader(file_to_read);

        //read lines from the file
        while ((aLine = lineToRead.readLine()) != null) {
            String[] result=aLine.split("\\W");
            for(int x=0;x<result.length;x++){
//                if(result[x]=="\\n")
//                    x=x+1;

                if(map.get(result[x])!=null){
                    String counter=map.get(result[x]);
                    counter=counter+"*";
                    map.put(result[x],counter);
                    int counter2=map2.get(result[x]);
                    counter2=counter2+1;
                    map2.put(result[x],counter2);
                }

                else{
                    map.put(result[x],"*");
                    map2.put(result[x],1);

                }
            }



        }


    }

    public void happiness(int lineNumber) throws IOException {
        ArrayList<String>words=new ArrayList<String>();
        int j=0;

        for (Map.Entry<String,Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            // do stuff
            System.out.print(key);
            System.out.print("\t");
            System.out.print(value);
            System.out.println("");

            for (int i = 0; i < value; i++) {
                words.add(j, key);
                j = j + 1;

            }


        }
        for(int count=0;count<j;count++) {
            String hold = words.get(count);
            System.out.println(hold);
        }
            System.out.println("total number of words in text="+(j-lineNumber));

    }





    public void writeToFile() throws IOException {

        File log=new File("testFile.rtf");
        PrintWriter out=new PrintWriter(log);
        for (Map.Entry<String,String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // do stuff
            System.out.print(key);
            System.out.print("\t");
            System.out.print(value);
            System.out.println("");

            out.append(key+"\t"+value+"\n");
        }
        out.close();





    }






}









