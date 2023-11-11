package s23.movementMinutes.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long exerciseId;
	
	@NotEmpty(message="Anna liikuntalajille nimi, esim. uinti.")
	private String name;
	
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
	@JsonIgnore
	private List<Movement> movements;
	
	public Exercise() {
		super();
	}

	public Exercise(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Long exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

}
