package ru.ketbiev.course_manager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import ru.ketbiev.course_manager.service.UserDetailsServiceImp;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("password")
                .credentialsExpired(true)
                .accountExpired(true)
                .accountLocked(true)
                .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
                .roles("ADMIN");

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select username, password from users where username=?")
//                .authoritiesByUsernameQuery("select u.username, ur.roles from users u inner join users_roles ur on u.id = ur.user_id where u.username=?");


//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("zaur")
//                        .password("zaur")
//                        .roles("EMPLOYEE"))
//                .withUser(userBuilder.username("elena")
//                        .password("elena")
//                        .roles("HR"))
//                .withUser(userBuilder.username("ivan")
//                        .password("ivan")
//                        .roles("MANGER", "HR"));
    }

//    @Override
//    public void setApplicationContext(ApplicationContext context) {
//        super.setApplicationContext(context);
//        AuthenticationManagerBuilder globalAuthBuilder = context
//                .getBean(AuthenticationManagerBuilder.class);
//        try {
//            globalAuthBuilder.userDetailsService(userDetailsService);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                //.and().csrf().disable()
                .and().formLogin().loginPage("/login").permitAll()//Включаем логин, указываем адрес и разрешаем всем
                .defaultSuccessUrl("/welcome", true)
                .failureUrl("/login?error")
                .and().logout().permitAll()
                .logoutUrl("/login?logout");
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

}