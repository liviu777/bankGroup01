package view;

public class RegistrationDataValidation {
    public boolean firstNameValidation(String firstName) {
        if (firstName.length() < 3) {
            return false;
        } else if (!firstName.chars().allMatch(Character::isLetter)) {
            return false;
        } else if (!Character.isUpperCase(firstName.charAt(0))) {
            return false;
        }
        return true;
    }

    public boolean secondNameValidation(String secondName) {
        if ((secondName.length() < 3) || (!secondName.chars().allMatch(Character::isLetter)) ||
                (!Character.isUpperCase(secondName.charAt(0))))
            return false;
        return true;
    }

    public boolean CNPValidation(String CNP) {
        return (CNP.length() == 13) && (CNP.chars().allMatch(Character::isDigit));
    }
}
