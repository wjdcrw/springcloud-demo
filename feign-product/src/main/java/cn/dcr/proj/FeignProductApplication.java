package cn.dcr.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignProductApplication.class, args);
    }

}
