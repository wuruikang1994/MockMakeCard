package com.example.test.makeCard.service.impl;

import com.example.test.data.entity.FaHmPbPassportEntity;
import com.example.test.data.entity.FaHmPbPassportVisaEntity;
import com.example.test.data.entity.TestEntity;
import com.example.test.data.mapper.FaHmPbPassportMapper;
import com.example.test.data.mapper.FaHmPbPassportVisaMapper;
import com.example.test.data.mapper.MakeCardMapper;
import com.example.test.data.mapper.TestMapper;
import com.example.test.makeCard.service.MakeCardService;
import com.example.test.makeCard.vo.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


@Service
public class MakeCardServiceImpl implements MakeCardService {
    @Autowired
    private FaHmPbPassportMapper faHmPbPassportMapper;

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private FaHmPbPassportVisaMapper faHmPbPassportVisaMapper;

    @Autowired
    private MakeCardMapper makeCardMapper;

    @Override
    public String getToken() {
        //生成UUID
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        String token = uuid.replaceAll("-", "");
        JSONObject json = new JSONObject();
        json.put("token", token);
        json.put("expiresin", 3600);
        return json.toJSONString();
    }


    public void makeCard(MakeCardVo makeCardVo){

    }



    @Override
    public QueryVo query(String serverIp, String orgCode) {
        TestEntity testEntity = new TestEntity();
        testEntity.setServerIp(serverIp);
        testEntity.setOrgCode(orgCode);
        Random random = new Random();
        int n = random.nextInt(99999999);
        String passportNo = "T" + n;
        testEntity.setPassportNo(passportNo);
        testMapper.insertEntity(testEntity);

        QueryVo query = new QueryVo();
        query.setProcess("3");
        query.setMessage("打印成功");
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "成功");
        result.put("passportNo", passportNo);
        result.put("identitiesNum", "110101197105142611");
        result.put("mrz1", "mrz1mrz1mrz1mrz1mrz1mrz1mrz1");
        result.put("mrz2", "mrz2mrz2mrz2mrz2mrz2mrz2mrz2");
        result.put("issueDate", LocalDate.now().toString());
        result.put("effectiveDate", LocalDate.now().plusYears(5).toString());
        query.setResult(result);
        return query;
    }

    @Override
    public PassportCheckVo inspection(String serverIp, String orgCode, String passportNo, String overtime) {
        PassportCheckVo checkVo = makeCardMapper.getUserInfo(passportNo);
        checkVo.setPassportNo(passportNo);
        checkVo.setIssueUnit(orgCode);
        checkVo.setMrz1("mrz1mrz1mrz1mrz1mrz1mrz1mrz1");
        checkVo.setMrz2("mrz2mrz2mrz2mrz2mrz2mrz2mrz2");
        String filePath = "src/main/resources/static/123.jpg";
        Path path = Paths.get(filePath);
        byte[] fileBytes = null;
        try {
            fileBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileBase64 = Base64.getEncoder().encodeToString(fileBytes);
        checkVo.setWhiteLightImage(fileBase64);
        checkVo.setRedLightImage(fileBase64);
        checkVo.setVioletLightImage(fileBase64);
        checkVo.setChipImage(fileBase64);
        checkVo.setMrzResult(true);
        checkVo.setBacResult(true);
        checkVo.setFacResult(true);
        checkVo.setDg15Result(true);
        checkVo.setSodResult(true);
        checkVo.setCscaResult(true);
        checkVo.setFinger1Result(true);
        checkVo.setFinger2Result(true);
        checkVo.setIdentitiesNumResult(true);
        checkVo.setDg1Result(true);
        checkVo.setDg2Result(true);
        checkVo.setDg11Result(true);
        testMapper.updateEntityByNo(passportNo,checkVo.getMemberId());
        return checkVo;
    }

    @Override
    public void makeVisa(MakeVisaVo makeVisaVo) {
        TestEntity testEntity = testMapper.selectPassportByNo(makeVisaVo.getMemberNo());
        testEntity.setVisaNo(makeVisaVo.getViseNo());
        testEntity.setVisaCheck("3");
        testMapper.updateEntity(testEntity);
    }

    @Override
    public QueryVo queryVisa(String serverIp,String orgCode) {
        QueryVo query = new QueryVo();
        query.setProcess("3");
        query.setMessage("打印成功");
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "成功");
        String passport = testMapper.getPassportByVisa(serverIp, orgCode);
        result.put("passportNo", passport);
        result.put("issueDate", LocalDate.now().toString());
        result.put("visaStartDate", LocalDate.now().toString());
        result.put("effectiveDate", LocalDate.now().plusYears(5).toString());
        result.put("visePerson", "张三");
        query.setResult(result);
        return query;
    }

    @Override
    public VisaCheckVo checkVisa(String serverIp, String orgCode, String viseNo, String visitPlaceCode, String overtime) {
        VisaCheckVo checkVo = new VisaCheckVo();
        FaHmPbPassportVisaEntity visaEntity = faHmPbPassportVisaMapper.getVisaEntity(viseNo);
        checkVo.setPassportNo(visaEntity.getPassportId());
        checkVo.setViseNo(viseNo);
        checkVo.setViseType("1");
        checkVo.setIssueDate(LocalDate.now().toString().replaceAll("-", ""));
        checkVo.setEffectiveDate(LocalDate.now().plusYears(5).toString().replaceAll("-", ""));
        checkVo.setViseTimes("1");
        checkVo.setIssueUnit(orgCode);
        checkVo.setStayDays("90");
        checkVo.setTimeUnit("1");
        String filePath = "src/main/resources/static/123.jpg";
        Path path = Paths.get(filePath);
        byte[] fileBytes = null;
        try {
            fileBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileBase64 = Base64.getEncoder().encodeToString(fileBytes);
        checkVo.setWhiteLightImage(fileBase64);
        checkVo.setRedLightImage(fileBase64);
        checkVo.setVioletLightImage(fileBase64);
        checkVo.setFacResult(true);
        checkVo.setVisitPlaceCode(visitPlaceCode);
        checkVo.setLatestLeaveDate(LocalDate.now().toString().replaceAll("-", ""));

        testMapper.updateVisaCheck(viseNo);
        return checkVo;
    }

    @Override
    public List<GroupInfoVo> getGroupInfo(GroupInfo groupInfo) {
        String groupNo = "";
        Object groupObject = groupInfo.getJson().get("groupNo");
        List<String> groupNos = (List<String>) groupObject;
        groupNo = groupNos.get(0);
        GroupInfoVo groupInfoVo = makeCardMapper.getGroupInfo(groupNo);
        groupInfoVo.setGroupNo(groupNo);
        List<visaVo> visaInfo = makeCardMapper.getVisa(groupNo);

        List<MemberVo> memberInfo = makeCardMapper.getMemberInfo(groupNo);
        memberInfo.forEach(member -> {
            member.setViseList(visaInfo);
        });
        groupInfoVo.setMemberList(memberInfo);
        List<VisitPlaceVo> visitInfo = new ArrayList<>();
        groupInfoVo.setVisitPlaceList(visitInfo);
        List<GroupInfoVo> groupInfoVos = new ArrayList<>();
        groupInfoVos.add(groupInfoVo);
        return groupInfoVos;
    }
}
