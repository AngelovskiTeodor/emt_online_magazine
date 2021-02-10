package mk.ukim.finki.emt.onlinemagazine.sharedkernel.infrastructure.eventlog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedRemoteEventRepository extends JpaRepository<ProcessedRemoteEvent,String> {
}
