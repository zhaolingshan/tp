package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

/**
 * Stops the modifying of the module list in a semester.
 * Signifies that the user is done editing the module list
 * and prevents the user from adding, editing or deleting
 * modules in a particular semester.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Stops the adding or editing of modules in the current semester.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_DONE_SEMESTER_SUCCESS =
            "You are done editing: " + SemesterManager.getInstance().getCurrentSemester().toString();

    @Override
    public CommandResult execute(Model model) throws CommandException {
        SemesterManager semesterManager = SemesterManager.getInstance();
        Semester semester = semesterManager.getCurrentSemester();
        
        if (semester == Semester.NA) {
            throw new CommandException(Messages.MESSAGE_INVALID_DONE_COMMAND);
        }
        
        semesterManager.setCurrentSemester(Semester.NA);
        return new CommandResult(MESSAGE_DONE_SEMESTER_SUCCESS, false, false, false, true);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof DoneCommand; // instanceof handles nulls
    }
}
