//package com.gtools.algorithm.jdk.wait.spring;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * @Description
// * @Author ghy
// * @Date 2019/12/10 15:16
// */
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ImportResource("classpath*:beans-dropioc.xml")
//public class TestCommandManagerDropIOC {
//
//    private ApplicationContext applicationContext;
//
//    /*@Before
//    public void setUp() {
//        applicationContext = new ClassPathXmlApplicationContext("beans-dropioc.xml");
//    }*/
//
//    @Autowired
//    CommandManager manager;
//
//    @Test
//    public void tesetProcess() {
//        // 理解IOC
//        //CommandManager manager = applicationContext.getBean(CommandManager.class);
//        System.out.println("first,command address:" + manager.process());
//        System.out.println("second,command address:" + manager.process());
//
//
//        //System.out.println("first,prCommand address:" + manager.processFix());
//        //System.out.println("second,prCommand address:" + manager.processFix());
//
//
//        System.out.println("first,manager address:" + manager);
//        System.out.println("second,manager address:" + manager);
//
//    }
//}
