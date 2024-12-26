package com.example.test.data.mapper;


import com.example.test.data.entity.FaHmPbPassportEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 护照表
 *
 * @author secloud code generator
 * @date 2019-09-18 15:37:06
 */
@Mapper
public interface FaHmPbPassportMapper {

    @Select("select * from fa_hm_pb_passport where passport_id = #{passportNo}")
    FaHmPbPassportEntity getPassportEntity(String passportNo);

}
