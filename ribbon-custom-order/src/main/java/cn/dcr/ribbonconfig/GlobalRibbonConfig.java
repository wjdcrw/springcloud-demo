package cn.dcr.ribbonconfig;

import cn.dcr.proj.myRule.MyWeightedRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dcr
 * @Description 全局配置
 * @Date 2020/5/12 14:46
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@Configuration
public class GlobalRibbonConfig {
    @Bean
    public IRule theSameClusterPriorityRule() {
        return new MyWeightedRule();
        //return new TheSameClusterPriorityRule();
        //return new TheSameClusterPriorityWithVersionRule();
    }
}
