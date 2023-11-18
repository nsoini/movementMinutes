package s23.movementMinutes.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catId", nullable = false, updatable = false)
	private Long catId;
	
	@NotEmpty(message= "Liiketyyppi ei voi olla tyhjä.")
	@Size(min=2, max=30, message= "Täytä 2-30 merkkiä.")
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnore
	private List<Movement> movements;
	
	public Category() {
		super();
		
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
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
