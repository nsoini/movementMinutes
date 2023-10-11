package s23.movementMinutes.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IntensityRepository extends CrudRepository<Intensity, Long> {

	List<Intensity> findByName(String name);
	
}
