package com.example.test.data.mapper;

import com.example.test.makeCard.vo.GroupInfoVo;
import com.example.test.makeCard.vo.MemberVo;
import com.example.test.makeCard.vo.PassportCheckVo;
import com.example.test.makeCard.vo.visaVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MakeCardMapper {

    PassportCheckVo getUserInfo(@Param("passportId") String passportId);


    GroupInfoVo getGroupInfo(@Param("groupId") String groupId);

    List<MemberVo> getMemberInfo(@Param("groupId") String groupId);

    List<visaVo> getVisa(@Param("groupId") String groupId);
}
