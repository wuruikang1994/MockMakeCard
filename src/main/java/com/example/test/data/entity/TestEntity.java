package com.example.test.data.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * test表
 * 
 * @ClassName: FaHmPbPassport
 * @author lqy
 * @date 2019年9月18日 下午3:39:01
 */
@Data
public class TestEntity {

	/**
	 * 服务IP
	 */
	private String serverIp;

	/**
	 * 成员号
	 */
	private String memberNo;

	/**
	 * 机构编码
	 */
	private String orgCode;


	/**
	 * 通行证号
	 */
	private String passportNo;

	/**
	 * 通行证查验
	 */
	private String passportCheck;


	/**
	 * 签注号
	 */
	private String visaNo;

	/**
	 * 签注查验 3等待查验
	 */
	private String visaCheck;


}
