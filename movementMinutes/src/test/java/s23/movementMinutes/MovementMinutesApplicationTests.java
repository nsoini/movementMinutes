package s23.movementMinutes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s23.movementMinutes.web.MovementController;


@SpringBootTest
class MovementMinutesApplicationTests {
	
	@Autowired
	private MovementController movecontroller;

	@Test
	void contextLoads() throws Exception{
		assertThat(movecontroller).isNotNull();
	}

}
