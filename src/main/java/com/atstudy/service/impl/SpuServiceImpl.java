package com.atstudy.service.impl;

import com.atstudy.mapper.SpuMapper;
import com.atstudy.pojo.Spu;
import com.atstudy.pojo.SpuAttrKey;
import com.atstudy.pojo.bo.PageBo;
import com.atstudy.pojo.bo.SpuAddBo;
import com.atstudy.pojo.bo.SpuSearchBo;
import com.atstudy.pojo.bo.SpuUpdateBo;
import com.atstudy.service.SpuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Resource
    private SpuMapper spuMapper;

    @Override
    public List<Spu> listBySearchBo(SpuSearchBo spuSearchBo, PageBo pageBo) {
        Long result = spuMapper.countBySearchBo(spuSearchBo);
        pageBo.setResultCount(result);
        List<Spu> spuList = spuMapper.listBySearchBo(spuSearchBo, pageBo);
        return spuList;
    }

    @Transactional
    @Override
    public boolean insertOne(SpuAddBo spuAddBo) {
        //新增spu表数据
        Spu spu = new Spu();
        spu.setSpuName(spuAddBo.getSpuName());
        spu.setSpuTitle(spuAddBo.getSpuTitle());
        spu.setSpuIntroduction(spuAddBo.getSpuIntroduction());
        spu.setSpuStatus(spuAddBo.getSpuStatus());
        spu.setSpuBrandId(spuAddBo.getSpuBrandId());
        LocalDateTime now = LocalDateTime.now();
        spu.setCreatetime(now);
        spu.setUpdatetime(now);
        int i = spuMapper.insertOne(spu);
        //新增cate_spu表数据
        int i1 = spuMapper.insertCateSpu(spu.getSpuId(), spuAddBo.getCateList());
        return i >= 1 && i1 >= 1;
    }

    @Override
    public Spu selectById(Long spuId) {
        Spu spu = spuMapper.selectById(spuId);
        return spu;
    }

    @Override
    public List<Integer> listCateIdBySpuId(Long spuId) {
        List<Integer> cateIdList = spuMapper.listCateIdBySpuId(spuId);
        return cateIdList;
    }

    @Transactional
    @Override
    public boolean updateOne(SpuUpdateBo spuUpdateBo) {
        //修改spu表
        Spu spu = new Spu();
        spu.setSpuId(spuUpdateBo.getSpuId());
        spu.setSpuName(spuUpdateBo.getSpuName());
        spu.setSpuTitle(spuUpdateBo.getSpuTitle());
        spu.setSpuIntroduction(spuUpdateBo.getSpuIntroduction());
        spu.setSpuStatus(spuUpdateBo.getSpuStatus());
        spu.setSpuBrandId(spuUpdateBo.getSpuBrandId());
        LocalDateTime now = LocalDateTime.now();
        spu.setUpdatetime(now);
        int i = spuMapper.updateOne(spu);
        //删除原有的cate_spu表数据
        int i1 = spuMapper.deleteCateSpuBySpuId(spuUpdateBo.getSpuId());
        //增加新的的cate_spu表数据
        int i2 = spuMapper.insertCateSpu(spuUpdateBo.getSpuId(), spuUpdateBo.getCateList());
        return i >= 1 && i1 >= 1 && i2 >= 1;
    }

    @Transactional
    @Override
    public boolean deleteOne(Long spuId) {
        //删除spu表数据
        int i = spuMapper.deleteBySpuId(spuId);
        //删除cate_spu表数据
        spuMapper.deleteCateSpuBySpuId(spuId);
        return i >= 1;
    }

    @Transactional
    @Override
    public boolean deleteBatch(Long[] idList) {
        //批量删除spu表数据
        int i = spuMapper.deleteBatchSpuIds(idList);
        //批量删除cate_spu表数据
        spuMapper.deleteBatchCateSpuIds(idList);
        return i >= 1;
    }

    @Override
    public List<Spu> list() {
        return spuMapper.list();
    }
}
