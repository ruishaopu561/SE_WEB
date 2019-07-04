package rsp.demo1.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/**", "/register").permitAll()
                    .antMatchers(HttpMethod.OPTIONS).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .failureForwardUrl("/login?error")
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .and()
                .cors().and().csrf().disable();
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response){
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        User u = new User();
//
//        HttpSession session = request.getSession();
//
//        session.setAttribute("userID",u.getId());
//        session.setAttribute("email",u.getEmail());
//        session.setAttribute("password",u.getPassword());
//
//        Cookie cookie = new Cookie();
//        response.addCookie(cookie);
//    }

    @Bean
    public WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //是否发送Cookie
                        .allowCredentials(true)
                        //放行哪些原始域
                        .allowedOrigins("*")
                        .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                        .allowedHeaders("*");
            }
        };
    }
}
