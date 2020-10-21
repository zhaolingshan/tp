package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GoalTargetTest {

    @Test
    public void isValidGoal() {
        // between 1 to 6 (inclusive) -> return true
        assertTrue(GoalTarget.isValidGoal(1));
        assertTrue(GoalTarget.isValidGoal(6));
        assertFalse(GoalTarget.isValidGoal(0));
        assertFalse(GoalTarget.isValidGoal(-1));
        assertFalse(GoalTarget.isValidGoal(7));
    }
}
