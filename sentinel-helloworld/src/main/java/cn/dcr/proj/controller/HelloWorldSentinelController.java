package cn.dcr.proj.controller;

import cn.dcr.proj.service.BusiServiceImpl;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author dcr
 * @Description
 * @Date 2020/5/18 11:09
 * @Param []
 * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
 **/
@RestController
@Slf4j
public class HelloWorldSentinelController {
    @Autowired
   private BusiServiceImpl busiService;

    @PostConstruct
    public void init(){
        List<FlowRule> flowRules=new ArrayList<>();
        //创建流程规则对象
        FlowRule flowRule=new FlowRule();
        //设置流控规则QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule.setResource("helloSentinelV1");
        //设置受保护的资源的阈值
        flowRule.setCount(1);

        flowRules.add(flowRule);
        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
    }

    /**
     * 频繁请求接口 http://localhost:8080/helloSentinelV1
     * 这种做法的缺点:
     * 1)业务侵入性很大,需要在你的controoler中写入 非业务代码..
     * 2)配置不灵活 若需要添加新的受保护资源 需要手动添加 init方法来添加流控规则
     * @return
     */
    @RequestMapping("/helloSentinelV1")
    public String testHelloSentinelV1(){
        Entry entity=null;

        try {
            //关联受保护的资源
            entity = SphU.entry("helloSentinelV1");
            //开始执行 自己的业务方法
            busiService.doBusi();
        } catch (BlockException e) {
            log.info("testHelloSentinelV1方法被流控了");
            return "testHelloSentinelV1方法被流控了";
        }finally {
            if(entity!=null) {
                entity.exit();
            }
        }
        return "OK";
    }
}
