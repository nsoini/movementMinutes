package s23.movementMinutes.domain;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate date;
	private String startTime;
	private String exercise;
	private int minutes;
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "intensityId")
	private Intensity intensity;



	public Movement() {
	}

	public Movement(LocalDate date, String startTime, String exercise, int minutes, String comment, Category category,
			Intensity intensity) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.exercise = exercise;
		this.minutes = minutes;
		this.comment = comment;
		this.category = category;
		this.intensity = intensity;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Intensity getIntensity() {
		return intensity;
	}

	public void setIntensity(Intensity intensity) {
		this.intensity = intensity;
	}


}
