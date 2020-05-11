package cn.dcr.controller;

import cn.dcr.proj.entity.PayInfo;
import cn.dcr.proj.mapper.PayInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PayInfoController {
    @Autowired
    private PayInfoMapper payInfoMapper;

    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    public PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        return payInfoMapper.selectPayInfoByOrderNo(orderNo);
    }

    @RequestMapping("/save")
    public String savePayInfo(@RequestBody PayInfo payInfo) {
        log.info("payInfo:{}",payInfo);
        return payInfo.getOrderNo();
    }
}
