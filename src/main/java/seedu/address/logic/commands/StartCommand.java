package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

/**
 * Starts the editing of the module list in a semester.
 * Enables the user to add, edit or delete modules in
 * a particular semester.
 */
public class StartCommand extends Command {

    public static final String COMMAND_WORD = "start";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Starts adding or editing modules in the semester stated.\n"
            + "Parameters: MODULE_NAME\n"
            + "Example: " + COMMAND_WORD + " Y2S1";

    public static final String MESSAGE_START_SEMESTER_SUCCESS =
            "You are now editing: %1$s \n The modules you are taking in %1$s:";

    private final Semester toStart;

    /**
     * Creates a StartCommand to add the specified {@code Semester}
     */
    public StartCommand(Semester semester) {
        requireNonNull(semester);
        toStart = semester;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(toStart);
        return new CommandResult(String.format(MESSAGE_START_SEMESTER_SUCCESS, toStart));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StartCommand // instanceof handles nulls
                && toStart.equals(((StartCommand) other).toStart));
    }
}
