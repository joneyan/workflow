package com.flow.all;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    /**
     * 启动流程引擎
     * @throws Exception
     */
    @org.junit.Test
    public  void deploy() throws Exception{
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deploy = defaultProcessEngine.getRepositoryService().
                createDeployment().
                addClasspathResource("bpmn/test.bpmn").
                addClasspathResource("bpmn/test.png").deploy();
        System.out.println(deploy.getName());
    }

    /**
     * 开启流程
     *
     */
    @org.junit.Test
    public  void startProcess(){
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstance myProcess = defaultProcessEngine.getRuntimeService().startProcessInstanceByKey("myProcess");
        System.out.println("pid:"+myProcess.getId()+",,,activitid:"+myProcess.getActivityId());
    }

    @org.junit.Test
    public void queryMytask(){
        String assign="张三";
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        List<Task> list = defaultProcessEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(assign)
                .list();
        for(Task item : list){
            System.out.println("taskid:"+item.getId()+",taskname:"+item.getName());
            System.out.println("------------------------");
        }
    }
    @org.junit.Test
    public void testxuhuan(){
        Calendar cal = Calendar.getInstance();
        for(int i=0;i<10;i++,cal.add(Calendar.DATE,1)){
            Date time = cal.getTime();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(time));
        }
    }

}
