package cn.dcr.controller;

import cn.dcr.proj.entity.OrderInfo;
import cn.dcr.proj.entity.ProductInfo;
import cn.dcr.proj.mapper.OrderInfoMapper;
import cn.dcr.proj.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderInfoController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);

        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ResponseEntity<ProductInfo> responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity("http://product-center/selectProductInfoById/"+orderInfo.getProductNo(), ProductInfo.class);

        }catch (Exception e) {
            log.error("请求商品服务异常:{}",e.getMessage());
            System.out.println(e.getStackTrace());
        }

        ProductInfo productInfo = responseEntity.getBody();

        if(productInfo == null) {
            return "没有对应的商品";
        }

        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderInfo.getOrderNo());
        orderVo.setUserName(orderInfo.getUserName());
        orderVo.setProductName(productInfo.getProductName());
        orderVo.setProductNum(orderInfo.getProductCount());

        return orderVo;
    }

    @RequestMapping("/getKey")
    public String getKey() {
        return restTemplate.postForObject("http://product-center/getKey",null,String.class);
    }

}
