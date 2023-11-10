package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import s23.movementMinutes.domain.AppUser;
import s23.movementMinutes.domain.AppUserRepository;

@RestController
public class RestAppUserController {
	
	@Autowired
	AppUserRepository userRepository;
	
	//list all users
	@GetMapping("/appusers")
	public Iterable<AppUser> getAppUser(){
		return userRepository.findAll();
	}
	

}
