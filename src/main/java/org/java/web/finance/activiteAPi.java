package org.java.web.finance;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;


public class activiteAPi {
    // 要求：配置文件的名称，必须为:activiti.cfg.xml
    private ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 产生工作流引擎，同时产生23张数据表
     */
    public void createProcessEngine() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        ProcessEngine engine = cfg.buildProcessEngine();

        System.out.println("创建工作流引擎成功....");
    }

    /**
     * 部署流程定义到数据库中 需要用的服务 RepositoryService 分别添加: bpmn,png
     *
     */
    public void deployeeProcessDefinition1() {
        RepositoryService service = engine.getRepositoryService();
        String bpmn_name = "MyProcess.bpmn";
        String png_name = "MyProcess.png";
        InputStream bpmn_stream = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/MyProcess.bpmn");
        InputStream png_stream = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/MyProcess.png");
        Deployment deploy = service.createDeployment()
                .addInputStream(bpmn_name, bpmn_stream)
                .addInputStream(png_name, png_stream).deploy();
        System.out.println("部署ID:" + deploy.getId());
        System.out.println("部署时间:" + deploy.getDeploymentTime());

    }

    /**
     * 部署压缩包------------------部署以后，会产生流程定义
     */

    public void deployeeProcessDefinition2() {
        RepositoryService service = engine.getRepositoryService();

        // 读取压缩文件
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/myProcess.zip");

        // 把InputStream转换成ZipInputStream
        ZipInputStream zip = new ZipInputStream(in);

        // 把ZipInputStream部署到数据库中
        Deployment deploy = service.createDeployment().addZipInputStream(zip)
                .deploy();

        System.out.println("部署ID:" + deploy.getId());
        System.out.println("部署时间:" + deploy.getDeploymentTime());

    }

    /**
     * 启动流程实程 要使用的服务:RuntimeService
     */
    public void startProcessInstance() {

        RuntimeService service = engine.getRuntimeService();

        //可以根据流程定义的Id启动 ----如果根据ID启动，如果版本有更新，需要重新设置ID
        //String processDefinitionId="myProcess:5:904";
        //service.startProcessInstanceById(processDefinitionId);


        //可以根据流程定义的Key启动  //根据KE Y启动，它会自动选择version最大的流程
        String processDefinitionKey="myProcess";
        //启动流程
        ProcessInstance instance = service.startProcessInstanceByKey(processDefinitionKey);

        System.out.println("流程实例的ID:"+instance.getProcessInstanceId());
        System.out.println("所属流程定义的ID:"+instance.getProcessDefinitionId());
        System.out.println("当前执行的任务阶段:"+instance.getActivityId());

    }


    /**
     * 查询个人待办任务
     * 需要用到服务是:
     * TaskService
     */

    public void queryPersonTask(){

        TaskService service = engine.getTaskService();

        //指定，要查询哪一个流程定义中的任务
        String processDefinitionKey="myProcess";


        //创建任务查询接口
        TaskQuery query = service.createTaskQuery();

        //要查询的流程定义
        query.processDefinitionKey(processDefinitionKey);
        //要查询哪一个办理人的任务
        query.taskAssignee("xufen");

        //查询，得到所有需要当前负责人办理的任务
        List<Task> list = query.list();

        for(Task t:list){
            System.out.println("任务ID:"+t.getId());
            System.out.println("任务名称:"+t.getName());
            System.out.println("任务办理人:"+t.getAssignee());
            System.out.println("任务开始时间:"+t.getCreateTime());
            System.out.println("------------------------------------------------");
        }

    }


    /**
     * 完成任务
     * 用的服务是:taskService
     */

    public void completeTask(){
        TaskService service = engine.getTaskService();
        String taskId="1102";
        service.complete(taskId);
        System.out.println("任务已完成");
    }


    /*********************************************************************************************/
    /**
     * 查看所有的流程定义
     * 服务:RepositoryService
     */
