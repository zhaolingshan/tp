package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MODULES;

import seedu.address.commons.core.Messages;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

/**
 * Lists all modules in MyMods to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all modules.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Listed all modules";

    private final Semester readOnlySemester;

    /**
     * Creates a ListCommand to add the specified {@code Semester}
     */
    public ListCommand(Semester semester) throws ParseException {
        requireNonNull(semester);
        if (!SemesterManager.isValidSemester(semester.toString())) {
            throw new ParseException(Messages.MESSAGE_INVALID_SEMESTER);
        }
        readOnlySemester = semester;
    }

    public ListCommand() {
        readOnlySemester = Semester.NA;
    }


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setReadOnlySem(readOnlySemester);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);

        if (readOnlySemester == Semester.NA) {
            return new CommandResult(MESSAGE_SUCCESS);
        } else {
            return new CommandResult(MESSAGE_SUCCESS + " in " + readOnlySemester.toString(),
                    false, false, false, true);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ListCommand; // instanceof handles nulls
    }
}
