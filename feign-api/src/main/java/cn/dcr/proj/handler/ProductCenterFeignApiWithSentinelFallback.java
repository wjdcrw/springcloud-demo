package cn.dcr.proj.handler;


import cn.dcr.proj.entity.ProductInfo;
import cn.dcr.proj.feignapi.ProductCenterFeignApi;
import cn.dcr.proj.feignapi.ProductCenterFeignApiWithSentinel;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/11/28.
 */
@Component
public class ProductCenterFeignApiWithSentinelFallback implements ProductCenterFeignApiWithSentinel {
    @Override
    public ProductInfo selectProductInfoById(String productNo) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("默认商品");
        return productInfo;
    }
}
