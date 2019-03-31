package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;
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
  /** 删除品牌 */
    @Override
    public void deleteAll(Serializable[] ids) {
        //创建示范对象
        Example example=new Example(Brand.class);
        //创建条件对象
        Example.Criteria criteria= example.createCriteria();
        //添加in条件
        criteria.andIn("id", Arrays.asList(ids));
        //根据条件删除
         brandMapper.deleteByExample(example);
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
    public PageResult findByPage(Brand brand, int page, int rows) {

        try {//开启分页
            PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows)
                    .doSelectPageInfo(new ISelect() {
                @Override
                public void doSelect() {
                    brandMapper.findAll(brand);
                }
            });

            return new PageResult(pageInfo.getTotal(),pageInfo.getList());
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
    }
}
