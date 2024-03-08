package org.ylan.model.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ylan s
 */

@Data
@AllArgsConstructor
public class TeacherScheduleRespDTO {

    /**
     * 插入成功的条数
     */
    private Integer addSuccessCount;

}