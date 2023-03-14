package ru.sevka.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//
//        context.close();



        String pathI = "E:/SpringTestProject/src/main/resources/applicationContext.xml";
        String pathO = "E:/SpringTestProject/src/main/resources/test.txt";

        int b = 0;
        try (InputStreamReader isr = new InputStreamReader(Files.newInputStream(Paths.get(pathI)), StandardCharsets.UTF_8);
             FileWriter writer =  new FileWriter(pathO)) {
            while (isr.ready()){
                writer.write(isr.read());
                writer.flush();
                //writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}