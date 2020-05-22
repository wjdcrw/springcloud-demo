package cn.dcr.proj.feignapi;

import cn.dcr.proj.entity.ProductInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by smlz on 2019/11/22.
 */



/*
@FeignClient(name = "product-center",fallback = ProductCenterFeignApiWithSentinelFallback.class)
*/
//@FeignClient(name = "product-center",fallbackFactory = ProductCenterFeignApiWithSentinelFallback.class)
public interface ProductCenterFeignApiWithSentinel {

    /**
     * 声明式接口,远程调用http://product-center/selectProductInfoById/{productNo}
     * @param productNo
     * @return
     */
    @RequestMapping("/selectProductInfoById/{productNo}")
    ProductInfo selectProductInfoById(@PathVariable("productNo") String productNo);

}
