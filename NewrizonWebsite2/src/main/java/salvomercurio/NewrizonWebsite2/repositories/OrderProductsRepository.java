package salvomercurio.NewrizonWebsite2.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import salvomercurio.NewrizonWebsite2.entities.OrderProduct;

public interface OrderProductsRepository extends JpaRepository<OrderProduct, UUID> {

}
