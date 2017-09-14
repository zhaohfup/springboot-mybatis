package com.boot.service.impl;

import com.boot.mapper.CaseBatchMapper;
import com.boot.service.BatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by bst on 2017/8/22.
 */
@Service("batchService")
@Transactional
public class BatchServiceImpl implements BatchService {

    @Resource
    CaseBatchMapper caseBatchMapper;

    @Override
    public int getBatchCount() throws RuntimeException {
        int count = caseBatchMapper.getBatchCount();
        System.out.printf("qa" + count);
        return count;
    }
}
