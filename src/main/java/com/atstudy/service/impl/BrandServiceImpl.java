package com.atstudy.service.impl;

import com.atstudy.mapper.BrandMapper;
import com.atstudy.pojo.Brand;
import com.atstudy.pojo.bo.BrandSearchBo;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> list() {
        return brandMapper.list();
    }

    @Override
    public List<Brand> listByBo(BrandSearchBo searchBo, PageBo pageBo) {
        int result = brandMapper.countByBo(searchBo);
        pageBo.setResultCount((long) result);
        List<Brand> brandList = brandMapper.listByBo(searchBo, pageBo);
        return brandList;
    }

    @Transactional
    @Override
    public boolean deleteOne(String brandId) {
        int i = brandMapper.deleteId(brandId);
        return i >= 1;
    }

    @Transactional
    @Override
    public boolean deleteList(String[] idList) {
        int i = brandMapper.deleteIds(idList);
        return i >= 1;
    }
}
