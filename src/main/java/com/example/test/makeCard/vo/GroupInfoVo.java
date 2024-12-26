package com.example.test.makeCard.vo;

import lombok.Data;

import java.util.List;

@Data
public class GroupInfoVo {
    private String groupNo;
    private String groupName;
    private String groupType;
    private String visitType;
    private String urgentType;
    private String approvalNo;
    private String takePassportDate;
    private Integer approvedMemberNumber;
    private Integer approvedDays;
    private String orgCode;
    private List<VisitPlaceVo> visitPlaceList;
    private List<MemberVo> memberList;
}
