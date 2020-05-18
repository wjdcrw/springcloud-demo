package cn.dcr.proj.controller;

import cn.dcr.proj.PayCenterFeignApi;
import cn.dcr.proj.ProductCenterFeignApi;
import cn.dcr.proj.entity.OrderInfo;
import cn.dcr.proj.entity.PayInfo;
import cn.dcr.proj.entity.ProductInfo;
import cn.dcr.proj.mapper.OrderInfoMapper;
import cn.dcr.proj.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/14 14:49
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@RestController
public class OrderInfoController {
    @Autowired
    ProductCenterFeignApi productCenterFeignApi;
    @Autowired
    PayCenterFeignApi payCenterFeignApi;
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo){
        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null==orderInfo){
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }
        ProductInfo productInfo = productCenterFeignApi.selectProductInfoById(orderNo);
        if(null==productInfo){
            return "没有对应的商品";
        }
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderInfo.getOrderNo());
        orderVo.setUserName(orderInfo.getUserName());
        orderVo.setProductName(productInfo.getProductName());
        orderVo.setProductNum(orderInfo.getProductCount());

        return orderVo;
    }

    @RequestMapping("/testFeignInterceptor")
    public String testFeignInterceptor() {
        return productCenterFeignApi.getToken4Header("666");
    }

    @RequestMapping("/getPayInfoByOrderNo/{orderNo}")
    public PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        return payCenterFeignApi.selectPayInfoByOrderNo(orderNo);
    }

}
