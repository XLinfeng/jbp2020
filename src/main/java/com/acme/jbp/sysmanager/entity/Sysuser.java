package com.acme.jbp.sysmanager.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author xianglf
 * @since 2020-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Sysuser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Boolean isenable;

    private Boolean islocked;

    private Boolean isexpired;

    private Boolean isdeleted;

    private Timestamp addtime;

    private String adduser;

    private List<Sysrole> roles;

    //getAuthorities获取用户包含的权限，返回权限集合，权限是一个继承了GrantedAuthority的对象；
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
        if (!roles.isEmpty()){

            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Sysrole role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRolename()));
            }
            return authorities;
        }
        return null;
    }

    //isAccountNonExpired方法返回boolean类型，用于判断账户是否未过期，未过期返回true反之返回false；
    @Override
    public boolean isAccountNonExpired() {
        return this.isexpired;
    }

    //isAccountNonLocked方法用于判断账户是否未锁定；
    @Override
    public boolean isAccountNonLocked() {
            return this.islocked;
    }

    //isCredentialsNonExpired用于判断用户凭证是否没过期，即密码是否未过期；
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //isEnabled方法用于判断用户是否可用。
    @Override
    public boolean isEnabled() {
        return isenable;
    }
}
