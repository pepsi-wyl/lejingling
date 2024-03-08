package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.TeacherScheduleReqDTO;
import org.ylan.model.dto.req.TeacherScheduleSelectReqDTO;
import org.ylan.model.dto.resp.TeacherScheduleRespDTO;
import org.ylan.model.dto.resp.TeacherScheduleSelectRespDTO;
import org.ylan.model.entity.TeacherScheduleEntity;

import java.util.List;

/**
 * @author ylan
 */

public interface TeacherScheduleService extends IService<TeacherScheduleEntity> {

    /**
     * 添加教师排班
     */
    TeacherScheduleRespDTO add(TeacherScheduleReqDTO requestParam);

    /**
     * 查询教师排班
     */
    List<TeacherScheduleSelectRespDTO> select(TeacherScheduleSelectReqDTO requestParam);
}