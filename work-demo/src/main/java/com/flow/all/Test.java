package com.flow.all;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;

/**
 * Created by Administrator on 2018-4-12.
 */
public class Test {
    /**
     * 使用框架提供的自动建表（提供配置文件）---可以从框架提供的例子程序中获取
     */
    @org.junit.Test
    public void test2() {
        String resource = "activiti.cfg.xml";// 配置文件名称
        String beanName = "processEngineConfiguration";// 配置id值
        ProcessEngineConfiguration conf = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource(resource,
                        beanName);
        ProcessEngine processEngine = conf.buildProcessEngine();
    }
    @org.junit.Test
    public  void deploy() throws Exception{
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deploy = defaultProcessEngine.getRepositoryService().
                createDeployment().
                addClasspathResource("bpmn/MyDocument.bpmn").
                addClasspathResource("bpmn/MyDocument.png").deploy();
        System.out.println(deploy.getName());
    }
}
