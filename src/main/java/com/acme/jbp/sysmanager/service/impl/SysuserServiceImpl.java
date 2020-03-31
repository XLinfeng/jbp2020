package com.acme.jbp.sysmanager.service.impl;

import com.acme.jbp.sysmanager.entity.Dto.SysUserInputDto;
import com.acme.jbp.sysmanager.entity.Sysuser;
import com.acme.jbp.sysmanager.mapper.SysuserMapper;
import com.acme.jbp.sysmanager.service.ISysuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
}
