package org.java.contract.web;

import org.java.contract.service.ContractService;
import org.java.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @ProjectName tn_bos_background
 * @ClassName ContractController
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/10 10:16
 * @Version 1.0
 **/
@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractService contService;

    @Autowired
    OrderService orderService;

    @RequestMapping("showAll")
    public String showAll(Map<String,Object> map){
        List<Map<String, Object>> list = contService.showAllContract();
        map.put("contList",list);
        map.put("contSize",list.size());
        map.put("allCont", contService.getAllContType());
        return "/contract/cont-list";
    }


    @RequestMapping("createContract")
    @ResponseBody
    public String createContract(@RequestParam Map<String,Object> map){
        String contId = contId();
        map.put("contId", contId);
        contService.createContract(map);
        return "";
    }

    //生成合同id
    private String contId(){
        Long simple=System.currentTimeMillis();
        int random=new Random().nextInt(9000000)+1000000;
        return simple.toString()+random;
    }

    //根据Id删除合同
    @RequestMapping("delContById")
    @ResponseBody
    public String delContById(@RequestParam Map<String,Object> map){
        contService.delContById(map);
        return "";
    }

    //合同编辑-保存
    @RequestMapping("saveContract")
    @ResponseBody
    public String saveContract(@RequestParam Map<String,Object> map){
        contService.saveContract(map);
        return "";
    }

    @RequestMapping("updContract")
    @ResponseBody
    public String updContract(@RequestParam Map<String,Object> map){
        orderService.updOrderState(map);
        contService.updContState(map);
        return "";
    }
}
