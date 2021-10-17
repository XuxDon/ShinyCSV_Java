package com.xuxdon.shinycsv.reader;

import java.io.File;
import java.util.List;

/**
 * 标准 CSV 读入解析实现类
 */
public class StandardCSVReader extends CSVReader {

    @Override
    public <T> List<T> read(File csvFile, boolean containsHeader, Class<T> clz){
        return null;
    }


    @Override
    public List<List<String>> readIntoList(File csvFile, boolean containsHeader){
        return super.readFileIntoList(csvFile, containsHeader);
    }
}
