package cn.dcr.proj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author dcr
 * @Description 用于模拟链路
 * @Date 2020/5/21 14:26
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@Service
public class OrderServiceImpl {
    @SentinelResource("common")
    public String common(){return "common";}
}
