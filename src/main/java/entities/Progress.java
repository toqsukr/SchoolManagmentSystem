package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "progress")
public class Progress {	
	@EmbeddedId 
	private ProgressID progressID;

  @Column(name = "averageMark")
	private Double averageMark;

	public Double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(Double mark) {
		averageMark = mark;
	}
}
