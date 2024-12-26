package com.example.test.makeCard.vo;
import lombok.Data;
import net.minidev.json.JSONObject;

@Data
public class TokenVo {
    private String appId;
    private long time;
    private String nonce;
    private String sign;
}
