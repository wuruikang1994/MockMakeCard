package com.example.test.makeCard.vo;
import lombok.Data;
import net.minidev.json.JSONObject;

@Data
public class QueryVo {

    /**
     * 进度信息
     */
    private String process;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 结果集
     */
    private JSONObject result;




}
