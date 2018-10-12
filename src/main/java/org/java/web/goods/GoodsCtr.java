package org.java.web.goods;

import org.java.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName BOS_Project
 * @ClassName GoodManage
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 上午 11:42
 * @Version 1.0
 **/
@RequestMapping("/goods")
@Controller
public class GoodsCtr {

    @Autowired
    private GoodsService goodsService;


    //产品等级转换
    @RequestMapping("/lvChange")
    public String lvChange(Model model,HttpServletRequest request){
        System.out.println("库存good_id是"+request.getParameter("goodId"));
        int goodId=Integer.parseInt(request.getParameter("goodId"));
        String goodLv=request.getParameter("goodLv");
        if(goodLv.equals("正品")){
            goodLv="次品";
        }else{
            goodLv="正品";
        }
        Map<String,Object> map=new HashMap<>();
        map.put("goodId",goodId);
        map.put("goodLv",goodLv);
        goodsService.lvChange(map);
        return "redirect:/goods/findAllGood";
    }

    //产品单位转换
    @RequestMapping("/unitConversion")
    public String unitConversion(Model model){
        List<Map<String,Object>> list=goodsService.findAllGoodAccept();
        model.addAttribute("list",list);
        return "/goods/unitConversion";
    }

    //查询库存
    @RequestMapping("/findAllGood")
    public String findAllGood(Model model){
        List<Map<String,Object>> list=goodsService.findAllGood();
        model.addAttribute("list",list);
        return "/goods/findAllGood";
    }

    //查询库存明细
    @RequestMapping("/findGoodsDetail")
    public String findGoodsDetail(Model model,String goodId){
        System.out.println("要查询明细的货品good_id是"+goodId);
        Map<String,Object> map=new HashMap<>();
        map.put("goodId",goodId);
        List<Map<String,Object>> list=goodsService.findGoodsDetail(map);
        model.addAttribute("list",list);
        return "goods/goodsDetail";
    }

    //根据条形码获取货物的来龙去脉
    @RequestMapping("/goodLine")
    public String goodLine(Model model){
        List<Map<String,Object>> list = goodsService.goodLine();
        for (Map<String,Object> map:list) {
            if (map.get("getOrderId")==null){
                map.put("getOrderId","-");
            }
            if (map.get("getTime")==null){
                map.put("getTime","-");
            }
            if (map.get("getAddress")==null){
                map.put("getAddress","-");
            }
            if (map.get("getNum")==null){
                map.put("getNum","-");
            }
            if (map.get("getV")==null){
                map.put("getV","-");
            }
            if (map.get("getW")==null){
                map.put("getW","-");
            }
        }
        model.addAttribute("list",list);
        return "/goods/goodLine";
    }

    //报废出库
    @RequestMapping("/uselessOut")
    public String uselessOut(Model model,@RequestParam Map<String,Object> map){
        System.out.println(map);
        List<Map<String,Object>> list=goodsService.findGoodsDetailByInCode(map);
        System.out.println(list.get(0));
        //报废出库编号
        String uselessOutCode=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date().getTime()).toString();
        list.get(0).put("uselessOutCode",uselessOutCode);
        list.get(0).put("ueslessDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
        goodsService.uselessOut(list.get(0));
        //库存数量
        int good_num=Integer.parseInt(list.get(0).get("good_num").toString());
        int num=Integer.parseInt(list.get(0).get("num").toString());
        map.put("afterNum",good_num-num);
        map.put("afterWeight",(good_num-num)*Double.parseDouble(list.get(0).get("good_weight").toString())/num);
        map.put("afterVolume",(good_num-num)*Double.parseDouble(list.get(0).get("good_volume").toString())/num);
        goodsService.updateGoods(map);
        return "redirect:/goods/findGoodsDetail?goodId="+list.get(0).get("good_id");
    }

    //查询需要退货的物品
    @RequestMapping("/findGoodsForReturn")
    public String findGoodsForReturn(Model model){
        List<Map<String,Object>> list=goodsService.findGoodsForReturn();
        model.addAttribute("list",list);
        return "/goods/returnGood";
    }

    //创建退货订单
    @RequestMapping("/createReturnOrder")
    public String createReturnOrder(Model model,String orderId){
        Map<String,Object> map=new HashMap<>();
        map.put("orderId",orderId);
        System.out.println(map);
        Map<String,Object> returnMap=goodsService.findGoodsForReturnByOrderId(map);
        System.out.println(returnMap);
        //创建退货订单
        String returnOrderId = System.currentTimeMillis()+(new Random().nextInt(9000000)+1000000)+"";
        //退货单创建日期
        returnMap.put("returnOrderId",returnOrderId);
        returnMap.put("returnDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
        goodsService.createReturnOrder(returnMap);
        returnMap.put("weight",Double.parseDouble(returnMap.get("goodAccept_destroyNum").toString())/Double.parseDouble(returnMap.get("goodAccept_acceptNum").toString())*Double.parseDouble(returnMap.get("goodAccept_weight").toString()));
        returnMap.put("volume",Double.parseDouble(returnMap.get("goodAccept_destroyNum").toString())/Double.parseDouble(returnMap.get("goodAccept_acceptNum").toString())*Double.parseDouble(returnMap.get("goodAccept_volume").toString()));
        goodsService.createReturnHistoryForBad(returnMap);
        goodsService.updateGoodAcceptAfterReturn(map);
        model.addAttribute("list",goodsService.findAllReturnOrder());
        return "/goods/findReturnOrder";
    }
}
