package s23.movementMinutes;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.movementMinutes.domain.Category;
import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.Intensity;
import s23.movementMinutes.domain.Movement;
import s23.movementMinutes.domain.MovementRepository;
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
			
			moveRepository.save(new Movement(LocalDate.parse("2021-10-11"), "13.30", "Kävely", 15, "", catRepository.findByName("Arkiliikunta").get(0), inteRepository.findByName("Kevyt").get(0)));
		};
	}

}
