package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Common.Result;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.donePrepare;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/22 12:49
 * @description：feign
 * @modified By：
 * @version: 1.0$
 */
@FeignClient("fdk-goods")
public interface feignClient {
    @RequestMapping("/goods/donePrepare")
    Result donePrepare(@RequestBody donePrepare param);

}
