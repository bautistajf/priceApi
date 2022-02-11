package org.challenge.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.challenge.util.ControllerHelper.PRICE_CONTROLLER_PATH;


@EnableWebSecurity
@Profile(value = {"local"})
@SuppressWarnings("squid:S1075")
public class WebSecurityConfiguration {

    private WebSecurityConfiguration() {
    }

    @Order(1)
    @Configuration
    @AllArgsConstructor
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity http) throws Exception {
            http.ignoring()
                    .antMatchers("/swagger-ui/**")
                    .antMatchers("/swagger-ui.html")
                    .antMatchers("/**/api-docs/**")
                    .antMatchers("/**/management/**")
                    .antMatchers("/**/management")
                    .antMatchers("/h2-console")
                    .antMatchers("/**" + PRICE_CONTROLLER_PATH + "/**");
        }
    }

}
