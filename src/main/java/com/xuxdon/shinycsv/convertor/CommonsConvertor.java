package com.xuxdon.shinycsv.convertor;

import com.xuxdon.shinycsv.entity.Indicator;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonsConvert 用于转换 Apache commons-csv 读取 csv 文件返回的结果
 *
 * @author  xuxdon
 */
public class CommonsConvertor {

    /**
     * 将 commons-csv 读取结果转换为常用的 List
     *
     * @param indicator indicator 记录了 CSV 文件表格的列数
     * @param records commons-csv 读取结果
     * @return List&lt;List&lt;String&gt;&gt; 每个子 List 按顺序包含 CSV 一行的所有列
     */
    public static List<List<String>> convertRecordsIntoList(Iterable<CSVRecord> records, Indicator indicator){
        List<List<String>> rowList = new ArrayList<>();
        records.forEach(record -> {
            List<String> row = new ArrayList<>();
            indicator.getIndexStream().forEach(i -> {
                row.add(record.get(i).trim());
            });
            rowList.add(row);
        });
        return rowList;
    }

}
