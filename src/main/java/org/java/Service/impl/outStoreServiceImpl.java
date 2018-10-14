package org.java.service.impl;

import org.java.dao.outStoreMapper;
import org.java.service.outStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class outStoreServiceImpl implements outStoreService {
    @Autowired
    private outStoreMapper osm;


    @Override
    public List<Map<String, Object>> orderAll() {
        return osm.orderAll();
    }

    @Override
    public List<Map<String, Object>> goodreachAll(Map<String, Object> m) {
        return osm.goodreachAll(m);
    }

    @Override
    public void insgoodreach(Map<String, Object> m) {
        osm.insgoodreach(m);
    }

    @Override
    public List<Map<String, Object>> pickuplistAll() {
        return osm.pickuplistAll();
    }

    @Override
    public void insgoodchange(Map<String, Object> m) {
        osm.insgoodchange(m);
    }

    @Override
    public Map<String, Object> onegoodreach(Map<String, Object> m) {
        return osm.onegoodreach(m);
    }

    @Override
    public List<Map<String, Object>> goodchangeAll(Map<String,Object>m) {
        return osm.goodchangeAll(m);
    }
}
