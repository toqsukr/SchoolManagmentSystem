package com.course.classes;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {
	//private Progress progress;
	
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "grp_id", referencedColumnName = "id")
    private Group group;

	public void setGroup(Group somegroup) {
		this.group = somegroup;
	}
	
	public Group getGroup() {
		return group;
	}
	
	// public void setProgress() {
	// 	Progress new_progress = new Progress();
	// 	this.progress = new_progress;
	// }
	
	// public Progress getProgress() {
	// 	return progress;
	// }
	
	// public void addProgress(Progress someSubjectProgress) {}
	// public void switchGroup() {}
}
