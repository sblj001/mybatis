package com.yootk.ssm.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.Callable;

public class RedisCache implements Cache {
    private RedisTemplate<String,Object> redisTemplate ;
    private String name ;
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate ;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object o) {
        Object result = this.redisTemplate.opsForValue().get(String.valueOf(o)) ;
        if (result != null){
            return  new SimpleValueWrapper(result) ;
        }
        return null;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        Object result = this.redisTemplate.opsForValue().get(String.valueOf(o)) ;
        if (result != null){
            return  (T) result ;
        }
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        this.redisTemplate.opsForValue().set(String.valueOf(key),value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Object result = this.redisTemplate.opsForValue().get(String.valueOf(key)) ;
        if (result == null){
            this.redisTemplate.opsForValue().set(String.valueOf(key),value);
            return new SimpleValueWrapper(value) ;
        }
        return new SimpleValueWrapper(result);
    }

    @Override
    public void evict(Object o) {
        this.redisTemplate.delete(String.valueOf(o)) ;
    }

    @Override
    public void clear() {
        this.redisTemplate.getConnectionFactory().getConnection().flushDb();
    }
}
