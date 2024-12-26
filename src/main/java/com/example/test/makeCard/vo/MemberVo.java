package com.example.test.makeCard.vo;

import lombok.Data;

import java.util.List;

@Data
public class MemberVo {
    private String memberNo;
    private String identitiesType;
    private String identitiesNum;
    private String workUnit;
    private String surnameCn;
    private String givenNameCn;
    private String surnameEn;
    private String givenNameEn;
    private String sex;
    private String photoId;
    private String professionCategory;
    private String birthDate;
    private String birthPlace;
    private String passportVersionNum;
    private String previousPassportNo;
    private String nation;
    private String holdPassportStatus;
    private String passportNo;
    private String passportType;
    private String issueUnitCode;
    private String issueUnitAreaCode;
    private String morder;
    private String period;
    private String notCollectReason;
    private String isCollect;
    private List<visaVo> viseList;
}