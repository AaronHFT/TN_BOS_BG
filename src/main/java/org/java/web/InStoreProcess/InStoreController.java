package org.java.web.InStoreProcess;

import com.sun.mail.imap.protocol.SearchSequence;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.java.service.Impl.InStoreServiceImpl;
import org.java.service.InStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Instore")
public class InStoreController {

    @Autowired
    private InStoreService inStoreService;

    //跳转到创建收货通知单页面
    @RequestMapping("checkGoodreach")
    public String checkGoodreach(@RequestParam Map<String,Object> map, HttpSession ses){
        return "/goodin/checkGoodreach";
    }

    /**
     * 创建收货通知单
     * @return
     */
    @RequestMapping("createGoodreach")
    public String createGoodreach(@RequestParam Map<String,Object> map,HttpSession ses){
        //String userid= (String) ses.getAttribute("userid");       //获取当前登录的用户
        System.out.println("----------进入了创建的方法");
        String userid="48b3092d-1b2c-1037-9b87-886b7f3db4cd";
        map.put("userId",userid);
        inStoreService.createCheckreach(map);
        return "/goodin/checkGoodreach";
    }

    //确认到货,查询出所有未确认的订单信息或所有未制定计划的订单信息
    @RequestMapping("checkStore")
    public String checkStore(HttpSession ses,String name){
        //查询出已确认但未制定计划的的订单信息
        if (name.equals("makeplan")){
            List<Map<String,Object>> planlist=inStoreService.checkPlan();
            for(Map<String,Object> map:planlist){
                System.out.println(map);
            }
            ses.setAttribute("list",planlist);
        }else {
            System.out.println("--------------------");
            //查询出未确认但已制定计划的订单信息
            List<Map<String,Object>> orderlist=inStoreService.checkStore();
            for(Map<String,Object> map:orderlist){
                System.out.println(map);
            }
            ses.setAttribute("list",orderlist);
        }
        ses.setAttribute("name",name);
        return "/goodin/checkStore";
    }

    //传值跳转到货物盘点验收页面
    @RequestMapping("checkGood")
    public String checkGood(HttpSession ses){
        //生成货物验收单编号
        String goodcheckid = UuidUtil.getTimeBasedUuid().toString();
        ses.setAttribute("checkid",goodcheckid);
        //获取当前登录人员的账号
        //String user=ses.getAttribute("loginer").toString();
        String user="48b3092d-1b2c-1037-9b87-886b7f3db4cd";
        ses.setAttribute("user",user);
        String checkdate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        ses.setAttribute("checkdate",checkdate);
        return "/goodin/checkGood";
    }

    //货物盘点验收
    @RequestMapping("checkedgood")
    public String checkedgood(@RequestParam Map<String,Object> map){
        inStoreService.createCheckGood(map);
        String orderid=map.get("orderid").toString();
        Map<String,Object> orderinfo=inStoreService.findOrderByid(orderid);
        String state=orderinfo.get("order_state").toString();
        inStoreService.editOrderCheck(orderid);
        return "redirect:/Instore/checkGood";
    }

    //跳转到收货单页面
    @RequestMapping("goodAccept")
    public String goodAccept(HttpSession ses){
        //生成入库计划单编号
        String acceptid = UuidUtil.getTimeBasedUuid().toString();
        ses.setAttribute("acceptid",acceptid);
        return "/goodin/goodAccept";
    }

    //创建收货单
    @RequestMapping("createGoodAccept")
    public String createGoodAccept(@RequestParam Map<String,Object> map){
        System.out.println(map);
        inStoreService.createGoodAccept(map);
        return "redirect:/Instore/goodAccept";
    }

    //确认到货
    @RequestMapping("checkedStore")
    public String checkedStore(HttpSession ses, String oid,String state){
        if (state.equals("调度运输完")){
            //若为最初的状态，更改为已确认状态
            inStoreService.editorder(oid);
        }else {
            //若为已制定计划单状态则更改为已到货状态
            inStoreService.checkStoretrue(oid);
        }
        List<Map<String,Object>> orderlist=inStoreService.checkStore();
        ses.setAttribute("list",orderlist);
        ses.setAttribute("name","checkstore");
        return "/goodin/checkStore";
    }

