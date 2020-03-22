package org.wirvsvirus.expertexchange.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {
        "org.wirvsvirus.expertexchange.service"
})
@EnableAutoConfiguration
public class ExpertExchangeServiceConfiguration {

}
