package com.acme.jbp.sysmanager.mapper;

import com.acme.jbp.sysmanager.entity.Sysrole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianglf
 * @since 2020-04-01
 */
public interface SysroleMapper extends BaseMapper<Sysrole> {

    List<Sysrole> findRoleByUserId(Long userId);
}
