package com.qf.service;

import com.qf.entity.PageResult;
import com.qf.entity.QueryPageBean;
import com.qf.entity.Result;
import com.qf.pojo.CheckItem;

public interface CheckItemService {
    void add(CheckItem checkItem);

    PageResult findPage(QueryPageBean pageBean);

    void delete(Integer id);
}
