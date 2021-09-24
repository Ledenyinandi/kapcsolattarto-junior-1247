package hu.futureofmedia.task.contactsapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.time.LocalDateTime;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfiguration {

    @Bean
    public AuditorAware<LocalDateTime> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
