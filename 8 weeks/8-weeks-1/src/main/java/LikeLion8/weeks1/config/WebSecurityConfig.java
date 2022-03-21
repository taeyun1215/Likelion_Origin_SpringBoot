package LikeLion8.weeks1.config;

import LikeLion8.weeks1.infra.CustomUserDetailService;
import LikeLion8.weeks1.infra.NaverOAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final NaverOAuth2Service naverOAuth2Service;

    public WebSecurityConfig(
            @Autowired CustomUserDetailService customUserDetailService,
            @Autowired NaverOAuth2Service naverOAuth2Service
    ) {
        this.userDetailsService = customUserDetailService;
        this.naverOAuth2Service = naverOAuth2Service;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password(passwordEncoder().encode("user1pass"))
//                .roles("USER")
//                .and()
//                .withUser("admin1")
//                .password(passwordEncoder().encode("admin1pass"))
//                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home/**", "/user/singup/**")
                .anonymous()    // 익명의 사용자
                .anyRequest()   // 나머지를 다 포함하는거라 마지막에 설정 해야함
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/home")
                .permitAll()
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                    .userService(this.naverOAuth2Service)
                .and()
                    .defaultSuccessUrl("/home")
            .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSEESIONID")
                .invalidateHttpSession(true)
                .permitAll();
//              .antMatchers("/borad//post/**")    // 4주차 과제를 이렇게 둘 수 있음
//              .authenticated()    // 로그인 해야지 접속 가능
//              .permitAll()    // 누구든 접속 가능
    }
}
