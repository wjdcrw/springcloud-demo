package cn.dcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonPayApplication.class,args);
    }
}
