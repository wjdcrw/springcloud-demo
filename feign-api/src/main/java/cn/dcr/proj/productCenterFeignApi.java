package cn.dcr.proj;

import cn.dcr.proj.entity.ProductInfo;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dcr
 * @Description TODO
 * @Date 2020/5/13 16:01
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@FeignClient(name = "product‐center")
public interface productCenterFeignApi {
    /**
     * 声明式接口,远程调用http://product-center/selectProductInfoById/{productNo}
     * @param productNo
     * @return
     */
    @RequestMapping("/selectProductInfoById/{productNo}")
    ProductInfo selectProductInfoById(@Param("productNo") String productNo);
}
