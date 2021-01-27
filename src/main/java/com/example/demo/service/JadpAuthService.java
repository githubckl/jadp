package com.example.demo.service;

import com.example.demo.util.CommonResult;
import com.example.demo.util.HttpClientUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class JadpAuthService {
    private static final String AUTH_URL = "http://172.16.68.80/api/jadp/auth";
/*获取当前用户信息*/
    public static Object getCurrentUser(HttpServletRequest request) {
        try {
            Map map = new HashMap<>();
            map.put("access-token", HttpClientUtils.getAuthToken(request));
            return new CommonResult<>().success(HttpClientUtils.doGet("/currentUser", map));
        } catch (Exception e) {
            return new CommonResult<>().failed(e.getMessage());
        }
    }
    /*获取所有用户故信息*/
    public static Object currentAllUsers(HttpServletRequest request){
        try {
            Map map = new HashMap<>();
            map.put("access-token", HttpClientUtils.getAuthToken(request));
            return new CommonResult<>().success(HttpClientUtils.doGet("/currentAllUsers", map));
        } catch (Exception e) {
            return new CommonResult<>().failed(e.getMessage());
        }
    }
}
