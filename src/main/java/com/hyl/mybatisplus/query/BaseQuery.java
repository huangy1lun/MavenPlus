package com.hyl.mybatisplus.query;

import lombok.Data;

/**
 * TODO
 *
 * @author huangYl
 * @date 2019/1/10 下午2:24
 **/
@Data
public class BaseQuery {

    private Integer pageSize;

    private Integer pageNum;

    private String keyword;
}
