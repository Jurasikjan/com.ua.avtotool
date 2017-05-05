package com.ua.avtotool;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Юра on 21.04.2017.
 */
public class App {
    public static void main(String[] args) {

        InputStreamReader in = null;
        OutputStreamWriter ow=null;
        try {
            in = new InputStreamReader(new FileInputStream(new File("ins.txt")),"UTF-8");
            ow = new OutputStreamWriter(new FileOutputStream(new File("ins1.txt"),false));
            Scanner it=new Scanner(in);
            it.useDelimiter("[)],[(]");
            int i=0;
            while (it.hasNext()) {
                i++;
                String d=it.next();
                String[] mas=d.split("[,]+");
               // System.out.println(i+" : "+mas[21].toString());


                //System.out.println(mas[0]+" : "+mas[34].toString());
                //System.out.println(mas[0]+" : "+mas[21].toString());
                //'2016-12-22'

StringBuffer stringBuffer =new StringBuffer();

                for (int j = 0; j < mas.length; j++) {
                    if(j==34) {
                        System.out.println(mas[j]);
                        //mas[j]="'2016-12-22 11:11:11'";
                    }
                    if(mas[j].equals("'0000-00-00'")) {
                        System.out.println(mas[0] + " : " + mas[j].toString());
                        mas[j]="'2016-12-22'";
                    }
                    if(mas[j].equals("'0000-00-00 00:00:00'")) {
                        System.out.println(mas[0] + " : " + mas[j].toString());
                        mas[j]="'2016-12-22 11:11:11'";
                    }

                    stringBuffer.append(mas[j]);
                    if(j!=mas.length-1)
                        stringBuffer.append(",");
                }


stringBuffer.append("),(");
                ow.write(stringBuffer.toString());

            }
        } catch (IOException e) {
            // log error
        }
    }
}
