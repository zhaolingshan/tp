package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

public class DoneCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();
    
    @Test
    public void execute_done_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, false, false, true);
        assertCommandSuccess(new DoneCommand(), model, expectedCommandResult, expectedModel);
    }
}
