package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MOD_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SEMESTER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import seedu.address.logic.commands.UpdateCommand;
import seedu.address.logic.commands.UpdateCommand.UpdateModNameDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.module.Cap;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new UpdateCommand object
 */
public class UpdateCommandParser implements Parser<UpdateCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UpdateCommand
     * and returns an UpdateCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UpdateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MOD_NAME, PREFIX_GRADE, PREFIX_TAG, PREFIX_SEMESTER);

        if (argMultimap.getValue(PREFIX_MOD_NAME).isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UpdateCommand.MESSAGE_USAGE));
        }
        ModuleName moduleName = ParserUtil.parseName(argMultimap.getValue(PREFIX_MOD_NAME).get());

        UpdateModNameDescriptor updateModNameDescriptor = new UpdateModNameDescriptor();
        updateModNameDescriptor.setName(moduleName);
        if (argMultimap.getValue(PREFIX_GRADE).isPresent()) {
            updateModNameDescriptor.setGrade(ParserUtil.parseGrade(argMultimap.getValue(PREFIX_GRADE).get()));
        } else {
            updateModNameDescriptor.setGrade(new Grade(Cap.NA.toString()));
        }
        parseTagsForUpdate(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(updateModNameDescriptor::setTags);
        if (!updateModNameDescriptor.isAnyFieldUpdated()) {
            throw new ParseException(UpdateCommand.MESSAGE_NOT_UPDATED);
        }
        if (argMultimap.getValue(PREFIX_SEMESTER).isPresent()) {
            updateModNameDescriptor.setSemester(ParserUtil.parseSemester(argMultimap.getValue(PREFIX_SEMESTER).get()));
        }

        return new UpdateCommand(moduleName, updateModNameDescriptor);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForUpdate(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}
