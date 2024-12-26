package com.example.test.data.mapper;


import com.example.test.data.entity.FaHmPbPassportEntity;
import com.example.test.data.entity.FaHmPbPassportVisaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 赴港澳附件表
 * @author lqy
 * @date 2019-07-20 23:23:24
 */
@Mapper
public interface FaHmPbPassportVisaMapper {

    @Select("select * from fa_hm_pb_passport_visa where vise_no = #{viseNo}")
    FaHmPbPassportVisaEntity getVisaEntity(String viseNo);

}
