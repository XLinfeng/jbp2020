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
public class Sysrole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String rolecode;

    private String rolename;

    private Boolean isdeleted;

    private LocalDateTime addtime;

    private String adduser;

    private LocalDateTime modifytime;

    private String modifyuser;


}
