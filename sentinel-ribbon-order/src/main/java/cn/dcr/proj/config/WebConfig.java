package cn.dcr.proj.config;

import cn.dcr.proj.handler.GlobalExceptionHandler;
import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/25 14:42
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@Configuration
public class WebConfig {
    @Bean
    @LoadBalanced
    @SentinelRestTemplate(
            blockHandler = "handleException",blockHandlerClass = GlobalExceptionHandler.class,
            fallback = "fallback",fallbackClass = GlobalExceptionHandler.class

    )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
