package com.xuxdon.shinycsv.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Indicator 用于指示 csv 中每个列下标对应的列名 column 和数据库字段名 field
 * 如：
 *  index     column      field
 * 第 0 列 --- 流水号 --- bill_id
 * 第 1 列 --- 金 额  --- amount
 *
 * @author  xuxdon
 * @since   0.1
 */
public class Indicator {
    private int size;
    private List<String> columnList;
    private List<String> fieldList;

    public Indicator(){
        this.columnList = new ArrayList<>();
        this.fieldList = new ArrayList<>();
    }

    public Indicator(List<String> columnList, List<String> fieldList){
        if (columnList.size() != fieldList.size()){
            // 报错，列名数量与字段数量不一致
            return;
        }
        this.size = fieldList.size();
        this.columnList = columnList;
        this.fieldList = fieldList;
    }


    public List<String> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<String> columnList) {
        this.columnList = columnList;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }


    public void add(String column, String field){
        this.columnList.add(column);
        this.fieldList.add(field);
    }

    public String getColumn(int i){
        return this.columnList.get(i);
    }

    public Stream<String> getColumnStream(){
        return this.columnList.stream();
    }

    public String getField(int i){
        return this.fieldList.get(i);
    }

    public Stream<String> getFieldStream(){
        return this.fieldList.stream();
    }

    public IntStream getIndexStream(){
        return IntStream.range(0, this.size);
    }
}
