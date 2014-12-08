package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //        Write a program name text processing. In your program you need to read a text
//        file and find the frequency of each word, after that you will store a text file
//        which is corresponds to the original file but instead of each word you put number
//        of dots which is related to the frequency of each word. Maximum number of dots is
//        ten and minimum is one. This is one method of data visualization.
//
//        Now try to do find the happiness of a document. Try to find two documents that are
//        relatively similar and try to compare the happiness of these two documents. Try to
//        find multiple documents of an author and find how the happiness in his documents is
//        changing during years.
//

        String file_name="testFile.rtf";
        String WriteFile="WriteTest.rtf";

        try{
            ReadFile file=new ReadFile(file_name);
            String[] arylines=file.OpenFile();
            int lineCount=arylines.length;
            for(int i=0;i<arylines.length;i++){
                System.out.println(arylines[i]);
            }
            System.out.println();

            Frequency File=new Frequency(file_name);
            File.freqWords();
            System.out.println();

            File.writeToFile();
            System.out.println();
            File.happiness(lineCount);





        }

        catch(IOException e){
            System.out.println("Sorry I couldn't find the file");
        }




    }

}
