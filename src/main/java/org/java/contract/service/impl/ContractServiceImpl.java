package org.java.contract.service.impl;

import org.java.contract.dao.ContractMapper;
import org.java.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName ContractServiceImpl
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/10 10:17
 * @Version 1.0
 **/
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractMapper contMapper;

    @Override
    public List<Map<String, Object>> showAllContract() {
        return contMapper.showAllContract();
    }

    @Override
    public void createContract(Map<String, Object> map) {
        contMapper.createContract(map);
    }

    @Override
    public void delContById(Map<String, Object> map) {
        contMapper.delContById(map);
    }

    @Override
    public List<Map<String, Object>> getAllContType() {
        return contMapper.getAllContType();
    }

    @Override
    public void saveContract(Map<String, Object> map) {
        contMapper.saveContract(map);
    }

    @Override
    public void updContState(Map<String, Object> map) {
        contMapper.updContState(map);
    }
}
