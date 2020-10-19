package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.GoalTarget;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LIST_GOAL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SET_GOAL;

/**
 * Set the goal of the user for S/U recommendations.
 */
public class SetCommand extends Command {

    public static final String COMMAND_WORD = "goal";

    public static final String MESSAGE_SUCCESS = "Your goal has been set to: %1$s";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets your goal.\n"
            + "Parameters: '"
            + PREFIX_SET_GOAL + "NUMBER' " + "or '"
            + PREFIX_LIST_GOAL + "'\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_SET_GOAL + "2";

    private final GoalTarget goalTarget;

    public SetCommand(GoalTarget goalTarget) {
        this.goalTarget = goalTarget;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (goalTarget.goalTarget == GoalTarget.DEFAULT_GOAL) {
            return new CommandResult(GoalTarget.GOAL_LIST);
        }
        model.setGoalTarget(goalTarget);
        return new CommandResult(String.format(MESSAGE_SUCCESS, goalTarget));
    }
}
