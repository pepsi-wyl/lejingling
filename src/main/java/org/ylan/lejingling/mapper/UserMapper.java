package org.ylan.lejingling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ylan.lejingling.model.entity.UserEntity;

/**
 * @author ylan
 */

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}