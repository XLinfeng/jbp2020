package com.acme.jbp.sysmanager.mapper;

import com.acme.jbp.sysmanager.entity.Sysuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianglf
 * @since 2020-03-26
 */
public interface SysuserMapper extends BaseMapper<Sysuser> {

    /**
     * 根据用户名称查找用户
     * @param username
     * @return
     */
    Sysuser getUserByUsername(String username);
}
