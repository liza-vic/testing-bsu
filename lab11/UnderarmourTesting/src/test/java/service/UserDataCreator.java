package service;

import model.UserData;

public class UserDataCreator {
    public static final String TESTDATA_USER_ORDER_NUMBER = "testdata.user.order.number";
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";

    public static UserData withCredentialsFromProperty() {
        return new UserData(TestDataReader.getTestData(TESTDATA_USER_ORDER_NUMBER),
                TestDataReader.getTestData(TESTDATA_USER_EMAIL));
    }
}
