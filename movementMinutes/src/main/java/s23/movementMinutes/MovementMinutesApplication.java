package s23.movementMinutes;



import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.movementMinutes.domain.Category;
import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.Intensity;
import s23.movementMinutes.domain.MovementRepository;
import s23.movementMinutes.domain.Movement;
import s23.movementMinutes.domain.IntensityRepository;

@SpringBootApplication
public class MovementMinutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovementMinutesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(MovementRepository moveRepository, CategoryRepository catRepository, IntensityRepository inteRepository) {
		return (args) -> {
			catRepository.save(new Category("Arkiliikunta"));
			catRepository.save(new Category("Kestävyysliikunta"));
			catRepository.save(new Category("Lihaskuntoharjoittelu"));
			
			inteRepository.save(new Intensity("Kevyt"));
			inteRepository.save(new Intensity("Kohtalainen"));
			inteRepository.save(new Intensity("Reipas"));
			inteRepository.save(new Intensity("Raskas"));
			
			moveRepository.save(new Movement(new Date(), "10.30", "kävely", 15, "ok", catRepository.findByName("Arkiliikunta").get(0), inteRepository.findByName("Kevyt").get(0)));
			moveRepository.save(new Movement(new Date(), "12.00", "kävely", 30, "kiva", catRepository.findByName("Arkiliikunta").get(0), inteRepository.findByName("Kevyt").get(0)));
			moveRepository.save(new Movement(new Date(), "18.30", "tanssi", 20, "jee", catRepository.findByName("Kestävyysliikunta").get(0), inteRepository.findByName("Kohtalainen").get(0)));

			
		};
	}

}
