package pl.coderslab.labnotebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.coderslab.labnotebook.user.UserService;
import pl.coderslab.labnotebook.user.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home", "/registration").permitAll()
                .antMatchers( "/project/**").authenticated()
                .and().formLogin()
                .and().logout().logoutUrl("/logout").invalidateHttpSession(true).clearAuthentication(true)
                .and().exceptionHandling().accessDeniedPage("/403");
//                .and().exceptionHandling().accessDeniedPage("/403");

//                .defaultSuccessUrl("/user/current_tasks");
        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl();
    }


}
