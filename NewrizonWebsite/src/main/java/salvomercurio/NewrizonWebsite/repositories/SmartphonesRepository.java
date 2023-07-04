package salvomercurio.NewrizonWebsite.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import salvomercurio.NewrizonWebsite.entities.Smartphone;
import salvomercurio.NewrizonWebsite.entities.SmartphoneColor;

@Repository
public interface SmartphonesRepository extends JpaRepository<Smartphone, UUID> {

	Optional<Smartphone> findByName(String name);

	Optional<Smartphone> findById(UUID id);

	Page<Smartphone> findByDisplay(String display, Pageable pageable);

	Page<Smartphone> findByRAM(int ram, Pageable pageable);

	Page<Smartphone> findByROM(int rom, Pageable pageable);

	Page<Smartphone> findByOS(String os, Pageable pageable);

	Page<Smartphone> findByColor(SmartphoneColor color, Pageable pageable);

	@Query("SELECT s FROM Smartphone s WHERE s.price >= :price1 AND s.price <= :price2")
	Page<Smartphone> findByPriceBetween(double price1, double price2, Pageable pageable);
}
