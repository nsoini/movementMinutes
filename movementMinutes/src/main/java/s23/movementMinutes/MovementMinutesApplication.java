package s23.movementMinutes;



import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.movementMinutes.domain.AppUser;
import s23.movementMinutes.domain.AppUserRepository;
import s23.movementMinutes.domain.Category;
import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.Exercise;
import s23.movementMinutes.domain.ExerciseRepository;
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
	public CommandLineRunner demo(MovementRepository moveRepository, CategoryRepository catRepository, IntensityRepository inteRepository, ExerciseRepository exeRepository, AppUserRepository userRepository) {
		return (args) -> {
			userRepository.save(new AppUser("user1", "user1@test.fi", "$2a$10$n92RNo7mvAtFHILGdzsA/Oa1fKuWdIT5pe2VZVSXSnUOsYy35mmr6", "USER"));
			userRepository.save(new AppUser("user2", "user2@test.fi", "$2a$10$aQqLKZGvhjzQrijtQxp2qeX.hNJiko26NCJ0/.nIC01eJR9tSo7BG", "USER"));
			userRepository.save(new AppUser("admin", "admin@test.fi", "$2a$10$45kuUqsr1dIvv.ViLupVEOKxSNdY07Ls4pYe1G8MZEK1To95ljQ.y", "ADMIN"));
			
			catRepository.save(new Category("Arkiliikunta"));
			catRepository.save(new Category("Kestävyysliikunta"));
			catRepository.save(new Category("Lihaskuntoharjoittelu"));
			
			inteRepository.save(new Intensity("Kevyt"));
			inteRepository.save(new Intensity("Kohtalainen"));
			inteRepository.save(new Intensity("Reipas"));
			inteRepository.save(new Intensity("Raskas"));
			
			exeRepository.save(new Exercise("Kävely", "test"));
			exeRepository.save(new Exercise("Uinti", "test"));
			exeRepository.save(new Exercise("Tennis", "test"));
			
			moveRepository.save(new Movement(new Date(), "10.30", exeRepository.findByName("Kävely").get(0), 15, "ok", catRepository.findByName("Arkiliikunta").get(0), inteRepository.findByName("Kevyt").get(0)));
			moveRepository.save(new Movement(new Date(), "12.00", exeRepository.findByName("Kävely").get(0), 30, "kiva", catRepository.findByName("Arkiliikunta").get(0), inteRepository.findByName("Kevyt").get(0)));
			moveRepository.save(new Movement(new Date(), "18.30", exeRepository.findByName("Tennis").get(0), 20, "jee", catRepository.findByName("Kestävyysliikunta").get(0), inteRepository.findByName("Kohtalainen").get(0)));

			
		};
	}

}
