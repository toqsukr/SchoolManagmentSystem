package entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

	public Subject(String _name) {
		this.setSubjectName(_name);
	}

	@Id 
	@Column(name = "subjectName") 

	private String subjectName;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String name) {
		subjectName = name;
	}    

	@OneToMany(mappedBy = "progressID.subject")
    private List<Progress> progress = new ArrayList<>();

	public List<Progress> getProgress() {
		return progress;
	}
}