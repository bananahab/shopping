package com.beauty.shopping.controller;

import com.beauty.shopping.common.api.CommonResult;
import com.beauty.shopping.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wuzhenxian
 * @date 2021/03/03
 * 登录注册管理Controller
 */
@Controller
@Api(tags = "UmsMemberController")
@RequestMapping("/sso")
public class UmsMemberController {

    @Resource
    private UmsMemberService umsMemberService;

    @GetMapping(value = "/getAuthCode")
    @ApiOperation("获取验证码")
    @ResponseBody
    public CommonResult getAuthCode(String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @GetMapping(value = "/verifyAuthCode")
    @ApiOperation("校验验证码")
    @ResponseBody
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }

    @PostMapping(value = "/login")
    @ApiOperation("用户名密码登录")
    @ResponseBody
    public CommonResult login(@RequestParam("userName") String userName, @RequestParam("password") String password) {

    }
}
