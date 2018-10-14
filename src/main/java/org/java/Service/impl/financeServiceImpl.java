package org.java.service.impl;

import org.java.dao.financeMapper;
import org.java.service.financeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class financeServiceImpl implements financeService {
    @Autowired
    private financeMapper f;
    @Override
    public Map<String, Object> onefinance(Map<String, Object> h) {
        System.out.print(f.onefinance(h));
        return f.onefinance(h);
    }

public  void bb(){
        System.out.print("sd");
}
    @Override
    public List<Map<String, Object>> getAll() {
        return f.getAll();
    }

    @Override
    public void upd(Map<String, Object> h) {
        f.upd(h);
    }

    @Override
    public List<Map<String, Object>> outAll() {
        return f.outAll();
    }

    @Override
    public void outupd(Map<String, Object> h) {
        f.outupd(h);
    }

    @Override
    public List<Map<String, Object>> rkf(Map<String, Object> h) {
        return f.rkf(h);
    }

    @Override
    public List<Map<String, Object>> ckf(Map<String, Object> h) {
        return f.ckf(h);
    }

    @Override
    public Map<String, Object> kjs(Map<String, Object> h) {
        return f.kjs(h);
    }

    @Override
    public Map<String, Object> ddxx(Map<String, Object> h) {
        return f.ddxx(h);
    }

    @Override
    public List<Map<String, Object>> dd() {
        return f.dd();
    }
}
