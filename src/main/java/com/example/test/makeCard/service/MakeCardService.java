package com.example.test.makeCard.service;

import com.example.test.makeCard.vo.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MakeCardService {
    String getToken();

    void makeCard(MakeCardVo makeCardVo);
    QueryVo query(String serverIp, String orgCode);

    PassportCheckVo inspection(String serverIp,
                               String orgCode,
                               String passportNo,
                               String overtime);

    void makeVisa(MakeVisaVo makeVisaVo);

    QueryVo queryVisa(String serverIp, String orgCode);

    VisaCheckVo checkVisa(String serverIp,
                          String orgCode,
                          String viseNo,
                          String visitPlaceCode,
                          String overtime);
    List<GroupInfoVo>  getGroupInfo(GroupInfo groupInfo);
}
