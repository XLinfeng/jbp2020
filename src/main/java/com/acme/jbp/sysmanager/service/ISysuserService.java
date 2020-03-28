package com.acme.jbp.sysmanager.service;

import com.acme.jbp.sysmanager.entity.Dto.SysUserInputDto;
import com.acme.jbp.sysmanager.entity.Sysuser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianglf
 * @since 2020-03-26
 */
public interface ISysuserService extends IService<Sysuser> {

    Long AddSysUser(SysUserInputDto dto);


}
