package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    // 将BCrypt注册为bean,方便后续加密密码
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
//        System.out.println(new BCryptPasswordEncoder().encode("admin"));
        return new BCryptPasswordEncoder();
    }

    // 将登陆缓存cookie保存在数据库
    @Bean
    public PersistentTokenRepository repository(DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
//        repository.setCreateTableOnStartup(true);
        repository.setDataSource(dataSource);
        return repository;
    }

    // 配置Security属性
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, PersistentTokenRepository repository) throws Exception{
        return http
                .authorizeHttpRequests(conf -> {
                    conf.requestMatchers("/static/**").permitAll();
                    conf.requestMatchers("/admin/**").hasRole("admin");
                    conf.requestMatchers("/admin/**").authenticated();
                    conf.anyRequest().permitAll();
                })
                .formLogin(conf -> {
                    conf.loginPage("/admin/login");
                    conf.loginProcessingUrl("/admin/doLogin");
                    conf.defaultSuccessUrl("/admin/index");
                    conf.permitAll();
                })
                .logout(conf -> {
                    conf.logoutUrl("/admin/logout");
                    conf.logoutSuccessUrl("/admin/login");
                    conf.permitAll();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .rememberMe(conf -> {
                    conf.tokenRepository(repository);
                    conf.tokenValiditySeconds(3600 * 1);
                })
                .build();

    }



}
