package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.semester.Semester;


public class ListCommandParser implements Parser<ListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns a ListCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    @Override
    public ListCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        if (userInput.trim().equals("")) {
            return new ListCommand();
        }
        try {
            Semester semester = ParserUtil.parseSemester(userInput);
            return new ListCommand(semester);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_SEMESTER), pe);
        }
    }
}
