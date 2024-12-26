package com.example.test.data.entity;


import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @ClassName FaHmPbPassportVisaEntity
 * @Author Xzd
 * @Date 2020/4/23
 * @Version V1.0
 **/
@Data
public class FaHmPbPassportVisaEntity {

    /**
     * 港澳团组号
     */
    private String groupId;
    /**
     * 出访地编号
     */
    private String placeId;
    /**
     * 出访地名称
     */
    private String placeName;
    /**
     * 出访人员编号
     */
    private String personId;
    /**
     * 出访成员编号
     */
    private String memberId;
    /**
     * 通行证号
     */
    private String passportId;

    /**
     * 签注有效开始日期
     */
    private LocalDate visaStartDate;

    /**
     * 签发人姓名
     */
    private String visePerson;

    /**
     * 签注号
     */
    private String viseNo;
    /**
     * 签注类型
     */
    private String viseType;
    /**
     * 签发时间（格式：yyyyMMdd）
     */
    private LocalDate issueDate;
    /**
     * 到期时间（格式：yyyyMMdd）
     */
    private LocalDate effectiveDate;
    /**
     * 出访地（HKG：香港，MAC：澳门）
     */
    private String visitPlaceCode;
    /**
     * 签注次数（1：一次，2：两次，3：多次）
     */
    private String viseTimes;
    /**
     * 签发机关编码
     */
    private String issueUnit;
    /**
     * 停留时间
     */
    private String stayDays;
    /**
     * 时间单位（1：天，2：月，3：年）
     */
    private String timeUnit;
    /**
     * 香港工作编号
     */
    private String hkWorkNo;
    /**
     * 签注索引
     */
    private String visaIndex;
    /**
     * MAC索引
     */
    private String macIndex;
    /**
     * MAC签名
     */
    private String macSign;
    /**
     * 限制出境日期
     */
    private LocalDate latestLeaveDate;
    /**
     * 白光照片base64数据
     */
    private String whiteLightImage;
    /**
     * 红光照片base64数据
     */
    private String redLightImage;
    /**
     * 紫光照片base64数据
     */
    private String violetLightImage;
    /**
     * FAC认证结果
     * （true 或者 false 为null时查验未返回数据）
     */
    private String facResult;

    /**
     * 打印结果编码
     */
    private String code;

    /**
     * 打印结果信息
     */
    private String msg;

    /**
     * 身份证号码
     */
    private String identitiesNum;

    /**
     * 签证是否取消打印状态
     * 0 未取消
     * 1 取消
     */
    private String visaCancelStatus;

    /**
     * 核查状态
     */
    private String checkStatus;

    /**
     * 注销状态
     */
    private String cancellationStatus;

    /**
     * 注销函文件ID
     */
    private String cancellationFile;
}
