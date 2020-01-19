package henryhui.site.study.auth;

import henryhui.site.study.dao.UserDao;
import henryhui.site.study.dao.UserGroupDao;
import henryhui.site.study.model.User;
import henryhui.site.study.model.UserGroup;
import henryhui.site.study.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserGroupDao userGroupDao;

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        User user = userDao.findUserByLoginName(loginName);

        if(user == null){
            throw new UsernameNotFoundException("Can't find user by loginName : " + loginName);
        }

        Set<UserGroup> userGroups = user.getLinkedUserGroups();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for(UserGroup userGroup : userGroups){
            for(UserRole userRole : userGroup.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + userRole));
            }
        }

        return new org.springframework.security.core.userdetails.User(loginName,user.getPassword(), grantedAuthorities);
    }
}
