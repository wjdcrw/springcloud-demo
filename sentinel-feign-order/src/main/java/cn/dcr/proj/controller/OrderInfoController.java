package cn.dcr.proj.controller;

import cn.dcr.proj.entity.OrderInfo;
import cn.dcr.proj.entity.ProductInfo;
import cn.dcr.proj.feignapi.ProductCenterFeignApiWithSentinel;
import cn.dcr.proj.handler.ProductCenterFeignApiWithSentinelFallback;
import cn.dcr.proj.mapper.OrderInfoMapper;
import cn.dcr.proj.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/22 11:21
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@RestController
public class OrderInfoController {
    @Autowired
    private ProductCenterFeignApiWithSentinel productCenterFeignApiWithSentinel;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ProductInfo productInfo = productCenterFeignApiWithSentinel.selectProductInfoById(orderNo);

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
}
