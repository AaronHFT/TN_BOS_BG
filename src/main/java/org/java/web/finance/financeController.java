package org.java.web.finance;

import org.java.Service.financeService;
import org.java.util.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 进行财务处理的Controller
 *
 **/
@Controller
@RequestMapping("/finance")
public class financeController {
    @Autowired
    private  HttpServletResponse resp;


    @Autowired
    private financeService fs;

    private  static  String ajaxid;

    /**
     * 跳转到结算界面
     * @return
     */
    @RequestMapping("/wjs")
    public  String wjs(HttpSession ses){
        ses.setAttribute("flist",fs.dd());
        return "/finance/js";
    }
    /**
     * 跳转到承运人结算界面
     * @return
     */
    @RequestMapping("/outjs")
    public  String outjs(HttpSession ses){
        ses.setAttribute("outlist",fs.outAll());
        return "/finance/outjs";
    }
    @ResponseBody
    @RequestMapping("/ajaxid")
    public  String ajaxid( HttpServletRequest res) throws IOException {
        System.out.print("进入了ajax方法");
        String id=res.getParameter("ajaxid");
        ajaxid=id;
        return "";
    }
    @ResponseBody
    @RequestMapping("/ajaxid2")
    public  String ajaxid2( HttpServletRequest res) throws Exception {


        System.out.print("进入了ajax2方法");
       String img=res.getParameter("img");
        String orderid=res.getParameter("orderid");
        HashMap<String,Object>h=new HashMap<String, Object>();
        h.put("id",orderid);
        String table="<table border='1px' width='400px' height='200px' ><tr><td>出入库时间</td><td>物品名称</td><td>数量</td><td>重量</td><td>应付金额</td><td>类别</td></tr>";
        String rkf="";
        double nummoney=0;
        for (HashMap<String,Object>h4:fs.rkf(h)) {
            rkf+="<tr><td>"+h4.get("goodChange_inTime")+"</td><td>"+h4.get("good_name")+"</td><td>"+h4.get("goodChange_num")+"</td><td>"+h4.get("goodChange_weight")+"</td><td>"+h4.get("rkf")+"</td><td>入库</td></tr>";
            nummoney+=Double.parseDouble(h4.get("rkf")+"");
        }
        String ckf="";
        for (HashMap<String,Object>h4:fs.ckf(h)) {
            ckf+="<tr><td>"+h4.get("goodChange_inTime")+"</td><td>"+h4.get("good_name")+"</td><td>"+h4.get("goodChange_num")+"</td><td>"+h4.get("goodChange_weight")+"</td><td>"+h4.get("ckf")+"</td><td>出库</td></tr>";
            nummoney+=Double.parseDouble(h4.get("ckf")+"");
        }
       String text=table+rkf+ckf+"</table>";
        text+="<h3>应付总金额"+nummoney+"</h3>";
      h.put("email",fs.ddxx(h).get("cus_email")+"");
        h.put("img",img);
        h.put("text",text);
        Email.crtestSendEmail(h);
        return "";
    }
    @RequestMapping("/outupd")
    public String outupd(@RequestParam HashMap<String,Object>h){
        fs.outupd(h);
        return "redirect:/finance/outjs";
    }

    @RequestMapping("/upd")
    public String upd(HttpSession ses){
        HashMap<String,Object> hh=new HashMap<String,Object>();
        hh.put("id",ajaxid);
        fs.upd(hh);
        return "redirect:/finance/wjs";
    }
    /**
     * 跳转到结算界面
     * @return
     */
    @RequestMapping("/account")
    public String account(){
        return "flow/account";
    }
    @RequestMapping("/settleaccounts")
    public  String settleaccounts(@RequestParam HashMap<String, Object> h,HttpSession ses){
        System.out.print("QWQ");
        System.out.print(fs.onefinance(h));
        ses.setAttribute("obj",fs.onefinance(h));
        return "/flow/settleaccounts";
    }
    @RequestMapping("/ckxq")
    public  String ckxq(@RequestParam HashMap<String, Object> h,HttpSession ses){
        ses.setAttribute("rkf",fs.rkf(h));
        ses.setAttribute("ckf",fs.ckf(h));
        ses.setAttribute("kjs",fs.kjs(h));
        return "/finance/xq";
    }


}
