package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

public class DoneCommandParser implements Parser<DoneCommand> {
    @Override
    public DoneCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        SemesterManager semesterManager = SemesterManager.getInstance();
        Semester semester = semesterManager.getCurrentSemester();
        if (semester == Semester.NA) {
            throw new ParseException(Messages.MESSAGE_INVALID_DONE_COMMAND);
        }
        try {
            Semester sem = ParserUtil.parseSemester(userInput);
            return new DoneCommand(sem);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DoneCommand.MESSAGE_USAGE), pe);
        }
    }
}
