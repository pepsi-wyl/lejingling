package org.ylan.model.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ylan
 */

@Data
public class TeacherScheduleReqDTO {

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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date day;

    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
    private Date beginTime;

    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
    private Date endTime;

    /**
     * 午别
     */
    private Integer dayType;
}