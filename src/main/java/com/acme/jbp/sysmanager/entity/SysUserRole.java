package com.acme.jbp.sysmanager.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xianglf
 * @since 2020-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userid;

    private Long userid;

    private Long roleid;

    private Long roleid;

    private LocalDateTime addtime;

    private String adduser;


}
