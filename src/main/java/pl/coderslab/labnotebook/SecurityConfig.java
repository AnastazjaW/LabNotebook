package pl.coderslab.labnotebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home", "/register").permitAll()
                .antMatchers("/project/**").authenticated()
                .and().formLogin().defaultSuccessUrl("/project/list")
                .and().logout().permitAll().invalidateHttpSession(true).clearAuthentication(true);
//                .and().exceptionHandling().accessDeniedPage("/403");

//                .defaultSuccessUrl("/user/current_tasks");
        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserServiceImpl userService() {
//        return new UserServiceImpl();
//    }

}
