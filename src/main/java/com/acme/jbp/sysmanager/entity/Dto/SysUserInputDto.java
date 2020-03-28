package com.acme.jbp.sysmanager.entity.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "用户信息")
public class SysUserInputDto {

    @ApiModelProperty(value = "用户名称", name = "username", required = true, example = "admin")
    @NotBlank(message = "用户名称不允许为空")
    @Length(min = 6,max = 20,message = "用户名称长度必须在6-20之间")
    private String username;

    @ApiModelProperty(value = "用户密码", name = "password", required = true, example = "123qwr")
    @NotBlank(message = "用户密码不允许为空")
    @Length(min = 6,max = 20,message = "用户密码长度必须在6-20之间")
    private String password;

    @ApiModelProperty(value = "用户昵称", name = "nickname", required = true, example = "二月春风似剪刀")
    @Length(min = 6,max = 20,message = "用户昵称长度必须在6-20之间")
    private String nickname;
}
