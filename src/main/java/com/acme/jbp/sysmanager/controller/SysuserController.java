package com.acme.jbp.sysmanager.controller;


import com.acme.jbp.commons.JbpResponseMessage;
import com.acme.jbp.commons.JbpResponseMessageUtil;
import com.acme.jbp.sysmanager.entity.Dto.SysUserInputDto;
import com.acme.jbp.sysmanager.service.ISysuserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xianglf
 * @since 2020-03-26
 */
@RestController
@RequestMapping("/sysmanager/sysuser")
public class SysuserController {

    @Autowired
    private ISysuserService sysuserService;

    /**
     * 新增用户列表
     * @ApiImplicitParams注解中的属性“dataType”基本类型、类按照正常来赋值，自定义泛型类应该按照如下格式来赋值：
     * 例如：dataType = "demo«ArrayList«demo1»»"，重点是符号“«»”
     * @param dto
     * @return
     */
    @ApiOperation(value="添加用户", notes="新增一个系统用户")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "dto",value = "系统用户信息Dto",paramType = "body",dataType = "SysUserInputDto",required = true)})
    @PostMapping(value = "/add")
    public JbpResponseMessage AddUser(@RequestBody @Validated SysUserInputDto dto){

        return JbpResponseMessageUtil.buildSuccess(sysuserService.AddSysUser(dto));

    }
}
