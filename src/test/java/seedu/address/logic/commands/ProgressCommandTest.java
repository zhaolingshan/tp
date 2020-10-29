package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.VALID_CAP;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ProgressCommand.MESSAGE_CURRENT_CAP;
import static seedu.address.logic.commands.ProgressCommand.MESSAGE_TARGET_CAP;
import static seedu.address.testutil.TypicalModules.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;

public class ProgressCommandTest {
    
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget());

    private final boolean isDdp = true;
    
    @Test
    public void execute_progress_without_ddp_success() {
        model.setGoalTarget(new GoalTarget(3));
        CommandResult expectedCommandResult = new CommandResult(
                String.format(MESSAGE_CURRENT_CAP, VALID_CAP)
                        + String.format(MESSAGE_TARGET_CAP, VALID_CAP));

        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget(3));

        ProgressCommand progressCommand = new ProgressCommand(!isDdp);
        assertCommandSuccess(progressCommand, model, expectedCommandResult, expectedModel);
    }
    
    @Test
    public void execute_progress_with_ddp_success() {
        model.setGoalTarget(new GoalTarget(3));
        CommandResult expectedCommandResult = new CommandResult(
                String.format(MESSAGE_CURRENT_CAP, VALID_CAP)
                        + String.format(MESSAGE_TARGET_CAP, VALID_CAP));

        ModelManager expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget(3));

        ProgressCommand progressCommand = new ProgressCommand(isDdp);
        assertCommandSuccess(progressCommand, model, expectedCommandResult, expectedModel);
    }
}
