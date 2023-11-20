package com.course.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {	
	private Float currentScore;

	// private void setCurrentScore() {
	// 	float sum = 0;
	// 	for(int i=0; i < marks.size(); i++) {
	// 		sum += marks.get(i);
	// 	}
	// 	currentScore = sum / marks.size();
	// }

	public Float getCurrentScore() {
		return currentScore;
	}

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
	@JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public void addStud(Student stud) {
        this.student = stud;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject sub;
	
	public void addSubject(Subject somesub) {
		this.sub = somesub;
	}

	@Column(name = "marks")
	private int[] marks = new int[45];

	public void addMark(Integer mark) {
		marks[marks.length] = mark;
		// setCurrentScore();
	}

	// public List<Integer> getMarks() {
	// 	return marks.asList();
	// }


	// public void deleteScore() {}
	
	// private void setCurrentScore(Integer[] scores) {}
}
