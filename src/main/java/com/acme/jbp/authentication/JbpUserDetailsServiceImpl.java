package com.acme.jbp.authentication;


import com.acme.jbp.sysmanager.service.ISysroleService;
import com.acme.jbp.sysmanager.service.ISysuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JbpUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysuserService sysuserService;

    @Autowired
    private ISysroleService sysroleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
