package com.xuxdon.shinycsv.test;

import com.xuxdon.shinycsv.convertor.CommonsConvertor;
import com.xuxdon.shinycsv.entity.Indicator;
import com.xuxdon.shinycsv.process.Processor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestCommonsCSV {

    /**
     * commons-csv 使用案例
     */
    @Test
    public void testOther() throws Exception{
        // 读取 CSV 文件内容
        File file = new File("/Users/xunan/temp/tr.csv");
        Reader in = new InputStreamReader(new FileInputStream(file));
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        // 创建指示器
        List<String> c = Arrays.asList("交易号", "商家订单号", "交易创建时间", "付款时间", "最近修改时间", "交易来源地", "类型", "交易对方", "商品名称", "金额（元）", "收/支", "交易状态", "服务费（元）", "成功退款（元）", "备注", "资金状态");
        List<String> f = Arrays.asList("transaction_id", "bill_id", "create_time", "purchase_time", "recent_modification_time", "location", "type", "merchant", "commodity", "amount", "orientation", "status", "tips", "refund", "memo", "fund_status");
        Indicator indicator = new Indicator(c, f);
        List<HashMap<String, String>> data = Processor.matchFieldAndColumns(
                CommonsConvertor.convertRecordsIntoList(records, indicator),
                indicator
        );

        data.forEach(System.out::println);

    }
}
