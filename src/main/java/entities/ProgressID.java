package entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProgressID implements Serializable {
  @ManyToOne
  @JoinColumn(name = "studentID")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "subjectName")
  private Subject subject;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student _student) {
    student = _student;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject _subject) {
    subject = _subject;
  }
}
