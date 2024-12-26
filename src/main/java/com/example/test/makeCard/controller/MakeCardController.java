package com.example.test.makeCard.controller;

import com.example.test.makeCard.service.MakeCardService;
import com.example.test.makeCard.vo.*;
import com.example.test.reslut.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/production/restful/ct")
public class MakeCardController {
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
     * 制证
     * @param makeCardVo makeCardVo
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<java.lang.String>
    */
    @PostMapping("/passport/make/upload.json")
    public R<String> makeCard(@RequestBody MakeCardVo makeCardVo) {
        R<String> r = new R<>();
        makeCardService.makeCard(makeCardVo);
        r.setMsg("制证成功");
        return r;
    }

    /**
     * 查询制证结果
     * @param serverIp serverIp
     * @param orgCode orgCode
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<java.lang.String>
    */
    @GetMapping("/passport/query.json")
    public R<QueryVo> query(@RequestParam("serverIp") String serverIp, @RequestParam("orgCode") String orgCode) {
        R<QueryVo> r = new R<>();
        QueryVo query = makeCardService.query(serverIp,orgCode);
        r.setData(query);
        return r;
    }
    /**
     * 通行证查验
     * @param serverIp serverIp
     * @param orgCode orgCode
     * @param passportNo passportNo
     * @param overtime overtime
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<com.example.test.makeCard.vo.PassportCheckVo>
    */
    @GetMapping("/passport/inspection.json")
    public R<PassportCheckVo> inspection(@RequestParam("serverIp") String serverIp,
                                 @RequestParam("orgCode") String orgCode,
                                 @RequestParam("passportNo") String passportNo,
                                 @RequestParam("overtime") String overtime) {
        R<PassportCheckVo> r = new R<>();
        PassportCheckVo checkVo = makeCardService.inspection(serverIp, orgCode, passportNo, overtime);
        r.setData(checkVo);
        return r;
    }

    /**
     * 签注打印
     * @param makeVisaVo makeVisaVo
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<java.lang.String>
    */
    @PostMapping("/endorsement/print/upload.json")
    public R<String> makeVisa(@RequestBody MakeVisaVo makeVisaVo) {
        R<String> r = new R<>();
        makeCardService.makeVisa(makeVisaVo);
        r.setMsg("签注打印成功");
        return r;
    }

    /**
     * 签注打印查询
     * @param serverIp serverIp
     * @param orgCode orgCode
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<com.example.test.makeCard.vo.QueryVo>
    */
    @GetMapping("/endorsement/query.json")
    public R<QueryVo> queryVisa(@RequestParam("serverIp") String serverIp, @RequestParam("orgCode") String orgCode) {
        R<QueryVo> r = new R<>();
        QueryVo query = makeCardService.queryVisa(serverIp,orgCode);
        r.setData(query);
        return r;
    }

    /**
     * 签注查验
     * @param serverIp serverIp
     * @param orgCode orgCode
     * @author 吴瑞康
     * @since 2024年12月16日
     * @return com.example.test.reslut.R<com.example.test.makeCard.vo.QueryVo>
     */
    @GetMapping("/endorsement/inspection.json")
    public R<VisaCheckVo> checkVisa(@RequestParam("serverIp") String serverIp,
                                @RequestParam("orgCode") String orgCode,
                                @RequestParam("viseNo") String viseNo,
                                @RequestParam("visitPlaceCode") String visitPlaceCode,
                                @RequestParam("overtime") String overtime
                                ) {
        R<VisaCheckVo> r = new R<>();
        VisaCheckVo checkVo = makeCardService.checkVisa(serverIp, orgCode, viseNo, visitPlaceCode, overtime);
        r.setData(checkVo);
        return r;
    }

}
