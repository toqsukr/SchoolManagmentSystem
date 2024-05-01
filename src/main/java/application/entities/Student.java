package application.entities;

import java.util.ArrayList;
import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityDao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Person implements IEntityDao {

	public Student() {
	};

	public Student(String _name, String _surname, Klass klass) {
		super(_name, _surname);
		setKlass(klass);
	}

	private static final EntityDao<Student> em = new EntityDao<>(Student.class);

	public static EntityDao<Student> getEntityDao() {
		return em;
	}

	@Id
	@Column(name = "studentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentID;

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(int id) {
		studentID = id;
	}

	@ManyToOne()
	@JoinColumn(name = "klassName")

	private Klass klass;

	public Klass getKlass() {
		return klass;
	}

	public void setKlass(Klass _klass) {
		klass = _klass;
	}

	@OneToMany(mappedBy = "progressID.student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Progress> progress = new ArrayList<>();

	public List<Progress> getProgress() {
		return progress;
	}

	public Double getAverageMark() {
		Double averageMark = 0.0;
		Integer markCount = 0;
		for (Progress value : progress) {
			if (!value.getAverageMark().equals(0.0)) {
				averageMark += value.getAverageMark();
				markCount++;
			}
		}
		return averageMark / markCount;
	}

	public String determineStudentStatus() {
		Double averageGrade = getAverageMark();
		if (averageGrade >= 4.5) {
			return "Отличник";
		} else if (averageGrade >= 4.0 && averageGrade < 4.5) {
			return "Хорошист";
		} else if (averageGrade >= 3.0 && averageGrade < 4.0) {
			return "Троечник";
		} else {
			return "Двоечник";
		}
	}
}
