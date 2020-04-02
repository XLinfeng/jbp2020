package com.acme.jbp.authentication;


import com.acme.jbp.sysmanager.entity.Sysuser;
import com.acme.jbp.sysmanager.service.ISysroleService;
import com.acme.jbp.sysmanager.service.ISysuserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JbpUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysuserService sysuserService;

    @Autowired
    private ISysroleService sysroleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Sysuser user = sysuserService.findUserByUserName(s);
        if(null == user){
            log.info("未找到用户");
            throw new UsernameNotFoundException("该用户不存在");
        }
        return user;
    }
}
