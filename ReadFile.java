package com.company; /**
* Created by tarekulislam on 11/22/14.
*/
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.String;

import java.util.*;

public class ReadFile {
    private String path;
    public ReadFile(String file_path){
        path=file_path;
    }

    public String[] OpenFile() throws IOException{
        FileReader fr=new FileReader(path);
        BufferedReader textReader=new BufferedReader(fr);

        int numberOfLines=readLines();
        String[] textdata=new String[numberOfLines];

        for(int i=0;i<numberOfLines;i++){
            textdata[i]=textReader.readLine();

        }
        textReader.close();
        return textdata;
    }

    public int readLines() throws IOException{
        FileReader file_to_read=new FileReader(path);
        BufferedReader bf=new BufferedReader(file_to_read);

        String aLine;
        int numberOfLines=0;

        while((aLine=bf.readLine())!=null){
            numberOfLines++;
        }
        bf.close();
        return numberOfLines;
    }

//    public String[] readWords() throws IOException {
//        Scanner ScanFile = new Scanner(new FileReader(path));
//        ArrayList<String> words=new ArrayList<String>();
//        String theWord;
//
//
//        while (ScanFile.hasNext()) {
//            theWord=ScanFile.next();
//            words.add(theWord);
//
//        }
//
//        return words;


//      }
}
