package com.yootk.test.service;

import com.yootk.ssm.service.INewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring/spring-base.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNewsServiceCache {
    @Autowired
    private INewsService newsService;

    @Test
    public void testGet() {
        System.err.println("【第一次数据查询】" + this.newsService.get(3L));
        System.err.println("======================= 防止混乱的重要分隔符 =======================");
        System.err.println("【第二次数据查询】" + this.newsService.get(3L));
    }
}
