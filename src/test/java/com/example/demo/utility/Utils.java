//package com.example.demo.utility;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//
//public class Utils {
//
//    Properties prop = new Properties();
//    String fileName = "app.config";
//    FileInputStream fis = new FileInputStream(fileName);
//
//    public Utils() throws FileNotFoundException {
//    }
//
//    public void readFile() {
//        try {
//            prop.load(fis);
//                System.out.println(prop.getProperty("app.name"));
//                System.out.println(prop.getProperty("app.version"));
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
//
//}
