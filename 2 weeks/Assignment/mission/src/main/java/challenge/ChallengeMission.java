package challenge;

import basic.Lecturer;
import basic.Person;
import basic.Student;

import java.util.*;

public class ChallengeMission {
    public static void main(String[] args) {
        Person student1 = new Student("이태윤", "학생", 27);
        Student student2 = new Student("홍길동", "강사", 40);	// Person student2으로 해도 됨
        Lecturer student3 = new Lecturer("가나다", "학생", 15);	// Person student3으로 해도 됨

        List<Person> everyone = new ArrayList<>();
        everyone.add(student1);
        everyone.add(student2);
        everyone.add(student3);

        printItems(everyone);
    }

    public static <T> void printItems(Iterable<T> iterable) {   // <>는 제네릭(Generic) 표현식
        Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            System.out.println("NO Element");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for (int idx = 0; iterator.hasNext(); idx++) {
            T item = iterator.next();
            stringBuilder.append(String.format("%d\t\t%s\n", idx, item.toString()));
        }

        System.out.println(stringBuilder);
    }

}
