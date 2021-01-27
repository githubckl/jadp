package com.example.demo.service;

import com.example.demo.util.CommonResult;
import com.example.demo.util.HttpClientUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class JadpPersonnelService {
    private static final String PERSONNEL_URL = "http://172.16.68.80/api/jadp/personnel";

    public static Object getCurrentUser(HttpServletRequest request) {
        try {
            Map map = new HashMap<>();
            map.put("access-token", HttpClientUtils.getAuthToken(request));
            return new CommonResult<>().success(HttpClientUtils.doGet("", map));
        } catch (Exception e) {
            return new CommonResult<>().failed(e.getMessage());
        }
    }
}
