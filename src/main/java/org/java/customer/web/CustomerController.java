package org.java.customer.web;

import org.java.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName CustomerController
 * @Description TODO
 * @Author Trouble
 * @Date 2018/09/27 9:50
 * @Version 1.0
 **/
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService cusService;

    //显示所有客户
    @RequestMapping("showAll")
    public String showAllCustomer(Model m){
        List<Map<String,Object>> list = cusService.showAllCustomer();
        m.addAttribute("cusList", list);
        m.addAttribute("cusListSize", list.size());
        return "/customer/customer-list";
    }

    //通过id删除客户
    @RequestMapping("delCustomerById")
    @ResponseBody
    public String delCustomer(@RequestParam Map<String,Object> m){
        Integer i = cusService.findOrdById(m.get("delId").toString());
        if(i == 0){
            cusService.delCustomerById(m.get("delId").toString());
            cusService.delContactsByCusId(m.get("delId").toString());
        }else{
            return i.toString();
        }
        return "0";
    }

    //新增客户
    @RequestMapping("addCustomer")
    @ResponseBody
    public String addCustomer(@RequestParam Map<String,Object> m){
        cusService.addCustomer(m);
        return "";
    }

    //打开编辑客户界面
    @RequestMapping("CustomerEdit")
    public String CustomerEdit(@RequestParam Map<String,Object> m, Map<String,Object> map){
        Map<String,Object> eCus = cusService.showCustomerById(m);
        map.put("eCus", eCus);
        return "/customer/customer-edit";
    }

    //保存修改
    @RequestMapping("saveCustomer")
    @ResponseBody
    public String saveCustomer(@RequestParam Map<String,Object> m){
        cusService.saveCustomer(m);
        return "";
    }

    //打开添加客户页面
    @RequestMapping("customer-add")
    public String openAdd(){
        return "/customer/customer-add";
    }

    //打开用户编辑页面
    @RequestMapping("customer-edit")
    public String openEdit(){
        return "/customer/customer-edit";
    }

    //加载联系人
    @RequestMapping("loadContacts")
    @ResponseBody
    public Object loadContacts(@RequestParam Map<String,Object> map){
        return cusService.loadContacts(map);
    }

    //删除联系人
    @RequestMapping("delContact")
    @ResponseBody
    public Object delContact(@RequestParam Map<String,Object> map){
        cusService.delContact(map);
        return "";
    }

    //新增联系人
    @RequestMapping("addContact")
    @ResponseBody
    public Object addContact(@RequestParam Map<String,Object> map){
      cusService.addContact(map);
      return "";
    }

    //编辑联系人-保存
    @RequestMapping("editContact")
    @ResponseBody
    public Object editContact(@RequestParam Map<String,Object> map){
        cusService.editContact(map);
        return "";
    }
}
