package com.itheima.test;

import com.itheima.aop.TargetInterface;
import com.itheima.aop.TargetInterface1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {

    @Autowired
    private TargetInterface target;

    @Autowired
    @Qualifier("target1")
    private TargetInterface1 target1;

    @Test
    public void test1(){
        target.save();
    }

    @Test
    public void test2(){
        target1.save1();
    }

}
