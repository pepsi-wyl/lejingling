package org.ylan.lejingling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.lejingling.common.convention.result.Result;
import org.ylan.lejingling.common.convention.result.Results;
import org.ylan.lejingling.model.dto.UserLoginReqDTO;
import org.ylan.lejingling.model.dto.UserLoginRespDTO;
import org.ylan.lejingling.model.entity.UserEntity;
import org.ylan.lejingling.service.UserService;

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