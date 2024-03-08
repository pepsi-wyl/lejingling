package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.mapper.TeacherScheduleMapper;
import org.ylan.model.dto.req.TeacherScheduleReqDTO;
import org.ylan.model.dto.req.TeacherScheduleSelectReqDTO;
import org.ylan.model.dto.resp.TeacherScheduleRespDTO;
import org.ylan.model.dto.resp.TeacherScheduleSelectRespDTO;
import org.ylan.model.entity.TeacherScheduleEntity;
import org.ylan.model.entity.UserEntity;
import org.ylan.service.TeacherScheduleService;

import java.util.List;

/**
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherScheduleServiceImpl extends ServiceImpl<TeacherScheduleMapper, TeacherScheduleEntity> implements TeacherScheduleService {

    /**
     * TeacherScheduleMapper
     */
    private final TeacherScheduleMapper teacherScheduleMapper;

    @Override
    public TeacherScheduleRespDTO add(TeacherScheduleReqDTO requestParam) {
        // 插入数据
        int insert = baseMapper.insert(BeanUtil.toBean(requestParam, TeacherScheduleEntity.class));

        // 返回响应数据
        return new TeacherScheduleRespDTO(insert);
    }

    @Override
    public List<TeacherScheduleSelectRespDTO> select(TeacherScheduleSelectReqDTO requestParam) {

        LambdaQueryWrapper<TeacherScheduleEntity> queryWrapper = Wrappers.lambdaQuery(TeacherScheduleEntity.class);

        // 构造查询条件
        queryWrapper.eq(TeacherScheduleEntity::getTeacherName, requestParam.getTeacherName());
        queryWrapper.eq(TeacherScheduleEntity::getDay, requestParam.getDay());
        queryWrapper.eq(TeacherScheduleEntity::getDayType, requestParam.getDayType());

        List<TeacherScheduleEntity> teacherScheduleEntities = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(teacherScheduleEntities, TeacherScheduleSelectRespDTO.class);
    }

}