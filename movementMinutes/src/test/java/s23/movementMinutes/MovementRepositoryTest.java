package s23.movementMinutes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import s23.movementMinutes.domain.AppUserRepository;
import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.IntensityRepository;
import s23.movementMinutes.domain.MovementRepository;

import s23.movementMinutes.domain.Movement;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MovementMinutesApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovementRepositoryTest {
	
	@Autowired 
	private MovementRepository moveRepository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Autowired
	private IntensityRepository inteRepository;
	
	@Autowired 
	private AppUserRepository userRepository;
	
	@Test
	public void createNewMovement() {
		Movement move = new Movement(new Date(), "10:30", "Juoksu", 15, "Jeeee", catRepository.findByName("Arkiliikunta").get(0), inteRepository.findByName("Kevyt").get(0), userRepository.findByUsername("user1"));
		moveRepository.save(move);
		assertThat(move.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewMovement() {
		List <Movement> moves = (List<Movement>) moveRepository.findAll();
		Movement testMove = moves.get(0);
		Long testMoveid = testMove.getId();
		
		moveRepository.deleteById(testMoveid);
		
		List <Movement> newMoves = (List<Movement>) moveRepository.findAll();
		Movement newTestMove = newMoves.get(0);
		
		assertThat(testMove).isNotEqualTo(newTestMove);		
	}
	
	@Test
	public void delteAllMovements() {
		moveRepository.deleteAll();
		assertThat(moveRepository.equals(null));
		
	}

}
