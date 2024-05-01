package application.entities;

import application.database.EntityDao;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "progress")
public class Progress {
	private static final EntityDao<Progress> em = new EntityDao<>(Progress.class);

	public Progress() {
	};

	public Progress(Subject _subject, Student _student) {
		ProgressID id = new ProgressID();
		id.setStudent(_student);
		id.setSubject(_subject);
		this.setProgressID(id);
	}

	public static EntityDao<Progress> getEntityDao() {
		return em;
	}

	@EmbeddedId
	private ProgressID progressID;

	public ProgressID getID() {
		return progressID;
	}

	private void setProgressID(ProgressID _id) {
		progressID = _id;
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
