package com.xuxdon.shinycsv.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ShinyCSV 的数据对象
 * {"": "", "": ""}
 *
 * Crafted in ...
 *
 * @author  xuxdon
 * @since   0.1
 */
public class DataObject {
    private LinkedHashMap<String, String> columnsAndFields;
    private List<HashMap<String, String>> data;

    public DataObject(){}

    public LinkedHashMap<String, String> getColumnsAndFields() {
        return this.columnsAndFields;
    }

    public void setColumnsAndFields(LinkedHashMap<String, String> columnsAndFields) {
        this.columnsAndFields = columnsAndFields;
    }

    public List<HashMap<String, String>> getData() {
        return data;
    }

    public void setData(List<HashMap<String, String>> data) {
        this.data = data;
    }

}
