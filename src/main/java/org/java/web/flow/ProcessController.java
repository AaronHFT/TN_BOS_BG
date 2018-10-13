package org.java.web.flow;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @ProjectName tn_bos_background
 * @ClassName ProcessController
 * @Description 工作流管理相关控制器
 * @Author Administrator
 * @Date 2018/9/21 0021 14:52
 * @Version 1.0
 **/
@Controller
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;


    /**
     * @Author Administrator
     * @Description 初始化流程定义部署
     * @Date 17:51 2018/9/21 0021
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("initdeployeeProcess")
    public String initdeployeeProcess(){
        return "/flow/deployeeProcess";
    }

    /**
     * @Author Administrator
     * @Description 部署流程定义
     * @Date 14:57 2018/9/21 0021
     * @Param [bpmn, png]
     * @return java.lang.String
     **/
    @RequestMapping("deployed")
    public String deployed(@RequestParam("resource_bpmn") MultipartFile bpmn, @RequestParam("resource_png")MultipartFile png) throws IOException {

        System.out.println("进入部署");
        //获得两个上传文件的名称
        String bpmnName=bpmn.getOriginalFilename();
        String pngName=png.getOriginalFilename();

        //将这两个上传文件，转换成InputStream
        InputStream bpmn_in=bpmn.getInputStream();
        InputStream png_in=png.getInputStream();

        //创建部署对象，进行部署
        Deployment dp= repositoryService.createDeployment().addInputStream(bpmnName, bpmn_in).addInputStream(pngName, png_in).deploy();

        System.out.println("部署成功,部署id是:"+dp.getId());
        return "redirect:/process/showProcessDefinition";
    }

    /**
     * 查询所有的流程定义
     * @return
     */
    @RequestMapping("showProcessDefinition")
    public String showProcessDefinition(Model model) {
        //创建流程定义  查询对象
        ProcessDefinitionQuery query=repositoryService.createProcessDefinitionQuery();
        //list返回所有版本的流程定义
        List<ProcessDefinition> list=query.list();
        //把所有流程定义存放在model中
        model.addAttribute("pdList",list);
        return "/flow/processManagement";
    }

    /**
     * 删除流程定义
     * 服务:RepositoryService
     * @return
     */
    @RequestMapping("delProcessDefinition")
    public String delProcessDefinition(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
        return "redirect:/process/showProcessDefinition";
    }


    /**
     * 显示资源(资源可以是bpmn，也可以是png)
     * @param processDefinitionId:流程定义的ID
     * @param type:用于标识是bpmn文件，还是png   xxx.do?type=png或者xxx.do?type=bpmn
     * @throws IOException
     */
    @RequestMapping("showResources")
    public void showResources(String processDefinitionId, String type, HttpServletResponse response) throws IOException {
        //获得repositoryService获得流程定义查询对象
        ProcessDefinitionQuery query=repositoryService.createProcessDefinitionQuery();
        //查询具体的流程定义
        ProcessDefinition pd=query.processDefinitionId(processDefinitionId).singleResult();

        //从流程定义中找到该流程定义的部署ID
        String deploymentId=pd.getDeploymentId();

        //判断类型，用于指定要查询的是BPMN文件，还是PNG图片
        String resouces="";
        if (type.equals("png")) {
            //加载的是png图片
            resouces=pd.getDiagramResourceName();
        }else {
            //加载bpmn文件
            resouces=pd.getResourceName();
        }

        //根据部署ID，以及文件名称，加载对应的资源，转换成inputStream
        InputStream in=repositoryService.getResourceAsStream(deploymentId, resouces);

        //创建一个字节数组，用于保存读取到数据
        byte[] b=new byte[8192];
        //定义一个变量，用于保存已读取的字节长度
        int len=0;

        //得到输出流，用于把资源输出显示在客户端浏览器
        OutputStream out=response.getOutputStream();
        while ((len=in.read(b,0,8192))!=-1) {
            out.write(b,0,len);
        }
        out.close();
        in.close();
    }

    /**
     * 显示正在运行的流程实例
     * @param model
     * @return
     */
    @RequestMapping("showRunProcessInstance")
    public String showRunProcessInstance(Model model) {
        // 创建流程实例查询接口
        ProcessInstanceQuery query = runtimeService
                .createProcessInstanceQuery();

        // 查询所有正在运行的流程实例
        List<ProcessInstance> instancelist = query.list();

        //将正在运行的流程实例存入model中
        model.addAttribute("instancelist",instancelist);

        return "/flow/runinstanceManagement";
    }

    /**
     * 显示历史任务
     * @return
     */
    @RequestMapping("showHistoryTask")
    public String showHistoryTask(String processInstanceId, Model model) {
        HistoricTaskInstanceQuery query = historyService
                .createHistoricTaskInstanceQuery();
        query.processInstanceId(processInstanceId);
        List<HistoricTaskInstance> list = query.list();
        model.addAttribute("taskedList", list);
        return "/flow/showHistroyTask";
    }

    /**
     * 显示流程图，当前正在运行阶段，用红色边框选中
     * @return
     */
    @RequestMapping("queryActiveMap")
    public String queryActiveMap(String processInstanceId, Model model) {
        // 根据流程实例ID,查询出流程实例
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();

        // 根据流程实例的ID,得到流程定义的ID
        String processDefinitionId = instance.getProcessDefinitionId();
        model.addAttribute("processDefinitionId", processDefinitionId);

        // 根据流程定义ID，得到ProcessDefinitionEntity
        ProcessDefinitionEntity pdEntity = (ProcessDefinitionEntity) repositoryService
                .getProcessDefinition(processDefinitionId);
        // 通过流程实例，获得，当前执行到哪一个活动节点
        String activityId = instance.getActivityId();

        System.out.println(activityId + ">>>>");

        // 通过ProcessDefinitionEntity查询活动节点 ActivityImpl(每一个任务对应的矩形框)
        // 找到对应的矩形框
        ActivityImpl act = pdEntity.findActivity(activityId);

        // 取得每一个矩形框对应的.x,y,width,height
        int x = act.getX();
        int y = act.getY();
        int width = act.getWidth();
        int height = act.getHeight();

        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("width", width);
        model.addAttribute("height", height);

        return "/flow/showActiveMap";
    }

    /**
     * 删除流程实例
     * @return
     */
    @RequestMapping("delProcessInstance")
    public String delProcessInstance(String processInstanceId) {
        runtimeService.deleteProcessInstance(processInstanceId,"删除不需要理由");
        return "redirect:/process/showRunProcessInstance";
    }

    /**
     * 显示历史流程实例
     * @return
     */
    @RequestMapping("showHisProcessInstance")
    public String showHiProcessInstance(Model model) {
        // 创建流程实例查询接口
        HistoricProcessInstanceQuery query =historyService.createHistoricProcessInstanceQuery();

        // 查询所有历史流程实例
        List<HistoricProcessInstance> instancelist =query.list();

        //将正在运行的流程实例存入model中
        model.addAttribute("instancelist",instancelist);

        return "/flow/hisProcessInstance";
    }

    @RequestMapping("goDeployee")
    public String goDeployee(){
        return "/flow/deployeeProcess";
    }

}
