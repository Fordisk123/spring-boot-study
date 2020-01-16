//package henryhui.site.study.service;
//
//import henryhui.site.study.dao.UserDao;
//import henryhui.site.study.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.henryhui.site.study.core.authority.AuthorityUtils;
//import org.springframework.security.henryhui.site.study.core.userdetails.UserDetails;
//import org.springframework.security.henryhui.site.study.core.userdetails.UserDetailsService;
//import org.springframework.security.henryhui.site.study.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService implements UserDetailsService {
//
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
//
//        User user = userDao.findUserByLoginName(loginName);
//
//        return new UserDetails(loginName, user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//    }
//}
