package s23.movementMinutes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import s23.movementMinutes.domain.AppUser;
import s23.movementMinutes.domain.AppUserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MovementMinutesApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppUserRepositoryTest {
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Test
	public void findbyUsernameUserRoleUSER() {
		AppUser users = userRepository.findByUsername("user1");
		assertThat(users.getRole()).isEqualTo("USER");
	}

}
