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
    public void insgoodsent(Map<String, Object> h) {
        osm.insgoodsent(h);
    }

    @Override
    public List<Map<String, Object>> goodsentAll() {
        return osm.goodsentAll();
    }

    @Override
    public void insgoodchange(Map<String, Object> h) {
        osm.insgoodchange(h);
    }

    @Override
    public List<Map<String, Object>> goodchangeAll() {
        return osm.goodchangeAll();
    }

    @Override
    public void pickUpListins(Map<String, Object> h) {
        osm.pickUpListins(h);
    }

    @Override
    public List<Map<String, Object>> pickUpListAll() {
        return osm.pickUpListAll();
    }

    @Override
    public List<Map<String, Object>> goodreachAll() {
        return osm.goodreachAll();
    }

    @Override
    public List<Map<String, Object>> goodChange1(Map<String, Object> h) {
        return osm.goodChange1(h);
    }

    @Override
    public List<Map<String, Object>> goodchange2All(Map<String, Object> h) {
        return osm.goodchange2All(h);
    }

    @Override
    public void insgoodchange2(Map<String, Object> h) {
        osm.insgoodchange2(h);
    }

    @Override
    public void goodupd(Map<String, Object> h) {
        osm.goodupd(h);
    }


}
