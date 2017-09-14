package com.boot.controller;

import com.boot.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bst on 2017/8/22.
 */
@RestController
public class ImportCaseController extends BaseController {

    @Autowired
    public BatchService batchService;

    @RequestMapping("/importCase")
    public String importCase() {
        return returnData.toString();
    }

    @RequestMapping("/getBatchCount")
    public String getBatchCount() {
        int count = batchService.getBatchCount();
        returnData.setData(count);
        return returnData.toString();
    }
}
