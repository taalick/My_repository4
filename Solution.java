package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();



        FileInputStream inputStream1  = new FileInputStream(fileName1);
        FileInputStream inputStream2  = new FileInputStream(fileName2);

        byte[] dataFile1 = new byte[inputStream1.available()];
        while(inputStream1.available() > 0){
            inputStream1.read(dataFile1);

        }
        inputStream1.close();
        byte[] dataFile2 = new byte[inputStream2.available()];
        while(inputStream2.available() > 0){
            inputStream2.read(dataFile2);

        }
        for(int i=0; i<dataFile2.length; i++){
            System.out.println((char)dataFile2[i]);
        }
        for(int i=0; i<dataFile1.length; i++){
            System.out.println((char)dataFile1[i]);
        }
        FileOutputStream outputStream1 = new FileOutputStream(fileName1);
        outputStream1.write(dataFile2, 0, dataFile2.length );
        outputStream1.write(dataFile1);




        reader.close();
       // inputStream1.close();
        inputStream2.close();
        outputStream1.close();
    }
}
