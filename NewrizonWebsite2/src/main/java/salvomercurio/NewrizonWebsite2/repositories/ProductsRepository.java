package salvomercurio.NewrizonWebsite2.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import salvomercurio.NewrizonWebsite2.entities.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {

	Optional<Product> findByName(String name);

	Optional<Product> findById(UUID id);

	@Query("SELECT p FROM Product p WHERE p.price >= :price1 AND p.price <= :price2")
	Page<Product> findByPriceBetween(double price1, double price2, Pageable pageable);
}
