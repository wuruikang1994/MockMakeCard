package com.example.test.makeCard.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class visaVo {
    private String visitPlaceCode;
    private String issueUnitCode;
    private String issueUnitAreaCode;
    private String specialViseType;
    private String viseMode;
    private Boolean isRevokeOldVise;
    private Integer visePeriod;
    private String viseType;
    private Integer stayDays;
    private String timeUnit;
    private Integer viseTimes;
    private LocalDate issueDate;
    private LocalDate effectiveDate;
    private String hkWorkNo;
}
