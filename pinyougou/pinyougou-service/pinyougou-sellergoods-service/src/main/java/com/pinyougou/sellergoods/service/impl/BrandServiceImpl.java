package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 服务接口实现类
 */
@Service(interfaceName = "com.pinyougou.service.BrandService")
/* 上面指定接口名，产生服务名，不然会用代理类的名称 */
@Transactional
public class BrandServiceImpl implements BrandService {

    /** 注入数据访问接口代理对象 */
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void save(Brand brand) {
         brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
     brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void deleteAll(Serializable[] ids) {

    }

    @Override
    public Brand findOne(Serializable id) {
        return null;
    }

    @Override
    public List<Brand> findAll() {

       return brandMapper.selectAll();
    }

    @Override
    public List<Brand> findByPage(Brand brand, int page, int rows) {
        return null;
    }
}
