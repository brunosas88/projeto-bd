package br.com.letscode.moduloix.projetobd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/mercado/compras/compra-produto", "/mercado/produtos/listar").permitAll()
                .antMatchers("/mercado/compras/minhas-compras").hasRole("CLIENT")
                .antMatchers("/mercado/compras/admin/**", "/mercado/produtos/admin/**").hasRole("ADMIN");

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("client")
                .password("{noop}client")
                .roles("CLIENT")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN");
    }

}
