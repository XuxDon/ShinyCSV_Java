package com.xuxdon.shinycsv.test;


import com.xuxdon.shinycsv.reader.CSVReader;
import com.xuxdon.shinycsv.reader.StandardCSVReader;

import java.io.File;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        File file = new File("/Users/xunan/Downloads/alipay.csv");
        CSVReader reader = new StandardCSVReader();
        List<List<String>> result = reader.readIntoList(file, true);
        System.out.println(result);
    }
}
