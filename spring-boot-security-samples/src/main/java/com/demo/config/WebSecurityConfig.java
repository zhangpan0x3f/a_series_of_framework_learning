package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author zhang pan
 * @Description 类描述
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    //注入数据源
    @Resource
    private DataSource dataSource;

    //配置对象
    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf防护
        http.csrf().disable();

        //配置没有访问权限时跳转的自定义页面
        http.exceptionHandling().accessDeniedPage("/403.html");

        //配置用户注销
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();

        http.formLogin()  //自定义自己编写的登录页面
                .loginPage("/login.html")  //登录页面设置
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/success.html").permitAll()  //登录成功之后要跳转的路径
                .and().authorizeRequests()
                .antMatchers("/","/test/hello","/user/login").permitAll()  //设置哪些路径可以直接访问，不需要认证
                //当前登录用户只有具有admin权限才能访问这个路径
//                .antMatchers("/test/index").hasAnyAuthority("admin")
//                .antMatchers("/test/index").hasAnyAuthority("admin,manager")
//                .antMatchers("/test/index").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .rememberMe().tokenRepository(tokenRepository())
                .tokenValiditySeconds(3600 * 24 * 10)  //设置有效时长,单位秒
                .userDetailsService(userDetailsService);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }

}
