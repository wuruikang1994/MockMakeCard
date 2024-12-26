package com.example.test.makeCard.vo;
import lombok.Data;
import net.minidev.json.JSONObject;

@Data
public class PassportCheckVo {
    String memberId;
    String passportNo;
    String identitiesNum;
    String memberName;
    String birthDate;
    String sex;
    String birthPlace;
    String issueUnit;
    String mrz1;
    String mrz2;
    String whiteLightImage;
    String redLightImage;
    String violetLightImage;
    String chipImage;
    boolean mrzResult;
    boolean bacResult;
    boolean facResult;
    boolean dg15Result;
    boolean sodResult;
    boolean cscaResult;
    boolean finger1Result;
    boolean finger2Result;
    boolean identitiesNumResult;
    boolean dg1Result;
    boolean dg2Result;
    boolean dg11Result;

}
