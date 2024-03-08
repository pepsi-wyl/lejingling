package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.TeacherScheduleReqDTO;
import org.ylan.model.dto.req.TeacherScheduleSelectReqDTO;
import org.ylan.model.dto.resp.TeacherScheduleRespDTO;
import org.ylan.model.dto.resp.TeacherScheduleSelectRespDTO;
import org.ylan.service.TeacherScheduleService;

import java.util.List;

/**
 * @author ylan
 */

@RestController
@RequestMapping("/api/v1/teacherSchedule")
@RequiredArgsConstructor
public class TeacherScheduleController {

    /**
     *  TeacherScheduleService
     */
    private final TeacherScheduleService teacherScheduleService;

    /**
     * 添加排班
     *
     * @param requestParam
     * @return
     */
    @PostMapping("/add")
    public Result<TeacherScheduleRespDTO> add(@RequestBody TeacherScheduleReqDTO requestParam) {
        return Results.success(teacherScheduleService.add(requestParam));
    }

    /**
     * 查询排班
     *
     * @param requestParam
     * @return
     */
    @PostMapping("/select")
    public Result<List<TeacherScheduleSelectRespDTO>> select(@RequestBody TeacherScheduleSelectReqDTO requestParam) {
       return Results.success(teacherScheduleService.select(requestParam));
    }

}
