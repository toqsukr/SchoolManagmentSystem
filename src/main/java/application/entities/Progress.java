package application.entities;

import application.database.EntityDao;
import jakarta.persistence.*;


@Entity
@Table(name = "progress")
public class Progress {	
	private static final EntityDao<Progress> em = new EntityDao<>(Progress.class);

	public static EntityDao<Progress> getEntityDao() {
		return em;
	}

	@EmbeddedId 
	private ProgressID progressID;

	public ProgressID getID() {
		return progressID;
	}

  @Column(name = "averageMark")
	private Double averageMark;

	public Double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(Double mark) {
		averageMark = mark;
	}
}
