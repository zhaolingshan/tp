package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class DoneCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_done_success() {
        CommandResult expectedCommandResult = new CommandResult(DoneCommand.MESSAGE_DONE_SEMESTER_SUCCESS,
                false, false, false, true);
        assertCommandSuccess(new DoneCommand(), model, expectedCommandResult, expectedModel);
    }
}
