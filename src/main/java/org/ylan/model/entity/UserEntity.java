package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ylan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_user")

public class UserEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;
}