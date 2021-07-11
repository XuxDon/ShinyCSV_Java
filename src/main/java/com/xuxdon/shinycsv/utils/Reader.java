package com.xuxdon.shinycsv.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Reader {
    private Charset charset;

    public Reader(){
        this.charset = StandardCharsets.UTF_8;
    }

    public Reader(Charset charset){
        this.charset = charset;
    }

    public List<String> readTextFileByLine(File file) throws IOException {
        return readTextFileByLine(file, this.charset);
    }


    /**
     * 指定文件并按行读取内容
     * @param file 文本文件
     * @param charset 字符集
     * @return 文本文件的每一行组成的字符串集合对象
     * @throws IOException 读取失败或者读到的内容为空
     */
    public List<String> readTextFileByLine(File file, Charset charset) throws IOException {
        List<String> rawContent = null;
        rawContent = FileUtils.readLines(file, charset);
        if (rawContent == null || rawContent.size() == 0){
            // throws Exception
        }
        return rawContent;
    }
}