@Test
    private void showProcessDefinition(){

    System.out.println("QWQ");
        RepositoryService service = engine.getRepositoryService();
        //创建流程定义查询对象
        ProcessDefinitionQuery query = service.createProcessDefinitionQuery();

        //查询所有流程的实例
        List<ProcessDefinition> list = query.list();

        for(ProcessDefinition df :list){

            System.out.println("流程定义的部署Id:"+df.getDeploymentId());
            System.out.println("流程定义的ID:"+df.getId());
            System.out.println("流程定义的Key:"+df.getKey());
            System.out.println("流程定义的版本："+df.getVersion());
            System.out.println("流程定义的BPMN文件名称："+df.getResourceName());
            System.out.println("流程定义的png文件名称："+df.getDiagramResourceName());
            System.out.println("----------------------------------------------------------");

        }
    }

    /**
     * 删除流程定义
     * 如果流程定义没有产生流程实例，可以直接删除。
     * 如果流程定义产生了流程实例，不能直接删除，需要配置级联删除（删除流程定义时，同时，删除它产生所有流程实例）。
     */

    public void delProcessDefinition(){
        RepositoryService service = engine.getRepositoryService();
        //创建流程定义查询对象
        ProcessDefinitionQuery query = service.createProcessDefinitionQuery();
        //要删除的流程定义的ID
        String processDefinitionId="myProce:2:4909";

        //查询出当前要删除的流程定义
        ProcessDefinition pd = query.processDefinitionId(processDefinitionId).singleResult();


        //service.deleteDeployment(pd.getDeploymentId());
        service.deleteDeployment(pd.getDeploymentId(),true);

        System.out.println("删除成功");

    }
    /**
     * 查看所有的流程实例
     */

    public void showProcessInstance(){
        RuntimeService service = engine.getRuntimeService();
        //流程实例查询对象
        ProcessInstanceQuery query = service.createProcessInstanceQuery();

        //要查询产生实例的流程定义的KEY
        String processDefinitionKey="myProcess";

        query.processDefinitionKey(processDefinitionKey);

        List<ProcessInstance> list = query.list();

        for(ProcessInstance p:list){
            System.out.println("流程实例ID:"+p.getProcessInstanceId());
            System.out.println("流程定义ID:"+p.getProcessDefinitionId());
            System.out.println("执行的阶段:"+p.getActivityId());
            System.out.println("------------------------------------------------");
        }
    }


    /***
     * 删除流程实例
     */

    public void delProcessInstance(){


        RuntimeService service =  engine.getRuntimeService();

        //要删除的流程实例的ID
        String processInstanceId="601";

        service.deleteProcessInstance(processInstanceId, "数据错误，所以删除");

        System.out.println("流程实例已删除");

    }

    /************************在启动流程实例时，让工作流的表与业务表之间，建立关联*************************************************/

    public void startProcessInstance2() {

        RuntimeService service = engine.getRuntimeService();

        //可以根据流程定义的Id启动 ----如果根据ID启动，如果版本有更新，需要重新设置ID
        //String processDefinitionId="myProcess:5:904";
        //service.startProcessInstanceById(processDefinitionId);


        //可以根据流程定义的Key启动  //根据KEY启动，它会自动选择version最大的流程
        String processDefinitionKey="myProcess";

        String businessKey=UUID.randomUUID().toString(); //这个字段是业务字段，用于在工作流与业务表这间建立关联，它实际使用是由UUID动态产生，会作为业务表中的主键字段

        //启动流程
        ProcessInstance instance = service.startProcessInstanceByKey(processDefinitionKey,businessKey);

        System.out.println("流程实例的ID:"+instance.getProcessInstanceId());
        System.out.println("所属流程定义的ID:"+instance.getProcessDefinitionId());
        System.out.println("当前执行的任务阶段:"+instance.getActivityId());
        System.out.println("业务字段的是:"+instance.getBusinessKey());

    }



    public void showHistoryTask(){

        HistoryService service = engine.getHistoryService();

        HistoricTaskInstanceQuery  query = service.createHistoricTaskInstanceQuery();

        query.processInstanceId("3001");

        List<HistoricTaskInstance> list = query.list();

        for(HistoricTaskInstance t:list){
            System.out.println("实例ID:"+t.getProcessInstanceId());
            System.out.println("流程定义的ID:"+t.getProcessDefinitionId());
            System.out.println("任务名称:"+t.getName());
            System.out.println("开始时间:"+t.getStartTime());
            System.out.println("结束时间:"+t.getEndTime());
            System.out.println("任务办理人:"+t.getAssignee());
            System.out.println("用时:"+t.getDurationInMillis());

            System.out.println("---------------------------------------------------------");
        }


    }



    /**************************测试流程变量**********************************************************/

    /**
     * 在启动流程实例的时候设置流程变量
     */

    public void testVariables1(){

        RuntimeService service = engine.getRuntimeService();

        String processDefinitionKey="myProcess";

        Map<String,Object> variables = new HashMap<String, Object>();
        variables.put("myprice",1000);

        //启动流程
        ProcessInstance instance = service.startProcessInstanceByKey(processDefinitionKey,variables);

        System.out.println("流程实例的ID:"+instance.getProcessInstanceId());
    }


    /**
     * 完成任务的时候，设置流程变量
     */

    public void testVariables2(){
        TaskService service = engine.getTaskService();



        String taskId="4509";
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("myname", "hello world888");

        service.complete(taskId, variables);

    }




    public void deployeeProcessDefinition3() {
        RepositoryService service = engine.getRepositoryService();

        String bpmn_name = "MyProcess.bpmn";
        String png_name = "MyProcess.png";

        InputStream bpmn_stream = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/MyProcess3.bpmn");
        InputStream png_stream = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/MyProcess3.png");

        Deployment deploy = service.createDeployment()
                .addInputStream(bpmn_name, bpmn_stream)
                .addInputStream(png_name, png_stream).deploy();

        System.out.println("部署ID:" + deploy.getId());
        System.out.println("部署时间:" + deploy.getDeploymentTime());

    }




    public void queryPersonTask2(){

        TaskService service = engine.getTaskService();

        //指定，要查询哪一个流程定义中的任务
        String processDefinitionKey="myProcess";


        //创建任务查询接口
        TaskQuery query = service.createTaskQuery();

        //要查询的流程定义
        query.processDefinitionKey(processDefinitionKey);
        //要查询哪一个办理人的任务
        query.taskAssignee("xufen");

        //查询，得到所有需要当前负责人办理的任务
        List<Task> list = query.list();

        for(Task t:list){
            System.out.println("任务ID:"+t.getId());
            System.out.println("任务名称:"+t.getName());
            System.out.println("任务办理人:"+t.getAssignee());
            System.out.println("任务开始时间:"+t.getCreateTime());
            System.out.println("------------------------------------------------");
        }

    }


    /**
     * 完成任务
     * 用的服务是:taskService
     */

    public void completeTask2(){
        TaskService service = engine.getTaskService();
        String taskId="5902";
        service.complete(taskId);
        System.out.println("任务已完成");
    }

    /***************************候选人**************************************************/




    public void deployeeProcessDefinition4() {
        RepositoryService service = engine.getRepositoryService();

        String bpmn_name = "MyProcess.bpmn";
        String png_name = "MyProcess.png";

        InputStream bpmn_stream = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/MyProcess7.bpmn");
        InputStream png_stream = this.getClass().getClassLoader()
                .getResourceAsStream("diagrams/MyProcess7.png");

        Deployment deploy = service.createDeployment()
                .addInputStream(bpmn_name, bpmn_stream)
                .addInputStream(png_name, png_stream).deploy();

        System.out.println("部署ID:" + deploy.getId());
        System.out.println("部署时间:" + deploy.getDeploymentTime());

    }

    //启动

    public void startProcessInstance3() {

        RuntimeService service = engine.getRuntimeService();


        //可以根据流程定义的Key启动  //根据KEY启动，它会自动选择version最大的流程
        String processDefinitionKey="myProcess";

        //启动流程
        ProcessInstance instance = service.startProcessInstanceByKey(processDefinitionKey);

        System.out.println("流程实例的ID:"+instance.getProcessInstanceId());
        System.out.println("当前执行的任务阶段:"+instance.getActivityId());


    }


    //查询

    public void queryPersonTask3(){

        TaskService service = engine.getTaskService();

        //指定，要查询哪一个流程定义中的任务
        String processDefinitionKey="myProcess";


        //创建任务查询接口
        TaskQuery query = service.createTaskQuery();

        //要查询的流程定义
        query.processDefinitionKey(processDefinitionKey);
        //要查询哪一个办理人的任务
        query.taskAssignee("maguo");

        //查询，得到所有需要当前负责人办理的任务
        List<Task> list = query.list();

        for(Task t:list){
            System.out.println("任务ID:"+t.getId());
            System.out.println("任务名称:"+t.getName());
            System.out.println("任务办理人:"+t.getAssignee());
            System.out.println("任务开始时间:"+t.getCreateTime());
            System.out.println("------------------------------------------------");
        }

    }

    //候选人--------组任务查询
    //查询

    public void queryPersonTask4(){

        TaskService service = engine.getTaskService();

        //指定，要查询哪一个流程定义中的任务
        String processDefinitionKey="myProcess";


        //创建任务查询接口
        TaskQuery query = service.createTaskQuery();

        //要查询的流程定义
        query.processDefinitionKey(processDefinitionKey);
        //要查询哪一个办理人的任务
        query.taskCandidateUser("mazhihui");

        //查询，得到所有需要当前负责人办理的任务
        List<Task> list = query.list();

        for(Task t:list){
            System.out.println("任务ID:"+t.getId());
            System.out.println("任务名称:"+t.getName());
            System.out.println("任务办理人:"+t.getAssignee());
            System.out.println("任务开始时间:"+t.getCreateTime());
            System.out.println("------------------------------------------------");
        }

    }

    //拾取组任务-------将组任务，变为个人任务
    //拾取任务之前，要判断，是否有资格拾取任务

    public void claimGroupTask(){
        TaskService service = engine.getTaskService();

        //要拾取的任务id
        String taskId="10004";

        //哪一个用户在拾取
        String userId="maguo";

        //根据候选人的id与任务id，查询有没有任务可拾取
        Task task = service.createTaskQuery().taskId(taskId).taskCandidateUser(userId).singleResult();

        if(task!=null){
            service.claim(taskId, userId);

            System.out.println("任务已拾取");
        }else{
            System.out.println("你无资格拾取该任务");
        }
    }

    //任务的归还------------------将个人任务还原成组任务

    public void  backTask(){
        TaskService service = engine.getTaskService();

        //要拾取的任务id
        String taskId="9502";

        //哪一个用户在拾取
        String userId="xufen";

        //查询任务
        Task task = service.createTaskQuery().taskAssignee(userId).taskId(taskId).singleResult();

        if(task!=null){
            service.setAssignee(taskId, null);
            System.out.println("任务已归还");
        }

    }

    /**
     * 领取体检表,完成任务，同时，设置流程变量
     */

    public void completeTask4(){
        TaskService service = engine.getTaskService();
        String taskId="11903";

        Map<String,Object> variables = new HashMap<String, Object>();
        variables.put("empType","1");

        service.complete(taskId,variables);
        System.out.println("体检表已领取");
    }





    //完成任务

    public void completeTask3(){
        TaskService service = engine.getTaskService();
        String taskId="11602";
        service.complete(taskId);
        System.out.println("任务已完成");
    }

    /**************************候选组********************************************/

    /**
     * 使用候选组之前，先向数据表录入数据
     * act_id_group:组信息
     * act_id_user:用户信息
     * act_id_membership:用户与组的关系个
     * 需要使用的服务：IdentityService
     */

    public void addGroupInfo(){

        IdentityService identityService  = engine.getIdentityService();

        //组的id
        String groupId1 = "10";

        //判断这个组是否已经存在,如果存在就不再添加
        if(identityService.createGroupQuery().groupId(groupId1).singleResult()==null){
            GroupEntity group = new GroupEntity();
            group.setId(groupId1);
            group.setName("员工组");

            identityService.saveGroup(group);
        }

        //用户的id
        String userId1="maguo";
        if(identityService.createUserQuery().userId(userId1).singleResult()==null){
            UserEntity user = new UserEntity();
            user.setId(userId1);
            user.setFirstName("马果");
            identityService.saveUser(user);
        }

        //建立关联
        identityService.deleteMembership(userId1, groupId1);//如果存在关联，先删除
        identityService.createMembership(userId1, groupId1);//建立关联

        /***********************************************************************************/
        //组的id
        String groupId2 = "20";

        //判断这个组是否已经存在,如果存在就不再添加
        if(identityService.createGroupQuery().groupId(groupId2).singleResult()==null){
            GroupEntity group = new GroupEntity();
            group.setId(groupId2);
            group.setName("经理组");

            identityService.saveGroup(group);
        }

        //用户的id
        String userId2="xufen";
        if(identityService.createUserQuery().userId(userId2).singleResult()==null){
            UserEntity user = new UserEntity();
            user.setId(userId2);
            user.setFirstName(" 许芬");
            identityService.saveUser(user);
        }

        //建立关联
        identityService.deleteMembership(userId2, groupId2);//如果存在关联，先删除
        identityService.createMembership(userId2, groupId2);//建立关联

        /*******************************************************************************************/
        //组的id
        String groupId3 = "30";

        //判断这个组是否已经存在,如果存在就不再添加
        if(identityService.createGroupQuery().groupId(groupId3).singleResult()==null){
            GroupEntity group = new GroupEntity();
            group.setId(groupId3);
            group.setName("校长组");

            identityService.saveGroup(group);
        }

        //用户的id
        String userId3="zengjie";
        if(identityService.createUserQuery().userId(userId3).singleResult()==null){
            UserEntity user = new UserEntity();
            user.setId(userId3);
            user.setFirstName("曾洁");
            identityService.saveUser(user);
        }

        //建立关联
        identityService.deleteMembership(userId3, groupId3);//如果存在关联，先删除
        identityService.createMembership(userId3, groupId3);//建立关联

        /******************************************************************************************/
        //组的id
        String groupId4 = "40";

        //判断这个组是否已经存在,如果存在就不再添加
        if(identityService.createGroupQuery().groupId(groupId4).singleResult()==null){
            GroupEntity group = new GroupEntity();
            group.setId(groupId4);
            group.setName("财务组");

            identityService.saveGroup(group);
        }

        //用户的id
        String userId4="zhoulu";
        if(identityService.createUserQuery().userId(userId4).singleResult()==null){
            UserEntity user = new UserEntity();
            user.setId(userId4);
            user.setFirstName("周露");
            identityService.saveUser(user);
        }

        //建立关联
        identityService.deleteMembership(userId4, groupId4);//如果存在关联，先删除
        identityService.createMembership(userId4, groupId4);//建立关联

    }
    /*****************************网关测试（并行网关）*************************************************/

}
