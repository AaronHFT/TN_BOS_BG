package org.java.Service.impl;

import org.java.Service.financeService;
import org.java.dao.financeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class financeServiceImpl implements financeService {
    @Autowired
    private financeMapper f;
    @Override
    public HashMap<String, Object> onefinance(HashMap<String, Object> h) {
        System.out.print(f.onefinance(h));
        return f.onefinance(h);
    }

public  void bb(){
        System.out.print("sd");
}
    @Override
    public List<HashMap<String, Object>> getAll() {
        return f.getAll();
    }

    @Override
    public void upd(HashMap<String, Object> h) {
        f.upd(h);
    }

    @Override
    public List<HashMap<String, Object>> outAll() {
        return f.outAll();
    }

    @Override
    public void outupd(HashMap<String, Object> h) {
        f.outupd(h);
    }

    @Override
    public List<HashMap<String, Object>> rkf(HashMap<String, Object> h) {
        return f.rkf(h);
    }

    @Override
    public List<HashMap<String, Object>> ckf(HashMap<String, Object> h) {
        return f.ckf(h);
    }

    @Override
    public HashMap<String, Object> kjs(HashMap<String, Object> h) {
        return f.kjs(h);
    }

    @Override
    public HashMap<String, Object> ddxx(HashMap<String, Object> h) {
        return f.ddxx(h);
    }

    @Override
    public List<HashMap<String, Object>> dd() {
        return f.dd();
    }
}
