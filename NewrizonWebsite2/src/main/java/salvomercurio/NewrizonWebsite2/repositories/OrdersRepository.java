package salvomercurio.NewrizonWebsite2.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salvomercurio.NewrizonWebsite2.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, UUID> {

	Optional<Order> findById(UUID id);
}
