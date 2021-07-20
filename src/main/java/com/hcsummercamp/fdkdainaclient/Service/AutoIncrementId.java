package com.hcsummercamp.fdkdainaclient.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * @author ：YZJ
 * @date ：Created in 2021/7/20 18:40
 * @description：自增id
 * @modified By：
 * @version: 1.0$
 */
@Service
public class AutoIncrementId {
    @Autowired
    RedisTemplate redisTemplate;

    public Long incr(String key) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, Objects.requireNonNull(redisTemplate.getConnectionFactory()));
        return entityIdCounter.getAndIncrement();
    }
}
