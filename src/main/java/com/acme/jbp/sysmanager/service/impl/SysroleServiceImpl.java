package com.acme.jbp.sysmanager.service.impl;

import com.acme.jbp.sysmanager.entity.Sysrole;
import com.acme.jbp.sysmanager.mapper.SysroleMapper;
import com.acme.jbp.sysmanager.service.ISysroleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianglf
 * @since 2020-04-01
 */
@Service
public class SysroleServiceImpl extends ServiceImpl<SysroleMapper, Sysrole> implements ISysroleService {

    @Autowired
    private SysroleMapper sysroleMapper;

    @Override
    public List<Sysrole> getRolesByUserId(Long userId) {

        return sysroleMapper.findRoleByUserId(userId);
    }
}
