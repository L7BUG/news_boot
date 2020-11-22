package com.l.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//狂神视频的配置方式
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        首页所有人可以访问, 功能页只有对应有权限的人能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
//        自定义登陆页面   后面这个是登陆认证的url
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/toLogin")
                .loginProcessingUrl("/login");

//        默认是post 因为防止网站被攻击 这个是关闭
        http.csrf().disable();
        //开启注销功能 然后跳到首页
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

//        开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }

//    认证
    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        从内存中读取
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("l").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3", "vip1")
//                .and()
//                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
