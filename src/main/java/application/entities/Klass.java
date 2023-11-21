package application.entities;

import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityName;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "klass")
public class Klass implements IEntityName {

	public Klass() {};
	
	public Klass(String _name) {
		this.setName(_name);
	}

	private static final EntityDao<Klass> em = new EntityDao<>(Klass.class);

	public static EntityDao<Klass> getEntityDao() {
		return em;
	}
	
	@Id 
	@Column(name = "klassName") 
	private String name; 

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	@OneToMany(mappedBy = "klass")
	private List<Student> students = new ArrayList<>();


	@ManyToMany
	@JoinTable(
			name = "klass_has_teacher",
			joinColumns = {@JoinColumn(name = "klassName")},
			inverseJoinColumns = {@JoinColumn(name = "teacherID")}
	)
	
	private List<Teacher> teachers = new ArrayList<>();

	public List<Teacher> getTeachers() {
		return teachers;
	}
}
