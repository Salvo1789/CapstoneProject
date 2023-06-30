package salvomercurio.NewrizonWebsite.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import salvomercurio.NewrizonWebsite.entities.Accessory;

public interface AccessoriesRepository extends JpaRepository<Accessory, UUID> {

	Optional<Accessory> findByName(String name);

	Optional<Accessory> findById(UUID id);

	@Query("SELECT a FROM Accessory a WHERE a.price >= :price1 AND a.price <= :price2")
	Page<Accessory> findByPriceBetween(double price1, double price2, Pageable pageable);
}
