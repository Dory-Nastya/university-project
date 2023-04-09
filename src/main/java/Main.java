import comparator.StudentComparator;
import comparator.UniversityComparator;
import enams.StudentComparatorType;
import enams.UniversityComparatorType;
import io.XlsReader;
import io.XlsWriter;
import model.Student;
import model.University;
import model.Statistics;
import util.ComparatorUtil;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        String universitiesJson = JsonUtil.universityListToJson(universities);

        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
        });

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);


        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);

            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);

        });
        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }
}