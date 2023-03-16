import enams.StudyProfile;
import model.Student;
import model.University;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setAvgExamScore((float)3.5)
                .setCurrentCourseNumber(3)
                .setFullName("Ivanova Anna Alexandrovna")
                .setUniversityId("0001-high");
        System.out.println(student);

        University university = new University();
        university.setId("0001-high")
                .setFullName("Some Technical University")
                .setShortName("STU")
                .setYearOfFoundation(1985)
                .setMainProfile(StudyProfile.COMPUTER_SCIENCE);
        System.out.println(university);
    }
}