    //制定入库计划,跳转到指定入库计划页面
    @RequestMapping("makePlan")
    public String makePlan(HttpSession ses, String gid,String state){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        ses.setAttribute("state",state);
        List<Map<String,Object>> types =inStoreService.getInStoreTypes();
        ses.setAttribute("types",types);
        //生成入库计划单编号
        String planid = UuidUtil.getTimeBasedUuid().toString();
        Map<String,Object> goodinfo=inStoreService.getGoodinfo(gid);
        goodinfo.put("planid",planid);
        ses.setAttribute("goodinfo",goodinfo);
        List<Map<String,Object>> stores=inStoreService.getstorelist();
        ses.setAttribute("stores",stores);
        return "/goodin/createOrderPlan";
    }

    //创建入库计划单,并更改订单状态
    @RequestMapping("createPlan")
    public String createPlan(@RequestParam Map<String,Object> map,HttpSession ses){
        //获取订单的当前状态
        String state=ses.getAttribute("state").toString();
        String orderid=map.get("orderid").toString();
        String goodReach_id=map.get("goodreachid").toString();
        if (state.equals("调度运输完")){
            //若为调度运输状态更改为已制定计划状态
            inStoreService.createPlanorder(map);
            inStoreService.editOrderPlan(orderid);
        }else {
            //若为已确认状态则更改为已到货状态
            inStoreService.createPlanorder(map);
            inStoreService.checkStoretrue(orderid);
        }

        /**
         * 创建完成后,在跳转到此页面
         */
        ses.setAttribute("state",state);
        List<Map<String,Object>> types =inStoreService.getInStoreTypes();
        ses.setAttribute("types",types);
        //生成入库计划单编号
        String planid = UuidUtil.getTimeBasedUuid().toString();
        Map<String,Object> goodinfo=inStoreService.getGoodinfo(goodReach_id);
        goodinfo.put("planid",planid);
        ses.setAttribute("goodinfo",goodinfo);
        List<Map<String,Object>> stores=inStoreService.getstorelist();
        ses.setAttribute("stores",stores);
        return "/goodin/createOrderPlan";
    }

    //跳转到库位分配
    @RequestMapping("assignStorage")
    public String assignStorage(HttpSession ses){
        List<Map<String,Object>> storelist = inStoreService.showStores();
        ses.setAttribute("stores",storelist);
        List<Map<String,Object>> orderlist=inStoreService.showAllcheckOrder();
        ses.setAttribute("orders",orderlist);
        return "/goodin/AllotStorage";
    }

    //查询出即将入库订单的信息,通过JSON返回
    @RequestMapping("goodChange")
    @ResponseBody
    public Map<String,Object> goodChange(HttpServletRequest req,HttpSession ses){
        String orderid=req.getParameter("oid");
        System.out.println(">>>>>>>>>>>>>>>>"+orderid);
        Map<String,Object> map=inStoreService.getOrderinfo(orderid);
        ses.setAttribute("orderinfo",map);
        List<Map<String,Object>> stores=inStoreService.getstorelist();
        map.put("stores",stores);
        List<Map<String,Object>> storeRegion=inStoreService.getStoreRegion();
        map.put("storeRegion",storeRegion);
        List<Map<String,Object>> storePosition=inStoreService.getStorePosition();
        map.put("storePosition",storePosition);
        System.out.println(map);
        return map;
    }

