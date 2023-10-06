package com.alinesno.infra.common.web.adapter.login.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
import com.alinesno.infra.common.web.adapter.dto.menus.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CommonLoginController {

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBodyDto loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = UUID.randomUUID().toString() ;
        ajax.put(TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {

        Map<String, Object> data = new HashMap<>();
        // 将数据填充到data中...
        data.put("permissions", new String[]{"*:*:*"});

        Map<String, Object> user = new HashMap<>();
        user.put("createBy", "admin");
        user.put("createTime", "2023-04-23 16:11:38");
        user.put("updateBy", null);
        user.put("updateTime", null);
        user.put("remark", "管理员");
        user.put("userId", 1);
        user.put("deptId", 103);
        user.put("userName", "admin");
        user.put("nickName", "AIP技术团队");
        user.put("email", "aip-team@163.com");
        user.put("phonenumber", "15888888888");
        user.put("sex", "1");
        user.put("avatar", "");
        user.put("password", "");
        user.put("status", "0");
        user.put("delFlag", "0");
        user.put("loginIp", "");
        user.put("loginDate", "2023-09-21T16:54:12.000+08:00");

        Map<String, Object> dept = new HashMap<>();
        dept.put("createBy", null);
        dept.put("createTime", null);
        dept.put("updateBy", null);
        dept.put("updateTime", null);
        dept.put("remark", null);
        dept.put("deptId", 103);
        dept.put("parentId", 101);
        dept.put("ancestors", "0,100,101");
        dept.put("deptName", "研发部门");
        dept.put("orderNum", 1);
        dept.put("leader", "AIP技术团队");
        dept.put("phone", null);
        dept.put("email", null);
        dept.put("status", "0");
        dept.put("delFlag", null);
        dept.put("parentName", null);
        dept.put("children", new Object[]{});

        user.put("dept", dept);

        Map<String, Object> role = new HashMap<>();
        role.put("createBy", null);
        role.put("createTime", null);
        role.put("updateBy", null);
        role.put("updateTime", null);
        role.put("remark", null);
        role.put("roleId", 1);
        role.put("roleName", "超级管理员");
        role.put("roleKey", "admin");
        role.put("roleSort", 1);
        role.put("dataScope", "1");
        role.put("menuCheckStrictly", false);
        role.put("deptCheckStrictly", false);
        role.put("status", "0");
        role.put("delFlag", null);
        role.put("flag", false);
        role.put("menuIds", null);
        role.put("deptIds", null);
        role.put("permissions", null);
        role.put("admin", true);

        user.put("roles", new Object[]{role});

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", user.get("roles"));
        ajax.put("permissions", data.get("permissions"));

        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {

        Menu dashboardMenu = new Menu("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new Menu.Meta("仪盘表", "dashboard", false, null), List.of(
                new Menu("Dashboard", "index", false, false , "dashboard", new Menu.Meta("概览", "dashboard", false, null))
        ));

        Menu systemMenu = new Menu("System", "/system", false, "noRedirect", "Layout", true, new Menu.Meta("用户管理", "post", false, null),
                List.of(
                        new Menu("Tenant", "system/tenant/index", false,false,  "system/tenant/index", new Menu.Meta("用户标题", "tree", false, null)),
                        new Menu("User", "system/user/index", false,false,  "system/user/index", new Menu.Meta("用户群体", "user", false, null)) 
                ));

        Menu serviceMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("数据分析", "log", false, null),
                        List.of(
                                new Menu("Operlog", "monitor/operlog/index", false,false, "monitor/operlog/index", new Menu.Meta("事件分析", "form", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("漏斗分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("留存分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("分布分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("留存分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("LTV分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("会话分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("用户路径", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("归因分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("网页热力分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("属性分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("地域分析", "logininfor", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("间隔分析", "logininfor", false, null))
                 ));

        Menu marketingMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("元数据管理", "log", false, null),
                List.of(
                        new Menu("Operlog", "monitor/operlog/index", false,false, "monitor/operlog/index", new Menu.Meta("元事件", "form", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("事务属性", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("用户属性", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("维度表", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("物品属性", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("虚拟事件", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("虚拟属性", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("埋点事件", "logininfor", false, null))
                ));

        Menu channelMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("触达管理", "log", false, null),
                List.of(
                        new Menu("Operlog", "monitor/operlog/index", false,false, "monitor/operlog/index", new Menu.Meta("触达配置", "form", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("全局配置", "logininfor", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("触达渠道", "logininfor", false, null)) 
                ));

        Menu sourceMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("数据接入", "log", false, null),
                List.of(
                        new Menu("Operlog", "monitor/operlog/index", false,false, "monitor/operlog/index", new Menu.Meta("通用数据", "form", false, null)),
                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "monitor/logininfor/index", new Menu.Meta("埋点数据", "logininfor", false, null)) 
                ));

        List<Menu> menus = List.of(dashboardMenu , systemMenu, serviceMenu , marketingMenu , channelMenu , sourceMenu) ;

        return AjaxResult.success(menus) ;
    }
}