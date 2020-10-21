package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code SetCommand}.
 */
public class SetCommandTest {

    private Model model = new ModelManager(new AddressBook(), new UserPrefs(), new GoalTarget());

    @Test
    public void constructor_nullModule_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new SetCommand(null));
    }

    @Test
    public void execute_validGoalTarget_success() {
        GoalTarget goalTarget = new GoalTarget(1);
        SetCommand setCommand = new SetCommand(goalTarget);

        String expectedMessage = String.format(SetCommand.MESSAGE_SUCCESS, goalTarget);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), new GoalTarget(1));

        assertCommandSuccess(setCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_listGoalTarget_success() {
        GoalTarget goalTarget = new GoalTarget();
        SetCommand setCommand = new SetCommand(goalTarget);

        String expectedMessage = GoalTarget.GOAL_LIST;

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), new GoalTarget());

        assertCommandSuccess(setCommand, model, expectedMessage, expectedModel);
    }

}
