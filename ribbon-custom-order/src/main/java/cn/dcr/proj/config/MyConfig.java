package cn.dcr.proj.config;

import cn.dcr.proj.myRule.MyWeightedRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author dcr
 * @Description TODO
 * @Date 2020/5/12 12:02
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@Configuration
public class MyConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule rule(){
        //return new RandomRule();
        return new MyWeightedRule();
    }
}
