package org.java.web.transport;

import org.java.server.CarManageServer;
import org.java.server.PlanningServer;
import org.java.server.TransportCheckServer;
import org.java.server.TransportServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName TransportController
 * @Description 关于运输
 * @Author boos
 * @Date 2018/9/22 11:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransportServer transportServer;

    @Autowired
    private CarManageServer carManageServer;

    @Autowired
    private PlanningServer planningServer;

    @Autowired
    private TransportCheckServer transportCheckServer;
    /**
     * @ProjectName TN_BOS_BG
     * @ClassName TransportController
     * @Description 运输总览
     * @Author boos
     * @Date 2018/9/22 11:40
     * @Version 1.0
     **/
    @RequestMapping("pandectTranspot")
    public  String pandectTranspot(){
        return "/distribution/pandectTranspot";
    }
    /**
     * @Author boos
     * @Description 驾驶员管理--查看
     * @Date 9:59 2018/9/25
     * @Param
     * @return
     **/
    @RequestMapping("driverManage")
    public  String driverManage( Model model){
        List<Map<String, Object>> driverlist =transportServer.drivershow();

        for (Map<String,Object> map: driverlist) {
            if (!map.containsKey("Illegalreason")){
                map.put("Illegalreason", "---");
                map.put("site", "---");
            }
        }
        model.addAttribute("list", driverlist);
       // System.out.println(driverlist.toString());
       return  "/distribution/driverManage_show";
    }


    /**
     * @Author boos
     * @Description //驾驶员管理删除
     * @Date 18:51 2018/9/26
     * @Param
     * @return
     **/
    @RequestMapping("driverManage_del")
    public  String driverManage_del(String pilot_id){
        transportServer.driverManage_del(pilot_id);
        return "redirect:/transport/driverManage";
    }

    /**
     * @Author boos
     * @Description //驾驶员管理添加
     * @Date 8:45 2018/9/27
     * @Param
     * @return
     **/
    @RequestMapping("driverManage_add")
    public  String driverManage_add(@RequestParam Map<String, Object> m){
              String imgname="/transport/img/"+m.get("img").toString().substring(12);
             m.put("privinglicenceimg", imgname);
              transportServer.driverManage_add(m);
        return "redirect:/transport/driverManage";
    }
    /**
     * @Author boos
     * @Description //跳转添加页面
     * @Date 10:28 2018/9/27
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("driver_add")
    public  String driver_add(){
        return  "/distribution/driverManage_add";
    }

    /**
     * @Author boos
     * @Description //车辆管理
     * @Date 11:45 2018/9/27
     * @Param
     * @return
     **/
    @RequestMapping("carManage")
    public  String carManage(Model model){
        List<Map<String, Object>> carlist=carManageServer.carManage_show();
        model.addAttribute("carlist", carlist);
       //System.out.println(carlist.toString());
        return  "/distribution/carManage_show";
    }
/**
 * @Author boos
 * @Description //查询车辆
 * @Date 20:08 2018/9/27
 * @Param
 * @return
 **/
@RequestMapping("carManage_sel")
public String carManage_sel(String truck_type,Model model){
    List<Map<String, Object>> carlist=null;
    if(truck_type.equals("所有")){
        carlist =carManageServer.carManage_show();
        model.addAttribute("carlist", carlist);
    }else{
        carlist=carManageServer.carManage_sel( truck_type);
        model.addAttribute("carlist", carlist);
    }
    return  "/distribution/carManage_show";
}

