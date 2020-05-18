package cn.dcr.proj.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/18 17:22
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@Service
@Slf4j
public class BusiServiceImpl {
    public void doBusi() {
        log.info("执行业务方法:执行时机:{}",new Date());
    }
}
