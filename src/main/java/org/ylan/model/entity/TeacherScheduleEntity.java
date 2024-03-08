package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author ylan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Alias("TeacherScheduleEntity")
@TableName("t_teacher_schedule")
public class TeacherScheduleEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 教师ID
     */
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 日期
     */
    private Date day;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 午别
     */
    private Integer dayType;

}