package cn.dcr.proj.mapper;


import cn.dcr.proj.entity.PayInfo;

/**
 * Created by smlz on 2019/11/20.
 */
public interface PayInfoMapper {

    PayInfo selectPayInfoByOrderNo(String orderNo);
}
