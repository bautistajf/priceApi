package org.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@RequiredArgsConstructor
@SpringBootApplication
@SuppressWarnings("squid:S4823")
public class PriceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PriceApplication.class, args);
    }
}
