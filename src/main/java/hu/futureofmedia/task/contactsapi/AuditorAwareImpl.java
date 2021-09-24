package hu.futureofmedia.task.contactsapi;

import org.springframework.data.domain.AuditorAware;
import java.time.LocalDateTime;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<LocalDateTime> {

    @Override
    public Optional<LocalDateTime> getCurrentAuditor() {
        return Optional.empty();
    }
}
