package com.acme.jbp.sysmanager.service.impl;

import com.acme.jbp.sysmanager.entity.Dto.SysUserInputDto;
import com.acme.jbp.sysmanager.entity.Sysrole;
import com.acme.jbp.sysmanager.entity.Sysuser;
import com.acme.jbp.sysmanager.mapper.SysroleMapper;
import com.acme.jbp.sysmanager.mapper.SysuserMapper;
import com.acme.jbp.sysmanager.service.ISysuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.internal.dynalink.linker.LinkerServices;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianglf
 * @since 2020-03-26
 */
@Service
public class SysuserServiceImpl extends ServiceImpl<SysuserMapper, Sysuser> implements ISysuserService {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private SysuserMapper sysuserMapper;

    @Autowired
    private SysroleMapper sysroleMapper;

    @Override
    public Long AddSysUser(SysUserInputDto dto) {

        Sysuser user = mapperFactory.getMapperFacade().map(dto,Sysuser.class);
        user.setAddtime(Timestamp.valueOf(LocalDateTime.now()));
        user.setIsdeleted(false);
        user.setIsenable(true);
        user.setIsexpired(false);
        user.setIslocked(false);
        sysuserMapper.insert(user);
        return  user.getId();
    }

    /**
     * 应该优先从缓存数据中查找，然后再到数据库中查找
     * @param userName
     * @return
     */

    @Override
    public Sysuser findUserByUserName(String userName) {

        Sysuser sysuser = sysuserMapper.getUserByUsername(userName);
        if(null  != sysuser){
            List<Sysrole> sysroles = sysroleMapper.findRoleByUserId((sysuser.getId()));
            sysuser.setRoles(sysroles);
        }
        return sysuser;

    }
}
