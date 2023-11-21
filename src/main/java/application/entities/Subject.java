package application.entities;
import java.util.ArrayList;
import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityName;
import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject implements IEntityName {

	public Subject() {};

	public Subject(String _name) {
		this.setName(_name);
	}

	private static final EntityDao<Subject> em = new EntityDao<>(Subject.class);

	public static EntityDao<Subject> getEntityDao() {
		return em;
	}

	@Id 
	@Column(name = "subjectName") 

	private String subjectName;

	public String getName() {
		return subjectName;
	}

	public void setName(String name) {
		subjectName = name;
	}    

	@OneToMany(mappedBy = "progressID.subject")
    private List<Progress> progress = new ArrayList<>();

	public List<Progress> getProgress() {
		return progress;
	}
}