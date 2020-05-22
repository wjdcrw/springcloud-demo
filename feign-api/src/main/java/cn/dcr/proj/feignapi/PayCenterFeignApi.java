package cn.dcr.proj.feignapi;

import cn.dcr.proj.entity.PayInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dcr
 * @Description TODO
 * @Date 2020/5/14 14:57
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@FeignClient(name = "payCenter")
public interface PayCenterFeignApi {
    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo);
}
