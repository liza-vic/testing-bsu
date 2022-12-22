package service;

import model.StudentData;

public class StudentDataCreator {
    public static final String TESTDATA_USER_FIRST_NAME = "testdata.user.student.first.name";
    public static final String TESTDATA_USER_LAST_NAME = "testdata.user.student.last.name";
    public static final String TESTDATA_USER_REGISTERED_ASOS_EMAIL = "testdata.user.student.registered.asos.email";
    public static final String TESTDATA_STUDENT_EMAIL = "testdata.user.student.email";

    public static StudentData withCredentialsFromProperty() {
        return new StudentData(TestDataReader.getTestData(TESTDATA_USER_FIRST_NAME),
                TestDataReader.getTestData(TESTDATA_USER_LAST_NAME),
                TestDataReader.getTestData(TESTDATA_USER_REGISTERED_ASOS_EMAIL),
                TestDataReader.getTestData(TESTDATA_STUDENT_EMAIL));
    }
}
