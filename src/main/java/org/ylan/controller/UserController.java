package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.UserLoginReqDTO;
import org.ylan.model.dto.resp.UserLoginRespDTO;
import org.ylan.service.UserService;

/**
 * @author ylan
 */

@RestController
@RequestMapping("/api/v1/lejingling/user")
@RequiredArgsConstructor
public class UserController {

    /**
     * 注入UserService
     */
    private final UserService userService;

    /**
     * 用户登陆接口
     */
    @PostMapping("/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }

}