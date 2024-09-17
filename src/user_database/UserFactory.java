package user_database;

import user.*;

public class UserFactory {
    public enum UserType {
        USER,
        CREATOR
    }

    public static AbstractUser createUser(UserType userType) {
        switch (userType) {
            case USER:
                return new User(null, null, null, 0, 0, 0);
            case CREATOR:
                return new Creator(null, null, null, 0, 0, 0);
            default:
                return null;
        }
    }
}
