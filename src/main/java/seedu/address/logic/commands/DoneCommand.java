package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

/**
 * Stops the modifying of the module list in a semester.
 * Signifies that the user is done updating the module list
 * and prevents the user from adding, updating or deleting
 * modules in a particular semester.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Stops the adding or updating of modules in the semester stated.\n"
            + "Parameters: MODULE_NAME\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_DONE_SEMESTER_SUCCESS =
            "You are done updating: " + SemesterManager.getInstance().getCurrentSemester().toString();

    @Override
    public CommandResult execute(Model model) {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.NA);
        return new CommandResult(MESSAGE_DONE_SEMESTER_SUCCESS, false, false, false, true);
    }
}
