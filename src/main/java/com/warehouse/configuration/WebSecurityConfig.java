package com.warehouse.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Value("${spring.queries.users-query}")
//    private String usersQuery;

//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/addProduct/*").hasAnyAuthority("USER, ADMIN")
//                .antMatchers("/addProduct/shop").hasAnyAuthority("USER, ADMIN")
//                .antMatchers("/addProduct/warehouse").hasAnyAuthority("USER, ADMIN")
//                .antMatchers("/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .passwordEncoder(bCryptPasswordEncoder)
//                .usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(rolesQuery);
                .usersByUsernameQuery("SELECT username, password, active " +
                        "FROM users " +
                        "WHERE username=?")
                .authoritiesByUsernameQuery("SELECT u.username, r.role " +
                        "FROM users u " +
                        "INNER JOIN user_role ur on(u.id = ur.user_id) " +
                        "INNER JOIN role r on(ur.role_id=r.id) " +
                        "WHERE u.username=?");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
