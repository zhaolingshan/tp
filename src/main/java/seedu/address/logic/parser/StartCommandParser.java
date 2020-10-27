package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.StartCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

public class StartCommandParser implements Parser<StartCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the StartCommand
     * and returns a StartCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    @Override
    public StartCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        try {
            Semester semester = ParserUtil.parseSemester(userInput);
            return new StartCommand(semester);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(SemesterManager.MESSAGE_INVALID_SEMESTER), pe);
        }
    }
}
