package com.acme.jbp.sysmanager.service;

import com.acme.jbp.sysmanager.entity.Sysrole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianglf
 * @since 2020-04-01
 */
public interface ISysroleService extends IService<Sysrole> {

    List<Sysrole> getRolesByUserId(Long userId);
}
