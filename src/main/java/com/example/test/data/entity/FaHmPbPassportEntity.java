package com.example.test.data.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 护照表
 * 
 * @ClassName: FaHmPbPassport
 * @author lqy
 * @date 2019年9月18日 下午3:39:01
 */
@Data
public class FaHmPbPassportEntity {

	/** 护照号 */
	private String passportId;
	/** 创建机关ID */
	private String createCorpId;
	/** 港澳通行证类型 */
	private String passportType;
	/** 人员ID */
	private String personId;
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sex;
	/** 出生日期 */
	private LocalDate birthday;
	/** 拼音 */
	private String pinyin;
	/** 出生地 */
	private String birthplace;
	/** 证件类型 */
	private String cardType;
	/** 证件号 */
	private String cardNo;
	/** 外事机关ID */
	private String printCorpId;
	/** 签发机关单位ID */
	private String issueCorpId;
	/** 签发地 */
	private String issuePlace;
	/** 签发时间 */
	private LocalDate issueDate;
	/** 有效截止日期 */
	private LocalDate realEffectDate;
	/** 证件年限 */
	private Integer validPeriod;
	/** 打印人 */
	private String printPerson;
	/** 打印时间 */
	private LocalDate printTime;
	/** 港澳通行证有效状态（1有效/0无效） */
	private String validStatus;
	/** 在库状态 */
	private String stockStatus;
	/** 是否下发115001-已下发 115002-未下发 */
	private String deputed;
	/** 保管单位 */
	private String deputeDept;
	/** 保管单位名称 */
	private String deputeDeptName;
	/** 备注 */
	private String notes;
	/** 申报单位编码 */
	private String applyUnit;
	/** 申报单位名称 */
	private String applyUnitName;
	/** 工作单位编码 */
	private String workUnit;
	/** 工作单位名称 */
	private String workUnitName;
	/** 入库日期 */
    private LocalDateTime inStorageTime;
    /** 出库日期 */
    private LocalDateTime outStorageTime;
    /** 护照当前所在单位 */
    private String currentDeputeDept;
    /** 护照当前所在单位名称 */
    private String currentDeputeDeptName;
	/** 通行证补录状态 */
	private String supplementaryRecordStatus;
	/** 通行证补录备注 */
	private String supplementaryRecordRemarks;
	/** 签注补录状态 */
	private String endorsementSupplementaryRecordStatus;
	/** 签注补录备注 */
	private String endorsementSupplementaryRecordRemarks;

	private String deptId;

	/**
	 * 注销状态0-恢复 1-注销
	 */
	private Integer cancelStatus;
}
