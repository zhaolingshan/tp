package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MOD_NAME;

import seedu.address.logic.commands.SuCommand;
import seedu.address.logic.commands.UpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModuleName;

/**
 * Parses input arguments and creates a new SuCommand object
 */
public class SuCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the SuCommand
     * and returns an SuCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SuCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MOD_NAME);

        if (argMultimap.getValue(PREFIX_MOD_NAME).isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SuCommand.MESSAGE_USAGE));
        }
        ModuleName moduleName = ParserUtil.parseName(argMultimap.getValue(PREFIX_MOD_NAME).get());

        UpdateCommand.UpdateModNameDescriptor updateModNameDescriptor = new UpdateCommand.UpdateModNameDescriptor();
        updateModNameDescriptor.setName(moduleName);
        updateModNameDescriptor.setGrade(new Grade("SU"));

        return new SuCommand(moduleName, updateModNameDescriptor);
    }
}
