package s23.movementMinutes.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Intensity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long intId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "intensity")
	@JsonIgnore
	private List<Movement> movements;
	
	public Intensity () {
		
	}

	public Intensity(String name) {
		super();
		this.name = name;
	}

	public Long getIntId() {
		return intId;
	}

	public void setIntId(Long intId) {
		this.intId = intId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	
	

}
