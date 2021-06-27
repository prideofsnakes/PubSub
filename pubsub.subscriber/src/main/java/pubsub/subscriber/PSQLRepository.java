package pubsub.subscriber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PSQLRepository<T> extends JpaRepository<T, Integer> {

}
