package com.rosyidgrobogan.belajarspringapi.helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Component
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class AuditorAwareHelperBeanHelper {

    @Bean
    public AuditorAware<String> auditorAwareBean(){
        return new AuditorAwareHelper();
    }
}
