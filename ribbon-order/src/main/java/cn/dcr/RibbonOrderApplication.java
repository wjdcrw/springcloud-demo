package cn.dcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author duanchengrui
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonOrderApplication.class,args);
    }
}
