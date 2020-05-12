package cn.dcr.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dcr
 * @Description //支付中心负载均衡
 * @Date 2020/5/12 16:19
 * @Param
 * @return
 **/
@Configuration
public class PayCenterRibbonConfig {

    @Bean
    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}