/**
 * @Author boos
 * @Description //车牌查询车辆
 * @Date 20:08 2018/9/27
 * @Param
 * @return
 **/
    @RequestMapping("carManage_sel1")
    public  String carManage_sel1(String plate_number,Model model){
        System.out.println(plate_number);
        List<Map<String, Object>> carlist =carManageServer.carManage_sel1(plate_number);

        model.addAttribute("carlist", carlist);
        return  "/distribution/carManage_show";
    }

    /**
     * @Author boos
     * @Description //状态查询车辆
     * @Date 20:08 2018/9/27
     * @Param
     * @return
     **/
    @RequestMapping("carManage_sel2")
    public String carManage_sel2(String truckState,Model model){
        List<Map<String, Object>> carlist=carManageServer.carManage_sel2( truckState);
            model.addAttribute("carlist", carlist);
        return  "/distribution/carManage_show";
    }

    /**
     * @Author boos
     * @Description //删除车辆
     * @Date 8:34 2018/9/29
     * @Param
     * @return
     **/
    @RequestMapping("carManage_del")
    public String carManage_del(String truck_id){
        carManageServer.carManage_del(truck_id);
        return "/distribution/carManage_show";
    }

    /**
     * @Author boos
     * @Description //详细信息
     * @Date 8:52 2018/9/29
     * @Param
     * @return
     **/
    @RequestMapping("carManage_sel3")
    public String carManage_sel3(String truck_id,Model model){
        List<Map<String, Object>> carlist=carManageServer.carManage_sel3( truck_id);
        model.addAttribute("clist", carlist.get(0));
        return "/distribution/cardetail";
    }

    /**
     * @Author boos
     * @Description //添加车辆信息
     * @Date 10:53 2018/9/29
     * @Param
     * @return
     **/
    @RequestMapping("carManage_add")
    public  String carManage_add(){
       return  "/distribution/carManage_add";
    }

    /**
     * @Author boos
     * @Description //添加车辆信息
     * @Date 11:38 2018/9/29
     * @Param
     * @return
     **/
    @RequestMapping("carManage_add2")
        public  String carManage_add2(@RequestParam Map<String, Object> m){
        String truckImage="/transport/img/"+m.get("Image").toString().substring(12);
        Random rand = new Random();
        m.put("truck_id","20180000"+(rand.nextInt(87) + (14)));
        m.put("rid","1");
        m.put("truckState", "空闲");
        m.put("truckLength",0);
        m.put("truckImage", truckImage);
        m.put("datetime","2018-10-15");
        System.out.println(m.toString());
        carManageServer.carManage_add2(m);
        return "redirect:/transport/carManage";
    }


    /**
     * @Author boos
     * @Description //查看每一订单的配送计划，通过计算出发地点到到达地点最省时最省钱的计划，并做出最合理的计划
     * @Date 11:41 2018/9/30
     * @Param
     * @return
     **/
    @RequestMapping("distribution_plan")
    public  String distrbution_plan(Model model){
        List<Map<String, Object>>plist= planningServer.distrbution_show();
        model.addAttribute("plist", plist);
       return  "/distribution/distribution_plan";

    }

    /**
     * @Author boos
     * @Description //删除计划
     * @Date 17:34 2018/10/1
     * @Param
     * @return
     **/
    @RequestMapping("planning_del")
    public  String planning_del(String tspt_id){
        planningServer.planning_del(tspt_id);
        return "redirect:/transport/distribution_plan";
    }

    /**
     * @Author boos
     * @Description //查看地图
     * @Date 17:43 2018/10/1
     * @Param
     * @return
     **/
    @RequestMapping("planning_map")
    public  String planning_map(@RequestParam Map<String, Object> m,Model model){
model.addAttribute("mlist", m);
        return  "/distribution/planning_map";
    }

    /**
     * @Author boos
     * @Description //添加运输计划用于跳转
     * @Date 21:02 2018/10/1
     * @Param
     * @return
     **/
    @RequestMapping("planning_add")
    public  String planning_add(Model model){
        List<Map<String, Object>>pslist=  planningServer.planning_sel5();
        model.addAttribute("pslist", pslist);
        return "/distribution/planning_add";
    }

    /**
     * @Author boos
     * @Description //获取地址
     * @Date 15:39 2018/10/7
     * @Param
     * @return
     **/
    @RequestMapping("planning_sel2")
    public @ResponseBody List<Map<String, Object>> planning_sel2(String order_id){
        List<Map<String, Object>> plist=planningServer.planning(order_id);
        //System.out.println(plist.toString());
        return  plist;
    }

    /**
     * @Author boos
     * @Description //添加一个计划
     * @Date 16:56 2018/10/9
     * @Param
     * @return
     **/
@RequestMapping("planning_add2")
public  String planning_add2(@RequestParam Map<String, Object> m){
    Date date =new Date();
    System.out.println(date);
   // System.out.println(m.get("output1").toString().substring(0,m.get("output1").toString().length()-2));
   // long time = date.getTime();
    String time1=m.get("output1").toString().substring(0,m.get("output1").toString().length()-2);
    int time2= Integer.parseInt(time1);
//   long time3= Long.parseLong(time1)*60;
//    long  time2=time+time3;
//    System.out.println(time+"/"+time3+"/"+time2);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Map<String,Object> order=new HashMap<>();
    Date currentTime = new Date();
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(currentTime);
    calendar.add(Calendar.MINUTE, time2);
    String dateString = formatter.format(calendar.getTime());
   System.out.println(dateString);
    m.put("tspt_date",new Date());
    m.put("load_num", dateString);//预计到达时间
    String freight= m.get("output3").toString().substring(0,m.get("output3").toString().length()-2).toString();
    double tspt_freight = Double.parseDouble(freight);
    m.put("summileage", tspt_freight);
    m.put("tspt_freight", tspt_freight*3);
    planningServer.planning_add2(m);
    return "redirect:/transport/distribution_plan";
}


    /**
     * @Author boos
     * @Description //查看车辆考勤
     * @Date 10:18 2018/10/6
     * @Param
     * @return
     **/
    @RequestMapping("transportcheck")
    public  String transportcheck(Model model){
       List<Map<String, Object>> chaechlist= transportCheckServer.transportcheck_show();
        model.addAttribute("chaechlist", chaechlist);
        return "/distribution/transportcheck_show";
    }
    /**
     * @Author boos
     * @Description //删除车辆考勤
     * @Date 10:18 2018/10/6
     * @Param
     * @return
     **/
    @RequestMapping("transportcheck_del")
    public  String transportcheck_del(String check_id){
        transportCheckServer.transportcheck_del(check_id);
        return "redirect:/transport/transportcheck";
    }
    /**
     * @Author boos
     * @Description //修改车辆考勤
     * @Date 10:18 2018/10/6
     * @Param
     * @return
     **/
    @RequestMapping("transportcheck_up")
    public  String transportcheck_up(String check_id,Model model){
       //System.out.println(check_id);
        List<Map<String, Object>> chlist= transportCheckServer.transportcheck_sel(check_id);
        model.addAttribute("chlist", chlist.get(0));
        return "/distribution/transportcheck_up";
    }
    /**
     * @Author boos
     * @Description //修改车辆考勤
     * @Date 10:18 2018/10/6
     * @Param
     * @return
     **/
    @RequestMapping("transportcheck_up1")
    public  String transportcheck_up1(@RequestParam Map<String, Object> m){
        transportCheckServer.transportcheck_up1(m);
        return "redirect:/transport/transportcheck";
    }
    /**
     * @Author boos
     * @Description //添加车辆考勤跳转
     * @Date 10:18 2018/10/6
     * @Param
     * @return
     **/
    @RequestMapping("transportcheck_add")
    public String transportcheck_add(Model model){
        List<Map<String, Object>> tclist= transportCheckServer.transportcheck_sel2();
        model.addAttribute("tclist", tclist);
        return "/distribution/transportcheck_add";
    }

    /**
     * @Author boos
     * @Description //添加车辆考勤
     * @Date 10:18 2018/10/6
     * @Param
     * @return
     **/
    @RequestMapping("transportcheck_add1")
    public  String transportcheck_add1(@RequestParam Map<String, Object> m){
        transportCheckServer.transportcheck_add1(m);
        return "redirect:/transport/transportcheck";

    }
