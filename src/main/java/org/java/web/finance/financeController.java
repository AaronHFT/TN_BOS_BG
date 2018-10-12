package org.java.web.finance;

import org.java.Service.financeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        ses.setAttribute("flist",fs.getAll());
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
    @RequestMapping("/ajaxid")
    public  String ajaxid( HttpServletRequest res) throws IOException {
        resp.reset();
        PrintWriter out=resp.getWriter();
        System.out.print("进入了ajax方法");
        String id=res.getParameter("ajaxid");
        ajaxid=id;
        out.write(id);
        out.flush();
        out.close();
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

}
