package com.atstudy.service.impl;

import com.atstudy.mapper.SpuAttrKeyCategoriesMapper;
import com.atstudy.mapper.SpuAttrKeyMapper;
import com.atstudy.mapper.SpuAttrValueMapper;
import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.SpuAttrValue;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAttrKeyAddBo;
import com.atstudy.pojo.bo.SpuAttrKeySearchBo;
import com.atstudy.pojo.bo.SpuAttrUpdateBo;
import com.atstudy.service.SpuAttrKeyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SpuAttrKeyServiceImpl implements SpuAttrKeyService {

    @Resource
    private SpuAttrKeyMapper spuAttrKeyMapper;

    @Resource
    private SpuAttrValueMapper spuAttrValueMapper;

    @Resource
    private SpuAttrKeyCategoriesMapper spuAttrKeyCategoriesMapper;

    @Override
    public List<SpuAttrKey> listByBo(SpuAttrKeySearchBo searchBo, PageBo pageBo) {
        int result = spuAttrKeyMapper.countByBo(searchBo);
        pageBo.setResultCount((long) result);
        List<SpuAttrKey> spuAttrKeys = spuAttrKeyMapper.listByBo(searchBo, pageBo);
        return spuAttrKeys;
    }

    @Transactional
    @Override
    public boolean insertOne(SpuAttrKeyAddBo spuAttrKeyAddBo) {
        //先添加属性键表
        String keyId = UUID.randomUUID().toString();
        SpuAttrKey spuAttrKey = new SpuAttrKey();
        spuAttrKey.setKeyId(keyId);
        spuAttrKey.setKeyName(spuAttrKeyAddBo.getKeyName());
        spuAttrKey.setKeyIssku(spuAttrKeyAddBo.getKeyIssku());
        spuAttrKey.setKeyIshigh(spuAttrKeyAddBo.getKeyIshigh());
        LocalDateTime now = LocalDateTime.now();
        spuAttrKey.setCreatetime(now);
        spuAttrKey.setUpdatetime(now);
        int i = spuAttrKeyMapper.insertOne(spuAttrKey);
        //添加属性值表，遍历
        List<SpuAttrValue> valueList = spuAttrKeyAddBo.getAttrValueList();
        for (SpuAttrValue value : valueList) {
            value.setValueAttrKeyId(keyId);
            value.setCreatetime(now);
            value.setUpdatetime(now);
        }
        int i1 = spuAttrValueMapper.insertBatchValue(valueList);
        //判断是否有选中分类，如果有就添加属性键和分类表，遍历获得到分类id数组
        Integer[] idList = spuAttrKeyAddBo.getIdList();
        for (Integer cateId : idList) {
            if(cateId != -1){
                spuAttrKeyCategoriesMapper.insertOne(keyId,cateId);
            }
        }
        return i >= 1 && i1 >= 1;
    }

    @Override
    public SpuAttrKey listById(String keyId) {
        SpuAttrKey spuAttrKey = spuAttrKeyMapper.listById(keyId);
        return spuAttrKey;
    }

    @Override
    public List<Integer> listCateIdByKeyId(String keyId) {
        List<Integer> integerList = spuAttrKeyCategoriesMapper.listCateIdByKeyId(keyId);
        return integerList;
    }

    @Transactional
    @Override
    public boolean updateByBo(SpuAttrUpdateBo spuAttrUpdateBo) {
        //修改属性键表
        SpuAttrKey spuAttrKey = new SpuAttrKey();
        spuAttrKey.setKeyId(spuAttrUpdateBo.getKeyId());
        spuAttrKey.setKeyName(spuAttrUpdateBo.getKeyName());
        spuAttrKey.setKeyIssku(spuAttrUpdateBo.getKeyIssku());
        spuAttrKey.setKeyIshigh(spuAttrUpdateBo.getKeyIshigh());
        LocalDateTime now = LocalDateTime.now();
        spuAttrKey.setUpdatetime(now);
        int i = spuAttrKeyMapper.updateByBo(spuAttrKey);
        //删除属性键id对应属性值数据，然后新增属性值数据
        Map<String,Object> map = new HashMap<>();
        map.put("value_attr_key_id",spuAttrUpdateBo.getKeyId());
        int i1 = spuAttrValueMapper.deleteByMap(map);
        List<SpuAttrValue> valueList = spuAttrUpdateBo.getAttrValueList();
        for (SpuAttrValue value : valueList) {
            value.setValueAttrKeyId(spuAttrUpdateBo.getKeyId());
            value.setCreatetime(now);
            value.setUpdatetime(now);
        }
        int i2 = spuAttrValueMapper.insertBatchValue(valueList);
        //删除属性键id对应分类id数据，然后新增分类id数据
        spuAttrKeyCategoriesMapper.deleteById(spuAttrUpdateBo.getKeyId());
        //判断是否有选中分类，如果有就添加属性键和分类表，遍历获得到分类id数组
        Integer[] idList = spuAttrUpdateBo.getIdList();
        for (Integer cateId : idList) {
            if(cateId != -1){
                spuAttrKeyCategoriesMapper.insertOne(spuAttrUpdateBo.getKeyId(), cateId);
            }
        }
        return i >= 0 && i1 >= 0 && i2 >= 0;
    }

    @Transactional
    @Override
    public boolean deleteOne(String keyId) {
        //删除属性键表数据
        int i1 = spuAttrKeyMapper.deleteOne(keyId);
        //删除属性值表数据
        QueryWrapper<SpuAttrValue> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("value_attr_key_id",keyId);
        int i2 = spuAttrValueMapper.delete(wrapper2);
        //删除属性键分类表
        spuAttrKeyCategoriesMapper.deleteById(keyId);
        return i1 >= 1 && i2 >= 1;
    }

    @Transactional
    @Override
    public boolean deleteBatchIds(String[] idList) {
        //批量删除属性键表数据
        int i1 = spuAttrKeyMapper.deleteBatchIds(idList);
        //批量删除属性值表数据
        int i2 = spuAttrValueMapper.deleteBatchIds(idList);
        //批量删除属性键分类表
        spuAttrKeyCategoriesMapper.deleteBatchIds(idList);
        return i1 >= 1 && i2 >= 1;
    }

    @Override
    public List<SpuAttrKey> getKeyValue(Long spuId) {
        return spuAttrKeyMapper.getKeyValue(spuId);
    }
}
