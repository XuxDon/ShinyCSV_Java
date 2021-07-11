package com.xuxdon.shinycsv.process;

import com.xuxdon.shinycsv.entity.Indicator;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 处理以 List&lt;List&lt;String&gt;&gt; 对象封装的纯 CSV 数据 (不含表头、标题行等信息)
 *
 * @author  xuxdon
 */
public class Processor {

    /**
     * 建立数据库表的字段名与各列数据的映射关系
     *
     * @param rowList 每个元素对应 CSV 文件和数据库表的一行
     * @param indicator indicator 的 fieldList 按下标 0、1、2 ... 的顺序，给出了 CSV 文件从左至右每列数据在数据库表中对应的字段名
     * @return List&lt;HashMap&gt; 中每个元素也对应 CSV 文件和数据库表的一行，但每行对应的表字段保存在 key 中，数据保存在 value 中
     */
    public static List<HashMap<String, String>> matchFieldAndColumns(List<List<String>> rowList, Indicator indicator){
        List<HashMap<String, String>> entityList = rowList.stream()
                .map(row -> {
                    HashMap<String, String> entity = new HashMap<>();
                    indicator.getIndexStream().forEach(i -> {
                        entity.put(indicator.getField(i), row.get(i));
                    });
                    return entity;
                })
                .collect(Collectors.toList()); // 收集 entity 获得 entityList
        return entityList;
    }

}
