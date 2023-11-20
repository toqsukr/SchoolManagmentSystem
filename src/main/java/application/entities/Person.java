package application.entities;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person {
	
	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	public Person() {};
		
	public Person(String _name, String _surname) {
		this.setName(_name);
		this.setSurname(_surname);
	}

	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return name;
	}

	public void setSurname(String _surname) {
		surname = _surname;
	}
	
	public String getSurname() {
		return surname;
	}
}