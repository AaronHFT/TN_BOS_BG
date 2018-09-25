package org.java.service.impl;

import org.java.dao.WebNodesMapper;
import org.java.service.WebNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName WebNodesServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 15:44
 * @Version 1.0
 **/
@Service
public class WebNodesServiceImpl implements WebNodesService {

    @Autowired
    private WebNodesMapper webNodesMapper;

    @Override
    public void addWebNode(Map<String, Object> map) {
        webNodesMapper.addWebNode(map);
    }

    @Override
    public void delWebNode(Map<String, Object> map) {
          webNodesMapper.delWebNode(map);
    }

    @Override
    public void editWebNode(Map<String, Object> map) {
          webNodesMapper.editWebNode(map);
    }

    @Override
    public List<Map<String, Object>> queryWebNodes() {
        return webNodesMapper.queryWebNodes();
    }

    @Override
    public Map<String, Object> queryWebNode(Integer id) {
        return webNodesMapper.queryWebNode(id);
    }
}
