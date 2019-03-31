package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/** 品牌数据访问接口*/

public interface BrandMapper extends Mapper<Brand> {
    /** 多条件查询品牌 */
    List<Brand> findAll(Brand brand);
}
