package com.atguigu.myzhxy.controller;


import com.atguigu.myzhxy.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理员控制器")
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {
    @Autowired
    private AdminService adminService;


}
