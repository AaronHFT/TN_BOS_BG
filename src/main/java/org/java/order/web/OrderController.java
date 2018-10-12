package org.java.order.web;

import org.java.contract.service.ContractService;
import org.java.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName OlderController
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/07 10:13
 * @Version 1.0
 **/
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ContractService contService;

    //显示所有订单
    @RequestMapping("showAll")
    public String showAll(Map<String,Object> map){
        map.put("ordList", orderService.showAllOrder());
        map.put("ordListSize", orderService.showAllOrder().size());
        map.put("allCont", contService.getAllContType());
        return "/order/order-list";
    }


    @RequestMapping("order-add")
    public String openOrderAdd(){
        return "/order/order-add";
    }

    //加载仓库位置
    @RequestMapping("distributionLoad")
    @ResponseBody
    public Object distribution(@RequestParam Map<String,Object> map) {
        List<Map<String,Object>> list = orderService.store_load(map);
        return list;
    }

    @RequestMapping("saveStore")
    @ResponseBody
    public String saveStore(@RequestParam Map<String,Object> map){
        orderService.saveStore(map);
        return "";
    }

}
