package util;

import comparator.*;
import enams.StudentComparatorType;
import enams.UniversityComparatorType;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType){
        switch (studentComparatorType) {

            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentAvgExamScoreComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        switch (universityComparatorType) {


            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case ID:
                return new UniversityIdComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case YEAR:
                return new UniversityYearComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
