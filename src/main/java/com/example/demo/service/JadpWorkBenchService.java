package com.example.demo.service;

import com.example.demo.util.CommonResult;
import com.example.demo.util.HttpClientUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class JadpWorkBenchService {
    private static final String WORKBENCH_URL = "http://172.16.68.80/api/jadp/workbench";
/*获取待办列表*/
    public static Object getTodos(HttpServletRequest request) {
        try {
            Map map = new HashMap<>();
            map.put("access-token", HttpClientUtils.getAuthToken(request));
            return new CommonResult<>().success(HttpClientUtils.doGet("/todos/search", map));
        } catch (Exception e) {
            return new CommonResult<>().failed(e.getMessage());
        }
    }
    /*已办列表*/
    public static Object getDones(HttpServletRequest request){
        try {
            Map map = new HashMap<>();
            map.put("access-token", HttpClientUtils.getAuthToken(request));
            return new CommonResult<>().success(HttpClientUtils.doGet("/dones/queryDoneList", map));
        } catch (Exception e) {
            return new CommonResult<>().failed(e.getMessage());
        }
    }
    /*消息信息列表*/
    public static Object getMessages(HttpServletRequest request){
        try {
            Map map = new HashMap<>();
            map.put("access-token", HttpClientUtils.getAuthToken(request));
            return new CommonResult<>().success(HttpClientUtils.doGet("/messages/search", map));
        } catch (Exception e) {
            return new CommonResult<>().failed(e.getMessage());
        }
    }
}
