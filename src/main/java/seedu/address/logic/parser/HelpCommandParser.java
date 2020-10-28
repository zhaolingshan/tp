package seedu.address.logic.parser;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class HelpCommandParser implements Parser<HelpCommand> {
    @Override
    public HelpCommand parse(String userInput) throws ParseException {
        String trimmedInput = userInput.trim();
        if (!trimmedInput.equals("")) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        return new HelpCommand();
    }
}
