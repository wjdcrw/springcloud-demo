package cn.dcr.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dcr
 * @Description //
 * @Date 2020/5/12 16:20
 * @Param
 * @return
 **/
@Configuration
public class ProductCenterRibbonConfig {

    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
