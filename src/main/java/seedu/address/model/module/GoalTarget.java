package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the user's goal following the Honours Classification in NUS.
 */
public class GoalTarget {

    public static final String MESSAGE_CONSTRAINTS =
            "Goal should be an integer from 1 to 6, and it should not be blank."
                    + "\nUse command 'goal --list' to see all goals!";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public static final String HIGHEST_DISTINCTION = "Highest Distinction (CAP 4.50 ~ 5.00)";
    public static final String DISTINCTION = "Distinction (CAP 4.00 ~ 4.49)";
    public static final String MERIT = "Merit (CAP 3.50 ~ 3.99)";
    public static final String HONOURS = "Honours (CAP 3.00 ~ 3.49)";
    public static final String PASS = "Pass (CAP 2.00 ~ 2.99)";
    public static final String FAIL = "Fail (CAP < 2.00)";
    public static final String GOAL_LIST = "'goal --set 1': " + HIGHEST_DISTINCTION
            + "\n'goal --set 2': " + DISTINCTION
            + "\n'goal --set 3': " + MERIT
            + "\n'goal --set 4': " + HONOURS
            + "\n'goal --set 5': " + PASS
            + "\n'goal --set 6': " + FAIL;
    public static final int DEFAULT_GOAL = 0;

    public final int goalTarget;

    public GoalTarget(int goalTarget) {
        requireNonNull(goalTarget);
        checkArgument(isValidGoal(goalTarget), MESSAGE_CONSTRAINTS);
        this.goalTarget = goalTarget;
    }

    public GoalTarget() {
        this.goalTarget = DEFAULT_GOAL;
    }

    public int getGoalTarget() {
        return goalTarget;
    }

    /**
     * Returns true if a given int is a valid goal target.
     */
    public static boolean isValidGoal(int goalTarget) {
        return (goalTarget > 0 && goalTarget < 7) && Integer.toString(goalTarget).matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        switch (goalTarget) {
        case 1:
            return HIGHEST_DISTINCTION;
        case 2:
            return DISTINCTION;
        case 3:
            return MERIT;
        case 4:
            return HONOURS;
        case 5:
            return PASS;
        case 6:
            return FAIL;
        default:
            return MESSAGE_CONSTRAINTS;
        }
    }
}
