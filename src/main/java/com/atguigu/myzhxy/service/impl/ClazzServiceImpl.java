package com.atguigu.myzhxy.service.impl;

import com.atguigu.myzhxy.mapper.ClazzMapper;
import com.atguigu.myzhxy.pojo.Clazz;
import com.atguigu.myzhxy.service.ClazzService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {


    @Override
    public IPage<Clazz> getClazzsByOpr(Page<Clazz> pageParam, Clazz clazz) {

        // 设置查询条件
        QueryWrapper<Clazz> queryWrapper = new QueryWrapper<>();
        if (clazz != null) {
            //年级名称条件
            String gradeName = clazz.getGradeName();
            if (!StringUtils.isEmpty(gradeName)) {
                queryWrapper.eq("grade_name", gradeName);
            }
            //班级名称条件
            String clazzName = clazz.getName();
            if (!StringUtils.isEmpty(clazzName)) {
                queryWrapper.like("name", clazzName);
            }
            queryWrapper.orderByAsc("id");
            queryWrapper.orderByAsc("name");
        }
        Page page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;

    }

    @Override
    public List<Clazz> getClazzs() {
        return baseMapper.selectList(null);
    }
}
