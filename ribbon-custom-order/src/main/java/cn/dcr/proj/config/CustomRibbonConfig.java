package cn.dcr.proj.config;

import cn.dcr.ribbonconfig.PayCenterRibbonConfig;
import cn.dcr.ribbonconfig.ProductCenterRibbonConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dcr
 * @Description 基于java代码细粒度配置
 * @Date 2020/5/12 16:34
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
/*@Configuration
@RibbonClients(value = {
        @RibbonClient(name = "product-center",configuration = ProductCenterRibbonConfig.class),
        @RibbonClient(name = "pay-center",configuration = PayCenterRibbonConfig.class)
})*/
/**
 * ribbon的全局配置
 */
public class CustomRibbonConfig {
}
