package cn.dcr.proj.handler;

import cn.dcr.proj.entity.ProductInfo;
import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/25 14:42
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
public class GlobalExceptionHandler {
    /**
     * 限流后处理方法
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse handleException(HttpRequest request,
                                                             byte[] body, ClientHttpRequestExecution execution, BlockException ex)  {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("被限制流量拉");
        productInfo.setProductNo("-1");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return new SentinelClientHttpResponse(objectMapper.writeValueAsString(productInfo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 熔断后处理的方法
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse fallback(HttpRequest request,
                                                      byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("被降级拉");
        productInfo.setProductNo("-1");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return new SentinelClientHttpResponse(objectMapper.writeValueAsString(productInfo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