    //订单入库
    @RequestMapping("GoodInstore")
    public String GoodInstore(@RequestParam Map<String,Object> map,HttpSession ses){
        String position=map.get("storePosition").toString();
        String orderid=map.get("orderid").toString();

        //获取存在session中要入库的订单信息
        Map<String,Object> orderinfo= (Map<String, Object>) ses.getAttribute("orderinfo");
        String truckid=orderinfo.get("truck_id").toString();
        String pilotid=orderinfo.get("pilot_id").toString();
        String client=orderinfo.get("cus_id").toString();
        String producedate=orderinfo.get("goodReach_producedDate").toString();
        String secureDate=orderinfo.get("goodReach_secureDate").toString();
        String num=orderinfo.get("goodCkeck_acceptNum").toString();
        String unit=orderinfo.get("goodReach_unit").toString();
        String weight=orderinfo.get("goodCheck_weight").toString();
        String volume=orderinfo.get("goodCheck_volume").toString();
        String level=orderinfo.get("goodCkeck_level").toString();
        String goodname=orderinfo.get("goodReach_goodName").toString();
        String standard=orderinfo.get("goodReach_standard").toString();
        String acceptcode=orderinfo.get("goodAccept_code").toString();

        //通过货物代码查询在库货品中是否存在，若存在则更改其数量,不存在则新增一条数据
        String goodcode=orderinfo.get("goodReach_goodCode").toString();
        Map<String,Object> InGood=inStoreService.findByGoodcode(goodcode);
        if (InGood!=null){
            String goodid=InGood.get("good_id").toString();
            //当在库货品中存在时,修改在库货品的数量,并且添加入库记录
            Map<String,Object> goodAdd=new HashMap<String,Object>();
            goodAdd.put("num",num);
            goodAdd.put("goodid",goodid);
            inStoreService.updateGood(goodAdd);

            //添加入库记录
            map.put("truckid",truckid);
            map.put("pilotid",pilotid);
            map.put("client",client);
            map.put("producedate",producedate);
            map.put("secureDate",secureDate);
            map.put("num",num);
            map.put("unit",unit);
            map.put("weight",weight);
            map.put("volume",volume);
            map.put("level",level);
            map.put("goodid",goodid);
            map.put("acceptcode",acceptcode);
            inStoreService.goodInstore(map);
        }else {
            //新建在库货品的信息,添加到在库货品中
            Map<String,Object> goodAdd=new HashMap<String,Object>();
            goodAdd.put("position",position);
            goodAdd.put("goodname",goodname);
            goodAdd.put("goodcode",goodcode);
            goodAdd.put("standard",standard);
            goodAdd.put("num",num);
            goodAdd.put("unit",unit);
            goodAdd.put("weight",weight);
            goodAdd.put("volume",volume);
            goodAdd.put("level",level);
            inStoreService.goodAdd(goodAdd);
            //查出新增货品在在库货品中的编号
            Map<String,Object> goodinfo=inStoreService.findGoodBycode(goodcode);
            String goodid=goodinfo.get("good_id").toString();
            //添加入库记录
            map.put("truckid",truckid);
            map.put("pilotid",pilotid);
            map.put("client",client);
            map.put("producedate",producedate);
            map.put("secureDate",secureDate);
            map.put("num",num);
            map.put("unit",unit);
            map.put("weight",weight);
            map.put("volume",volume);
            map.put("level",level);
            map.put("goodid",goodid);
            map.put("acceptcode",acceptcode);
            inStoreService.goodInstore(map);
        }
        //入库完成后修改订单的状态为质检完成
        inStoreService.checkOrderInstore(orderid);
        return "redirect:/Instore/assignStorage";
    }

    //确认订单验收结果
    @RequestMapping("showCheckGood")
    public String showCheckGood(HttpSession ses){
        List<Map<String,Object>> list=inStoreService.showGoodCheck();
        ses.setAttribute("list",list);
        return "/goodin/showCheckGood";
    }

    //显示验收详情
    @RequestMapping("showCheckGoodInfo")
    public String showCheckGoodInfo(HttpServletRequest req,HttpSession ses){
        String checkid=req.getParameter("gid");
        Map<String,Object> checkinfo=inStoreService.findCheckgoodByid(checkid);
        System.out.println("验收记录为>>>>>>>>>>>"+checkinfo);
        ses.setAttribute("checkinfo",checkinfo);
        return "/goodin/showCheckDetail";
    }

    //确认验收成功
    @RequestMapping("CheckGoodOk")
    public String CheckGoodOk(HttpServletRequest req){
        String orderid=req.getParameter("oid");
        //将订单的状态更改为已验收
        inStoreService.checkOrdertrue(orderid);
        return "redirect:/Instore/showCheckGood";
    }

    //确认验收失败
    @RequestMapping("CheckGoodFail")
    public String CheckGoodFail(HttpServletRequest req){
        String orderid=req.getParameter("oid");
        //将订单的状态更改为已到货进行重新验收
        inStoreService.editOrderFail(orderid);
        //将验收失败对应的记录删除
        String checkid=req.getParameter("gid");
        inStoreService.delGoodcheck(checkid);
        return "redirect:/Instore/showCheckGood";
    }

}