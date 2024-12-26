package com.example.test.data.mapper;


import com.example.test.data.entity.FaHmPbPassportEntity;
import com.example.test.data.entity.TestEntity;
import org.apache.ibatis.annotations.*;

/**
 * 护照表
 *
 * @author secloud code generator
 * @date 2019-09-18 15:37:06
 */
@Mapper
public interface TestMapper {

    @Select("select * from test where member_no = #{memberNo}")
    TestEntity selectPassportByNo(String memberNo);

    @Insert("insert into test(server_ip,member_no, org_code,passport_no,visa_no ) values (#{serverIp},#{memberNo}, #{orgCode}, #{passportNo}, #{visaNo})")
    void insertEntity(TestEntity testEntity);

    @Update("update test set server_ip=#{serverIp},member_no=#{memberNo}, org_code=#{orgCode},passport_no=#{passportNo},visa_no=#{visaNo},passport_check=#{passportCheck},visa_check = #{visaCheck} where member_no = #{memberNo}")
    void updateEntity(TestEntity testEntity);


    @Select("select passport_no from test where server_ip = #{serverIp} and org_code=#{orgCode} AND visa_no IS NULL AND passport_check IS NULL")
    String getPassport(@Param("serverIp") String serverIp, @Param("orgCode") String orgCode);

    @Update("update test set passport_check= '1',member_no = #{memberId} where passport_no = #{passportNo}")
    void updateEntityByNo(@Param("passportNo") String passportNo,@Param("memberId") String memberId) ;

    @Select("select passport_no from test where server_ip = #{serverIp} and org_code=#{orgCode} AND visa_no IS NOT NULL AND visa_check = '3'")
    String getPassportByVisa(@Param("serverIp") String serverIp, @Param("orgCode") String orgCode);

    @Update("update test set visa_check= '1' where vise_no = #{viseNo}")
    void updateVisaCheck(@Param("viseNo") String viseNo);
}
