//package com.example.oauth2.security;
//
//import jp.jast.tomo_common.security.CustomPasswordEncoder;
//import jp.jast.tomo_common.security.SimpleCorsFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.OrRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Arrays;
//import java.util.Collections;
//
///**
// * @author HoanPC
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        prePostEnabled = true,
//        securedEnabled = true
//)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Resource(name = "customUserDetailsService")
//    private UserDetailsService userDetailsService;
//
//    @Value("${security.origin.allow:false}")
//    private boolean allowOrigin;
//
//    private final SimpleCorsFilter filter;
//
//    private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
//            new AntPathRequestMatcher("/swagger-ui/**"),
//            new AntPathRequestMatcher("/api-docs/**")
//
//    );
//
//    public WebSecurityConfig(SimpleCorsFilter filter) {
//        this.filter = filter;
//    }
//
//    /**
//     * If grant_type != client_credentials.
//     *
//     * @param auth AuthenticationManagerBuilder
//     * @throws Exception Error jika data tidak sesuai.
//     */
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth
//                .userDetailsService(this.userDetailsService)
//                .passwordEncoder(new CustomPasswordEncoder());
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    public void configure(final WebSecurity web) {
//        web.ignoring().requestMatchers(PUBLIC_URLS);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        if (allowOrigin) {
//            http.cors().configurationSource(corsConfigurationSource()).and()
//                    .csrf().disable()
//                    .headers().frameOptions().disable();
//        } else {
//            http.cors()
//                    .and()
//                    .csrf().disable()
//                    .headers().frameOptions().deny();
//        }
//
//        http
//                .addFilterBefore(filter, BasicAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint
//                        ((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/actuator/**").permitAll()
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated();
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.singletonList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "OPTIONS", "PATCH"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
