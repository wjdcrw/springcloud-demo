package cn.dcr.proj.controller;

import org.springframework.web.client.RestTemplate;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/21 13:55
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
public class testSentinelRule {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate=new RestTemplate();
        for(int i=0;i<1000;i++){
            try{
                restTemplate.postForObject("http://localhost:8081/saveOrder",null,String.class);
            }catch (Exception e){

            }

            Thread.sleep(10);
        }
    }
}
