package basic;

import java.util.ArrayList;
import java.util.List;

public class BasicMission {
	public static void main(String[] args) {
		Person student1 = new Student("이태윤", "학생", 27);
		Student student2 = new Student("홍길동", "강사", 40);	// Person student2으로 해도 됨
		Lecturer student3 = new Lecturer("가나다", "학생", 15);	// Person student3으로 해도 됨

		List<Person> everyone = new ArrayList<>();
		everyone.add(student1);
		everyone.add(student2);
		everyone.add(student3);

		for (Person person: everyone) {
			person.speak();
		}
	}
}
