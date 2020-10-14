package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Module's grade in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidGrade(String)}
 */
public class Grade {

    public static final String MESSAGE_CONSTRAINTS = 
            "Grades can be either A+, A, A-, B+, B, B-, C+, C, D+, D or F, and it should not be blank";

    /*
     * The first character of the Grade must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    private final CAP cap;

    /**
     * Constructs an {@code Grade}.
     *
     * @param grade A valid grade.
     */
    public Grade(String grade) {
        requireNonNull(grade);
        checkArgument(isValidGrade(grade), MESSAGE_CONSTRAINTS);
        cap = CAP.valueOf(grade);
    }

    /**
     * Returns true if a given string is a valid grade.
     */
    public static boolean isValidGrade(String test) {
        return containsGrade(test) && test.matches(VALIDATION_REGEX);
    }

    public static boolean containsGrade(String test) {
        for (CAP c : CAP.values()) {
            if (c.getGrade().equals(test)) {
                return true;
            }
        }
        return false;
    }

    public CAP getCap() {
        return cap;
    }

    @Override
    public String toString() {
        return cap.getGrade();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Grade // instanceof handles nulls
                && cap.equals(((Grade) other).cap)); // state check
    }

    @Override
    public int hashCode() {
        return cap.hashCode();
    }

}
