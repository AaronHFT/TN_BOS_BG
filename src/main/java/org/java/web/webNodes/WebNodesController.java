package org.java.web.webNodes;

import org.java.service.WebNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName WebNodesController
 * @Description 网点管理的控制类
 * @Author Administrator
 * @Date 2018/9/25 0025 15:16
 * @Version 1.0
 **/
@Controller
@RequestMapping("/mapNodes")
public class WebNodesController {

    @Autowired
    private WebNodesService webNodesService;

    @RequestMapping("/initMapNodes")
    public String initMapNodes(){
        return "/webNodes/addMapNode";
    }

    @RequestMapping("/add")
    public String add(@RequestParam Map<String,Object> webNode){
        webNodesService.addWebNode(webNode);
        return "redirect:/mapNodes/initMapNodes";
    }

    @RequestMapping("/showMapNodes")
    public String showMapNodes(Model model){
        List<Map<String,Object>> webNodes=webNodesService.queryWebNodes();
        model.addAttribute("webNodes",webNodes );
        return "/webNodes/showMapNodes";
    }

    @RequestMapping("/delMapNodes")
    public String delMapNodes(Integer id){
        Map<String,Object> map=new HashMap<>();
        map.put("webNodes_id", id);
        webNodesService.delWebNode(map);
        return "redirect:/mapNodes/showMapNodes";
    }

    @RequestMapping("/initEdit")
    public String initEdit(Integer id,Model model){
            Map<String,Object> webNode=webNodesService.queryWebNode(id);
            model.addAttribute("webNode", webNode);
        return "/webNodes/editMapNode";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Map<String,Object> webNode){
        webNodesService.editWebNode(webNode);
        return "redirect:/mapNodes/showMapNodes";
    }
}
