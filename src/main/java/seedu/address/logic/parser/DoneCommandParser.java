package seedu.address.logic.parser;

import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.commands.StartCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.semester.Semester;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class DoneCommandParser implements Parser<DoneCommand> {
    @Override
    public DoneCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        try {
            Semester semester = ParserUtil.parseSemester(userInput);
            return new DoneCommand(semester);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, StartCommand.MESSAGE_USAGE), pe);
        }
    }
}
