package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Created by tarekulislam on 11/22/14.
 */
public class Frequency {
    private String fileInput;
    private String happyFileList;

    public Frequency(String file,String File2) {
        fileInput = file;
        happyFileList=File2;


    }

    String aLine;
    String aLine2;
    int happyCount=0;
    HashMap<String, String> map = new HashMap<String, String>();
    HashMap<String,Integer>map2=new HashMap<String, Integer>();
    HashMap<String,String>happyWords=new HashMap<String, String>();

    public void freqWords() throws IOException {
        FileReader file_to_read = new FileReader(fileInput);
        BufferedReader lineToRead = new BufferedReader(file_to_read);

        //read lines from the file
        while ((aLine = lineToRead.readLine()) != null) {
            String[] result=aLine.split("\\W");
            for(int x=0;x<result.length;x++){
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

    public void happiness() throws IOException {
        ArrayList<String>words=new ArrayList<String>();
        int j=0;
        System.out.println("FREQUENCY OF WORDS:"+"\n");

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
        FileReader textFile=new FileReader(happyFileList);
        BufferedReader lineToRead=new BufferedReader(textFile);


        //int k=0;
        while((aLine2=lineToRead.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(aLine2.toString());
            String[] spliter = new String[]{st.nextToken(),st.nextToken()};
            happyWords.put(spliter[0],spliter[1]);

        }


        for(int count=0;count<j;count++) {
            String hold = words.get(count);
            //System.out.println(hold);
        }
        System.out.println("TOTAL # OF WORDS IN TEXT="+(j)+"\n");


        for(int i=0;i<words.size();i++) {
            for (Map.Entry<String, String> entry : happyWords.entrySet()) {
                String key = entry.getKey();
                int value = Integer.parseInt(entry.getValue());
                //System.out.print(key + " ");
                //System.out.print(value);
                //System.out.println();

                if (words.get(i).equals(key)) {
                    //System.out.println("found a match");
                    happyCount = happyCount + value;
                }

                //else
                    //System.out.println("no match found");


            }
        }


        System.out.println("HAPPINESS OF DOCUMENT IS: "+happyCount+"\n");

    }





    public void writeToFile(String x) throws IOException {

        File log=new File(x);
        PrintWriter out=new PrintWriter(log);
        for (Map.Entry<String,String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // do stuff
            //System.out.print(key);
            //System.out.print("\t");
            //System.out.print(value);
            //System.out.println("");

            out.append(key+"\t"+value+"\n");
        }
        out.close();





    }






}









