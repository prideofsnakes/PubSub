package pubsub.subscriber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PSQLRepository extends JpaRepository<PurchaseEntity, Integer> {

}
