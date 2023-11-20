package com.course.classes;
import jakarta.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {
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

	@Column(name = "name")
    private String name;

	public void setName(String somename) {
		this.name = somename;
	}
	
	public String getName() {
		return name;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "grp", referencedColumnName = "id")
    private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group new_group) {
		this.group = new_group;
	}		

    
}