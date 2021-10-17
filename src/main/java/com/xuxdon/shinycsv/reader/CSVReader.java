package com.xuxdon.shinycsv.reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVReader {


    /**
     * 读取 CSV 文件并转换为特定类的对象集合
     *
     * @param csvFile csv 文件
     * @param containsHeader 是否包含标题行 (标题行行尾不允许有逗号，标题行 header 不会被纳入解析结果)
     * @param clz 表格行对应的实体类
     * @return clz 对象的集合
     */
    public abstract <T> List<T> read(File csvFile, boolean containsHeader, Class<T> clz);


    /**
     * 读取 CSV 文件并转换为二维数组 (List&Lt;List&gt;)
     *
     * @param csvFile csv 文件
     * @param containsHeader 是否包含标题行 (标题行行尾不允许有逗号，标题行 header 不会被纳入解析结果)
     * @return 以二维数组 (List&Lt;List&gt;) 表示的表格数据
     */
    public abstract List<List<String>> readIntoList(File csvFile, boolean containsHeader);


    // 基础方法


    /**
     * 读取 CSV 文件并转换为二维数组 (List&Lt;List&Lt;String&gt;&gt;)
     *
     * @param csvFile csv 文件
     * @param containsHeader 是否包含标题行 (标题行行尾不允许有逗号，标题行 header 不会被纳入解析结果)
     * @return 以二维数组 (List&Lt;List&Lt;String&gt;&gt;) 表示的表格数据
     */
    protected List<List<String>> readFileIntoList(File csvFile, boolean containsHeader){
        Iterable<CSVRecord> records = this.parseFile(csvFile, containsHeader);

        List<List<String>> rowList = new ArrayList<>();
        for (CSVRecord record : records) {
            List<String> row = new ArrayList<>();
            for (String s : record) {
                row.add(s);
            }
            rowList.add(row);
        }
        return rowList;
    }
//        另外两种实现方式：
//        while(recordIterator.hasNext()){ CSVRecord record = recordIterator.next();}
//        或者：
//        构建一个二维数组 (List<List>) 容纳数据
//        依次取出每一行，按找列数构建一个 List，最终将所有 List 放到一个大 List 中
//        records.forEach(record -> {
//            List<String> row = new ArrayList<>();
//            IntStream.range(0, columnNum).forEach(i -> {
//                row.add(record.get(i).trim());
//            });
//            rowList.add(row);
//        });


    /**
     * 根据参数配置 CSV 解析器
     *
     * @param reader 文件字符流
     * @param containsHeader 是否包含标题行 (标题行行尾不允许有逗号，标题行 header 不会被纳入解析结果)
     * @return CSV 解析器
     */
    protected CSVParser getCSVParser(Reader reader, boolean containsHeader) throws IOException {
        CSVParser parser;
        if (containsHeader) {  // 首行视为标题行 (header)，则解析结果中不包含首行
            parser = CSVFormat.RFC4180.withTrim().withFirstRecordAsHeader().parse(reader);
        } else {
            parser = CSVFormat.RFC4180.withTrim().parse(reader);  // 首行被视为数据内容
        }
        return parser;
    }


    /**
     * 使用 commons-csv 从 CSV 文件对象中解析出表格数据
     *
     * @param csvFile CSV 文件
     * @param containsHeader 是否包含标题行 (标题行行尾不允许有逗号，标题行 header 不会被纳入解析结果)
     * @return CSV 文件的表格数据
     */
    protected Iterable<CSVRecord> parseFile(File csvFile, boolean containsHeader){
        Iterable<CSVRecord> records = null;
        try (Reader reader = new FileReader(csvFile)) {
            CSVParser parser = this.getCSVParser(reader, containsHeader);
            records = parser.getRecords();
        } catch (IOException e){
            e.printStackTrace();
        }
        return records;
    }

}
