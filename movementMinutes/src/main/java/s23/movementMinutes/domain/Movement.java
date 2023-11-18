package s23.movementMinutes.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="movement")
public class Movement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Toteutunut liike ei voi olla tulevaisuudessa.")
    @Column(name = "date", nullable = false)
    private Date date;
    
    @NotEmpty(message = "Lisää aloitusaika.")
    @Column(name = "startTime", nullable = false)
	private String startTime;
	
    @Size(min = 3, max= 20, message = "Lisää harjoituksen liike." )
    @Column(name = "exercise", nullable = false)
    private String exercise;
	
	@Min(value = 5, message = "Pienin arvo voi olla 5 minuuttia.")
	@Column(name = "minutes", nullable = false)
	private int minutes;
	
	@Size(min = 0, max= 20, message = "Voit käyttää 20 merkkiä.")
	@Column(name = "comment")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser appuser;
	
	@ManyToOne
	@JoinColumn(name = "catId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "IntId")
	private Intensity intensity;

	public Movement() {
	}

	public Movement(Date date,String startTime, String exercise, int minutes, String comment, Category category, Intensity intensity, AppUser appuser) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.exercise = exercise;
		this.minutes = minutes;
		this.comment = comment;
		this.category = category;
		this.intensity = intensity;
		this.appuser = appuser;
	}

	public AppUser getAppuser() {
		return appuser;
	}

	public void setAppuser(AppUser appuser) {
		this.appuser = appuser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
