package cn.dcr.proj.controller;

import cn.dcr.proj.feignapi.ProductCenterFeignApi;
import cn.dcr.proj.entity.ProductInfo;
import cn.dcr.proj.mapper.ProductInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/14 14:33
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@RestController
@Slf4j
public class ProductInfoController implements ProductCenterFeignApi {
    @Autowired
    ProductInfoMapper productInfoMapper;

    @RequestMapping("/selectProductInfoById/{productNo}")
    public ProductInfo selectProductInfoById(String productNo) {
        return productInfoMapper.selectProductInfoById(productNo);
    }

    @RequestMapping("/getToken4Header/{token}")
    public String getToken4Header(@RequestHeader("token") String token)  {
        log.info("token:{}",token);
        return token;
    }
}
