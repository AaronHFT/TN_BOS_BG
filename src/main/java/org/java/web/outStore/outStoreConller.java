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
private outStoreService osi;
@RequestMapping("orderAll")
public String orderAll(HttpSession ses){
    ses.setAttribute("orderList",osi.orderAll());
    return "/outStore/orderAll";
}
    @RequestMapping("goodreachAll")
    public String goodreachAll(HttpSession ses, @RequestParam Map<String,Object>m){
        ses.setAttribute("goodreachList",osi.goodreachAll(m));
        return "/outStore/goodreachAll";
    }
    @RequestMapping("inspickuplist")
    public String inspickuplist(HttpSession ses, @RequestParam Map<String,Object>m){
        osi.insgoodreach(m);
        ses.setAttribute("goodreachList",osi.goodreachAll(m));
        return "/outStore/goodreachAll";
    }

    @RequestMapping("pickuplistAll")
    public String pickuplistAll(HttpSession ses, @RequestParam Map<String,Object>m){
        ses.setAttribute("pickuplistList",osi.pickuplistAll());
        return "/outStore/pickUpListAll";
    }
    @RequestMapping("insgoodchange")
    public String insgoodchange(HttpSession ses, @RequestParam Map<String,Object>m){
       List<Map<String, Object>> l=osi.goodchangeAll(m);
       double num=Double.parseDouble(m.get("num")+"");
        for (Map<String,Object> mm:l) {
            mm.put("goodChange_id",m.get("goodChange_id"));
            mm.put("Order_id",m.get("order_id"));
            if(num>0){
                double nm=Double.parseDouble(mm.get("num")+"");
                if(num-nm>0){
                    num-=nm;
                    double zl=Double.parseDouble(mm.get("goodChange_weight")+"");
                    double tj =Double.parseDouble(mm.get("goodChange_volume")+"");
                    double nm2=Double.parseDouble(mm.get("goodChange_num")+"");
                    mm.put("goodChange_volume",tj/nm2*nm);
                    mm.put("goodChange_weight",zl/nm2*nm);
                    mm.put("goodChange_num",nm);
                    osi.insgoodchange(mm);
                }else {
                double zl=Double.parseDouble(mm.get("goodChange_weight")+"");
                    double tj =Double.parseDouble(mm.get("goodChange_volume")+"");
                    double nm2=Double.parseDouble(mm.get("goodChange_num")+"");
                    mm.put("goodChange_num",num);
                    mm.put("goodChange_volume",tj/nm2*num);
                    mm.put("goodChange_weight",zl/nm2*num);
                    osi.insgoodchange(mm);
                }

            }

        }
        ses.setAttribute("pickuplistList",osi.pickuplistAll());
        return "/outStore/pickUpListAll";
    }

    }
