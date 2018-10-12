package org.java.Service.impl;

import org.java.Service.outStoreService;
import org.java.dao.outStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class outStoreServiceImpl implements outStoreService {
    @Autowired
    private outStoreMapper osm;
    @Override
    public List<HashMap<String, Object>> orderAll() {
        return osm.orderAll();
    }

    @Override
    public void insgoodsent(HashMap<String, Object> h) {
        osm.insgoodsent(h);
    }

    @Override
    public List<HashMap<String, Object>> goodsentAll() {
        return osm.goodsentAll();
    }

    @Override
    public void insgoodchange(HashMap<String, Object> h) {
        osm.insgoodchange(h);
    }

    @Override
    public List<HashMap<String, Object>> goodchangeAll() {
        return osm.goodchangeAll();
    }

    @Override
    public void pickUpListins(HashMap<String, Object> h) {
        osm.pickUpListins(h);
    }

    @Override
    public List<HashMap<String, Object>> pickUpListAll() {
        return osm.pickUpListAll();
    }

    @Override
    public List<HashMap<String, Object>> goodreachAll() {
        return osm.goodreachAll();
    }

    @Override
    public List<HashMap<String, Object>> goodChange1(HashMap<String, Object> h) {
        return osm.goodChange1(h);
    }

    @Override
    public List<HashMap<String, Object>> goodchange2All(HashMap<String, Object> h) {
        return osm.goodchange2All(h);
    }

    @Override
    public void insgoodchange2(HashMap<String, Object> h) {
        osm.insgoodchange2(h);
    }

    @Override
    public void goodupd(HashMap<String, Object> h) {
        osm.goodupd(h);
    }


}
