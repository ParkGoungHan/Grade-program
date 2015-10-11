package sungjuk;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = -2904785696690499366L;

	String name;
	String studentId;
	int jumsu;
	
	public Student(String name, String studentId, int jumsu) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.jumsu = jumsu;
	}
	public Student(String name, String studentId) {
		this(name, studentId, 0);
	}
	
	@Override
	public String toString() {
		return "이름: " + name + 
				", 학번: " + studentId +
				", 점수: " + jumsu;
	}	

}