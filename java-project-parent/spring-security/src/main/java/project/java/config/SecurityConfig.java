package project.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import project.java.model.Permission;
import project.java.model.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                //.antMatchers("/api/v1/auth/login").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/**").hasAuthority(Permission.DEVELOPER_READ.getPermission())
                //.antMatchers(HttpMethod.POST, "/api/**").hasAuthority(Permission.DEVELOPER_WRITE.getPermission())
                //.antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Permission.DEVELOPER_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean("userDetailsService")
    @Override
    protected UserDetailsService userDetailsService() {
        //passwordEncoder().encode("admin") >> $2a$12$MvaiHWKrSYODBWrs.YAJguR0B.lYWje6C82IJA9xr0trWEUd2v8fa
        //passwordEncoder().encode("user") >> $2a$12$aJ2sWWGcXJvziKfYaUwQGeLYivIIeLhh6OghNFMXl7tAC9c3Wkr1S
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password("$2a$12$MvaiHWKrSYODBWrs.YAJguR0B.lYWje6C82IJA9xr0trWEUd2v8fa")
                        .authorities(Role.ADMIN.getAuthorities())
                        //.roles(Role.ADMIN.name())
                        .build(),
                User.builder()
                        .username("user")
                        .password("$2a$12$aJ2sWWGcXJvziKfYaUwQGeLYivIIeLhh6OghNFMXl7tAC9c3Wkr1S")
                        .authorities(Role.USER.getAuthorities())
                        //.roles(Role.USER.name())
                        .build()
        );
    }
}
