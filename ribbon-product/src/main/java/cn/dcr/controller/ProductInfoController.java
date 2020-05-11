package cn.dcr.controller;

import cn.dcr.proj.entity.ProductInfo;
import cn.dcr.proj.mapper.ProductInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class ProductInfoController {
    @Value("server.port")
    private Integer port;
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @GetMapping("/selectProductInfoById/{productNo}")
    public Object selectProductInfoById(@PathVariable("productNo") String productNo){
        log.info("我被请求了：{}",port);
        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);
        return productInfo;
    }

    @PostMapping("/getKey")
    public String getSecretKey() throws InterruptedException {
        log.info("我被请求了:{}",port);
        Thread.sleep(3000);
        return "tulingKey";
    }
}
