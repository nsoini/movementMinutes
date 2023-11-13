package s23.movementMinutes.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovementRepository extends CrudRepository<Movement, Long> {
	 List<Movement> findByAppuserId(Long userId);

}
