package org.java.web.outStore;
import org.java.service.outStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outStore")
public class outStoreConller {
@Autowired
private  outStoreService osi;
    @RequestMapping("/orderAll")
    public String orderAll(HttpSession ses){
     ses.setAttribute("orderlist",osi.orderAll());
        return "/outStore/orderAll";
    }
    @RequestMapping("/insgoodsent")
    public String insgoodsent(@RequestParam Map<String,Object> h, HttpSession ses){
    osi.insgoodsent(h);
    ses.setAttribute("goodsentlist",osi.goodsentAll());
        return "redirect:/outStore/goodsentAll";
    }
    @RequestMapping("/goodsentAll")
    public String goodsentALl(HttpSession ses){
        ses.setAttribute("goodsentlist",osi.goodsentAll());
        return "outStore/goodsentAll";
    }
    @RequestMapping("/insgoodchange")
    public String insgoodchange(@RequestParam Map<String,Object>h,HttpSession ses){
        osi.insgoodchange(h);
        return "redirect:/outStore/goodchangAll";
    }
    @RequestMapping("/goodchangAll")
    public String goodchangeALl(HttpSession ses){
        System.out.println(osi.goodreachAll());
        ses.setAttribute("goodchangelist",osi.goodreachAll());
        return "/outStore/goodchangAll";
    }
    @RequestMapping("/inspickUpList")
    public String inspickUpList(@RequestParam Map<String,Object>h){
        osi.pickUpListins(h);
        return "redirect:/outStore/pickUpListAll";
    }
    @RequestMapping("/pickUpListAll")
    public String pickUpListAll(HttpSession ses){
        List<Map<String,Object>>h=osi.pickUpListAll();
        for (Map<String,Object> o:h) {
            o.put("txt","操作人员捡货");
        }
       ses.setAttribute("pickUpListlist",h);
        return "/outStore/pickUpListAll";
    }
    @RequestMapping("/jhpickUpList")
    public String jhpickUpList(HttpSession ses,@RequestParam Map<String,Object>h1) {
        List<Map<String,Object>>l=(List<Map<String,Object>>)ses.getAttribute("pickUpListlist");
        if(osi.goodchange2All(h1).size()<=0){
              osi.insgoodchange2(h1);
        }
        for (Map<String,Object> h:l) {
            if (h.get("pickUpListId").equals(h1.get("pickUpListId"))){
                switch (h.get("txt")+""){
                    case "操作人员捡货":
                        h.put("txt","检出正常");
                        break;
                    case "检出正常":
                        h.put("txt","确任出库,核实仓库信息");
                        break;
                    case "确任出库,核实仓库信息":
                        h.put("txt","打印送货单");
                        break;
                    case "打印送货单":
                        for (Map<String,Object> h2:osi.goodChange1(h1)) {
                            h2.put("order_id",h2.get("orderid"));
                            h2.put("client_id",h2.get("cusid"));
                            h2.put("goodChange_num",h2.get("sl"));
                            osi.insgoodchange(h2);
                            h1.put("num",h2.get("sl"));
                            osi.goodupd(h1);
                        }
                        h.put("txt","送货单打印完毕");
                        break;
                }

            }
        }
        ses.setAttribute("pickUpListlist",l);
        return "/outStore/pickUpListAll";

    }
    }
