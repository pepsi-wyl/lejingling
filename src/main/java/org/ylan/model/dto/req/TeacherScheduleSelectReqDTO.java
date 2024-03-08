package org.ylan.model.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherScheduleSelectReqDTO {

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
     * 午别
     */
    private Integer dayType;
}