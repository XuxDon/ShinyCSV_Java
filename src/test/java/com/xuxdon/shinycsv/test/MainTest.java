package com.xuxdon.shinycsv.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MainTest {

    @Test
    public void testIO(){
        File dir1 = new File("~/temp/shinycsv/a1");
        System.out.println(dir1);

        File a1txt = new File("/Users/xunan/temp/shinycsv/a1/a1txt");

        String t = "hello microsoft";
        try {
            FileUtils.writeStringToFile(a1txt, t, StandardCharsets.UTF_8, true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRead(){
//        File a1txt1 = new File("/Users/xunan/Downloads/alipay_record_20210710_1711_1.csv");
        File a1txt1 = new File("/Users/xunan/temp/tr.csv");
        System.out.println(a1txt1);
        System.out.println(a1txt1.exists());
        try {
//            List<String> rawContent = FileUtils.readLines(a1txt1, StandardCharsets.UTF_8);
            List<String> rawContent = FileUtils.readLines(a1txt1, Charset.forName("GB2312"));
            System.out.println(rawContent.size());
            System.out.println(rawContent);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
