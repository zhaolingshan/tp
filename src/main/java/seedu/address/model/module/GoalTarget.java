package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the user's goal following the Honours Classification in NUS.
 */
public class GoalTarget {

    public static final String MESSAGE_CONSTRAINTS =
            "Goal should be an integer from 1 to 6, and it should not be blank.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final int goalTarget;

    public GoalTarget(int goalTarget) {
        requireNonNull(goalTarget);
        checkArgument(isValidGoal(goalTarget), MESSAGE_CONSTRAINTS);
        this.goalTarget = goalTarget;
    }

    /**
     * Returns true if a given int is a valid goal target.
     */
    public static boolean isValidGoal(int goalTarget) {
        return (goalTarget > 0 && goalTarget < 7) && Integer.toString(goalTarget).matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return Integer.toString(goalTarget);
    }
}
