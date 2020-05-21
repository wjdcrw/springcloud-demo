package cn.dcr.proj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *热点数据
 */
@RestController
@Slf4j
public class HotParamController {
    @SentinelResource("order-skill")
    @RequestMapping("/orderSave")
    public String saveOrder(@RequestParam(value = "userId",required = false) String userId,
                            @RequestParam(value = "productId",required = false)String productId){
        log.info("userId:{}",userId);
        log.info("productId:{}",productId);
        return userId;
    }
}
