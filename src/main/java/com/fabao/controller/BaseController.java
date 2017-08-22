package com.fabao.controller;

import com.fabao.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 封装复用功能
 * Created by bst on 2017/8/21.
 */
public class BaseController {
    @Autowired
    public ReturnData returnData;
}
