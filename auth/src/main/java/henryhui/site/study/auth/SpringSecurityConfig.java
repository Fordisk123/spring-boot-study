package henryhui.site.study.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;

    @Autowired
    private NoOpPasswordEncoder opPasswordEncoder;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //HttpSecurity对象
        httpSecurity
                //禁用 CSRF,不然post调试的时候都403
                .csrf().disable()
                //设置权限定义哪些URL需要被保护、哪些不需要被保护。HttpSecurity对象的方法
                .authorizeRequests()
                //调试期间先允许访问
                //.antMatchers("/member/**").permitAll()
                //认证通过后任何请求都可访问。AbstractRequestMatcherRegistry的方法
                .anyRequest().authenticated()
                //连接HttpSecurity其他配置方法
                .and()
                //生成默认登录页，HttpSecurity对象的方法
                .formLogin();
    }

    /**
     * 创建认证提供者Bean
     * DaoAuthenticationProvider是SpringSecurity提供的AuthenticationProvider默认实现类
     * 授权方式提供者，判断授权有效性，用户有效性，在判断用户是否有效性，
     * 它依赖于UserDetailsService实例，可以自定义UserDetailsService的实现。
     * 技巧01：
     *
     * @return
     */
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        // 创建DaoAuthenticationProvider实例
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        // 将自定义的认证逻辑添加到DaoAuthenticationProvider
//        authProvider.setUserDetailsService(authService);
//        // 设置自定义的密码加密
//        authProvider.setPasswordEncoder(opPasswordEncoder);
//        return authProvider;
//    }
//
//    /*
//     * 配置好的认证提供者列表
//     *
//     * */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 添加自定义的认证逻辑
//        auth.authenticationProvider(authenticationProvider());
//    }
}
