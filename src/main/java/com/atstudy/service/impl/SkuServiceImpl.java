package com.atstudy.service.impl;

import com.alibaba.fastjson2.JSON;
import com.atstudy.mapper.SkuMapper;
import com.atstudy.pojo.Sku;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SkuAddBo;
import com.atstudy.pojo.bo.SkuSearchBo;
import com.atstudy.pojo.bo.SkuUpdateBo;
import com.atstudy.pojo.vo.SkuSpuAttrVo;
import com.atstudy.service.SkuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Override
    public List<Sku> listBySearchBo(SkuSearchBo searchBo, PageBo pageBo) {
        Long result = skuMapper.countBySearchBo(searchBo);
        pageBo.setResultCount(result);
        List<Sku> skuList = skuMapper.listBySearchBo(searchBo, pageBo);
        return skuList;
    }

    @Transactional
    @Override
    public boolean insertOne(SkuAddBo skuAddBo) {
        Sku sku = new Sku();
        sku.setSkuSpuId(skuAddBo.getSkuSpuId());
        sku.setSkuName(skuAddBo.getSkuName());
        sku.setSkuPrice(skuAddBo.getSkuPrice());
        sku.setSkuOriginalprice(skuAddBo.getSkuOriginalprice());
        sku.setSkuCostprice(skuAddBo.getSkuCostprice());
        sku.setSkuQuantity(skuAddBo.getSkuQuantity());
        LocalDateTime now = LocalDateTime.now();
        sku.setCreatetime(now);
        sku.setUpdatetime(now);
        List<SkuSpuAttrVo> voList = new ArrayList<>();
        for (int i = 0; i < skuAddBo.getKeyList().size()-1; i++) {
            SkuSpuAttrVo vo = new SkuSpuAttrVo();
            vo.setSpu_id(skuAddBo.getSkuSpuId());
            vo.setKey_id(skuAddBo.getKeyList().get(i).getKeyId());
            vo.setKey_name(skuAddBo.getKeyList().get(i).getKeyName());
            vo.setValue_id(skuAddBo.getValueList().get(i).getId());
            vo.setValue_name(skuAddBo.getValueList().get(i).getValueName());
            voList.add(vo);
        }
        String s = JSON.toJSONString(voList);
        sku.setSkuSpuattr(s);
        int i = skuMapper.insertOne(sku);
        return i >= 1;
    }

    @Override
    public Sku findById(Long skuId) {
        Sku sku = skuMapper.findById(skuId);
        return sku;
    }

    @Transactional
    @Override
    public boolean updateOne(SkuUpdateBo skuUpdateBo) {
        Sku sku = new Sku();
        sku.setSkuId(skuUpdateBo.getSkuId());
        sku.setSkuSpuId(skuUpdateBo.getSkuSpuId());
        sku.setSkuName(skuUpdateBo.getSkuName());
        sku.setSkuPrice(skuUpdateBo.getSkuPrice());
        sku.setSkuOriginalprice(skuUpdateBo.getSkuOriginalprice());
        sku.setSkuCostprice(skuUpdateBo.getSkuCostprice());
        sku.setSkuQuantity(skuUpdateBo.getSkuQuantity());
        LocalDateTime now = LocalDateTime.now();
        sku.setUpdatetime(now);
        List<SkuSpuAttrVo> voList = new ArrayList<>();
        for (int i = 0; i < skuUpdateBo.getKeyList().size()-1; i++) {
            SkuSpuAttrVo vo = new SkuSpuAttrVo();
            vo.setSpu_id(skuUpdateBo.getSkuSpuId());
            vo.setKey_id(skuUpdateBo.getKeyList().get(i).getKeyId());
            vo.setKey_name(skuUpdateBo.getKeyList().get(i).getKeyName());
            vo.setValue_id(skuUpdateBo.getValueList().get(i).getId());
            vo.setValue_name(skuUpdateBo.getValueList().get(i).getValueName());
            voList.add(vo);
        }
        String s = JSON.toJSONString(voList);
        sku.setSkuSpuattr(s);
        int i = skuMapper.updateOne(sku);
        return i >= 1;
    }

    @Transactional
    @Override
    public boolean deleteOne(Long skuId) {
        int i = skuMapper.deleteById(skuId);
        return i >= 1;
    }

    @Transactional
    @Override
    public boolean deleteBatch(Long[] idList) {
        int i = skuMapper.deleteBatchIds(Arrays.asList(idList));
        return i >= 1;
    }
}
