package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalModules.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), new GoalTarget());
    }

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(
                ListCommand.MESSAGE_SUCCESS, false, false, false, true);
        assertCommandSuccess(new ListCommand(), model, expectedCommandResult, expectedModel);
    }
}
