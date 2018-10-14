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

    //跳转到产品单位转换
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
        map.put("goodAccept_destroyNum",returnMap.get("goodAccept_destroyNum"));
        goodsService.updateGoodAcceptAfterReturn(map);
        model.addAttribute("list",goodsService.findAllReturnOrder());
        return "/goods/findReturnOrder";
    }

    //查询退货记录
    @RequestMapping("/findAllReturnOrder")
    public String findAllReturnOrder(Model model){
        model.addAttribute("list",goodsService.findAllReturnOrder());
        return "/goods/findReturnOrder";
    }

    //跳转盘点处理
    @RequestMapping("/lineIndex")
    public String lineIndex(Model model){
        model.addAttribute("list",goodsService.findCheckGoodAndHedgingNum());
        return "/goods/lineIndex";
    }

    //添加盘点记录
    @RequestMapping("/createCheckGood")
    public String createCheckGood(@RequestParam Map<String,Object> map){
        System.out.println(map);
        Map<String,Object> goodNumMap=goodsService.findGoodNumByLine(map);
        System.out.println(goodNumMap);
        for (String s:goodNumMap.keySet()) {
            map.put(s,goodNumMap.get(s));
        }
        System.out.println(map);
        String checkDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime());
        map.put("checkDate",checkDate);
        int errorNum=Integer.parseInt(map.get("checkNum").toString())-Integer.parseInt(map.get("num").toString());
        map.put("errorNum",errorNum);
        if(errorNum==0){
            map.put("checkState","正常");
        }else{
            map.put("checkState","未处理");
        }

        //查询数据库有没有当天的盘点记录，有的话进行修改，没有的话进行添加
        List<Map<String,Object>> listByLineAndDate=goodsService.findCheckGoodDetailByLineAndDate(map);
        if (listByLineAndDate.size()>0){
            goodsService.updateCheckGoodByLineAndDate(map);
        }else{
            goodsService.createCheckGood(map);
        }
        return "redirect:/goods/lineIndex";
    }

    //根据条形码查询详情
    @RequestMapping("/findCheckGoodDetail")
    public String findCheckGoodDetail(Model model,@RequestParam Map<String,Object> map){
        List<Map<String,Object>> list=goodsService.findCheckGoodDetail(map);
        System.out.println(list.get(0));
        model.addAttribute("list",list);
        return "/goods/findCheckGoodDetail";
    }

    //盘点入库
    @RequestMapping("/checkGoodInStore")
    public String checkGoodInStore(@RequestParam Map<String,Object> map){

        Map<String,Object> goodInStoreMap=goodsService.findGoodInStoreByLine(map);
        //生成入库编号
        String inStoreCode=System.currentTimeMillis()+"";
        goodInStoreMap.put("inStoreCode",inStoreCode);
        goodInStoreMap.put("newStoreTime",new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));

        //总重量
        double weight=Double.parseDouble(goodInStoreMap.get("good_weight").toString());
        double volume=Double.parseDouble(goodInStoreMap.get("good_volume").toString());
        int errorNum=Integer.parseInt(map.get("errorNum").toString());
        int num=Integer.parseInt(goodInStoreMap.get("good_num").toString());
        goodInStoreMap.put("inStoreNum",errorNum);
        goodInStoreMap.put("inStoreW",weight*errorNum/num);
        goodInStoreMap.put("inStoreV",volume*errorNum/num);
        //生成新的入库条形码
        goodInStoreMap.put("newGoodLine",inStoreCode+goodInStoreMap.get("good_code"));
        goodsService.checkGoodInStore(goodInStoreMap);

        map.put("n",num+errorNum);
        map.put("w",weight+weight*errorNum/num);
        map.put("v",volume+volume*errorNum/num);
        map.put("goodId",goodInStoreMap.get("good_id"));
        goodsService.updateCheckGoodState(map);
        goodsService.updateGoodForCheck(map);
        return "redirect:/goods/lineIndex";
    }

    //盘点出库
    @RequestMapping("/checkGoodOutStore")
    public String checkGoodOutStore(@RequestParam Map<String,Object> map){
        Map<String,Object> goodOutStoreMap=goodsService.findGoodInStoreByLine(map);
        System.out.println(goodOutStoreMap);
        //生成出库编号
        String outStoreCode=System.currentTimeMillis()+"";
        goodOutStoreMap.put("outStoreCode",outStoreCode);
        goodOutStoreMap.put("newStoreTime",new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));

        //总重量
        double weight=Double.parseDouble(goodOutStoreMap.get("good_weight").toString());
        double volume=Double.parseDouble(goodOutStoreMap.get("good_volume").toString());
        int errorNum=Integer.parseInt(map.get("errorNum").toString());
        int num=Integer.parseInt(goodOutStoreMap.get("good_num").toString());
        goodOutStoreMap.put("outStoreNum",-1*errorNum);
        goodOutStoreMap.put("outStoreW",-1*weight*errorNum/num);
        goodOutStoreMap.put("outStoreV",-1*volume*errorNum/num);
        goodsService.checkGoodOutStore(goodOutStoreMap);
        map.put("n",num+errorNum);
        map.put("w",weight+weight*errorNum/num);
        map.put("v",volume+volume*errorNum/num);
        map.put("goodId",goodOutStoreMap.get("good_id"));
        goodsService.updateCheckGoodState(map);
        goodsService.updateGoodForCheck(map);
        return "redirect:/goods/lineIndex";
    }

    //产品计量转换
    @RequestMapping("/unitTrans")
    public String unitTrans(@RequestParam Map<String,Object> map){
        int newNum=Integer.parseInt(map.get("newNum").toString());
        double weight=Double.parseDouble(map.get("weight").toString());
        double volume=Double.parseDouble(map.get("volume").toString());
        if (weight>0){
            map.put("newStandard",weight/newNum+" 千克/箱");
        }else{
            map.put("newStandard",volume/newNum+" 立方/箱");
        }
        goodsService.unitTrans(map);
        return "redirect:/goods/unitConversion";
    }
}
