package org.ylan.lejingling.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginRespDTO {

    /**
     * 用户Token
     */
    private String token;
}
