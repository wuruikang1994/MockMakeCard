package com.example.test.makeCard.controller;

import com.example.test.makeCard.service.MakeCardService;
import com.example.test.makeCard.vo.*;
import com.example.test.reslut.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dataexch/api")
public class GetTokenController {
    @Autowired
    private MakeCardService makeCardService;

    /**
     * 获取token
     * @param tokenVo tokenVo
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<java.lang.String>
    */
    @PostMapping("/token/get.json")
    public R<String> getToken(@RequestBody TokenVo tokenVo) {
        R<String> r = new R<>();
        try {
            String token = makeCardService.getToken();
            r.setData(token);
        }catch (Exception e){
            r.setStatus(-1);
            r.setMsg(e.getMessage());
        }
        return r;
    }

    /**
     * 通行证上报
     * @param passportSubmit passportSubmit
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<java.lang.String>
    */
    @PostMapping("/passport/upload.json")
    public R<String> upload(@RequestBody PassportSubmit passportSubmit) {
        R<String> r = new R<>();
        r.setMsg("success");
        return r;
    }

    /**
     * 制证团组查询
     * @param groupInfo groupInfo
     * @author 吴瑞康
     * @since 2024年12月26日
     * @return com.example.test.reslut.R<java.util.List<com.example.test.makeCard.vo.GroupInfoVo>>
    */
    @PostMapping("/group/query.json")
    public R<List<GroupInfoVo>> query(@RequestBody GroupInfo groupInfo) {
        R<List<GroupInfoVo>> r = new R<>();
        List<GroupInfoVo> list = makeCardService.getGroupInfo(groupInfo);
        r.setData(list);
        r.setMsg("success");
        return r;
    }
}