/**
 * @Author boos
 * @Description //查看需要分配的订单
 * @Date 19:16 2018/10/8
 * @Param [model]
 * @return java.lang.String
 **/
    @RequestMapping("allocation")
    public  String allocation(Model model){
        List<Map<String, Object>> alist= planningServer.allocation();
        for (Map<String,Object> map: alist) {
            if (!map.containsKey("truck_id")){
                map.put("truck_id", "-");
            }
            if(!map.containsKey("pilot_id")){
                map.put("pilot_id", "-");
            }
        }
        model.addAttribute("alist", alist);
        return  "/distribution/allocation";
    }

    /**
     * @Author boos
     * @Description //分配
     * @Date 19:17 2018/10/8
     * @Param
     * @return
     **/
    @RequestMapping("planning_allocation")
    public  String planning_allocation(Model model,String goodReach_id){
        List<Map<String, Object>> palist=planningServer.planning_truck();
        List<Map<String, Object>> palist1=planningServer.planning_pilot();
        model.addAttribute("palist", palist);
        model.addAttribute("palist1", palist1);
        model.addAttribute("goodReach_id", goodReach_id);
        return "/distribution/planning_allocation";
    }

    /**
     * @Author boos
     * @Description //修改状态
     * @Date 19:17 2018/10/8
     * @Param
     * @return
     **/
    @RequestMapping("allocation_up")
    public  String allocation_up(@RequestParam Map<String, Object> m){
        planningServer.allocation_up(m);
        return "redirect:/transport/allocation";
    }

    /**
     * @Author boos
     * @Description //用于跳转
     * @Date 9:15 2018/10/10
     * @Param
     * @return
     **/
    @RequestMapping("pandect_GPS")
    public  String pandect_GPS(Model model){
        List<Map<String, Object>>gpslist= planningServer.distrbution_gps();
        model.addAttribute("gpslist", gpslist);
      //  System.out.println(gpslist.toString());
        return  "/distribution/pandect_GPS";
    }

    /**
     * @Author boos
     * @Description //查看运输的走向
     * @Date 8:35 2018/10/11
     * @Param [order_id, model]
     * @return java.lang.String
     **/
    @RequestMapping("planning_GPSsel")
    public  String planning_GPSsel(String order_id,Model model){
        List<Map<String, Object>>glist= planningServer.planning_GPSsel(order_id);
        model.addAttribute("glist", glist.get(0));
      //  System.out.println(glist.get(0).toString());
        return  "/distribution/planning_GPSsel";
    }

    /**
     * @Author boos
     * @Description //视频监控
     * @Date 8:35 2018/10/11
     * @Param
     * @return
     **/
    @RequestMapping("planning_video")
    public  String planning_video(){
        return "/distribution/planning_video";
    }

    /**
     * @Author boos
     * @Description //打印
     * @Date 19:53 2018/10/11
     * @Param
     * @return
     **/
@RequestMapping("stamp")
    public String stamp(String order_id,Model model){
    List<Map<String, Object>>glist= planningServer.planning_GPSsel(order_id);
    model.addAttribute("glist", glist.get(0));
    return "/distribution/stamp";
}

/**
 * @Author boos
 * @Description //TODO
 * @Date 15:29 2018/10/12
 * @Param
 * @return
 **/
}
