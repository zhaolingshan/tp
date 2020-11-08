package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.SuCommand;
import seedu.address.logic.commands.UpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModuleName;

/**
 * Parses input arguments and creates a new SuCommand object
 */
public class SuCommandParser implements Parser<SuCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the SuCommand
     * and returns an SuCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SuCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        ModuleName moduleName;
        moduleName = ParserUtil.parseName(userInput);
        String SU_GRADE = "SU";
        
        UpdateCommand.UpdateModNameDescriptor updateModNameDescriptor = new UpdateCommand.UpdateModNameDescriptor();
        updateModNameDescriptor.setName(moduleName);
        updateModNameDescriptor.setGrade(new Grade(SU_GRADE));

        return new SuCommand(moduleName, updateModNameDescriptor);
    }
}
