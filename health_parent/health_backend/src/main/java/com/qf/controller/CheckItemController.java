package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.constant.MessageConstant;
import com.qf.entity.PageResult;
import com.qf.entity.QueryPageBean;
import com.qf.entity.Result;
import com.qf.pojo.CheckItem;
import com.qf.service.CheckItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkItemService.add(checkItem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean pageBean){
        return checkItemService.findPage(pageBean);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        try {
            checkItemService.delete(id);
            return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
    }
}
