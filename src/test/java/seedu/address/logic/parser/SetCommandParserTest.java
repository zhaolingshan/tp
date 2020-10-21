package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_GOAL_TARGET;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_TARGET;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.WHITESPACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SET_GOAL;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SetCommand;
import seedu.address.model.module.GoalTarget;

/**
 * Parses input arguments and creates a SetCommand object.
 */
public class SetCommandParserTest {

    private SetCommandParser parser = new SetCommandParser();

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetCommand.MESSAGE_USAGE);

        assertParseFailure(parser, VALID_MOD_NAME_B + VALID_GOAL_TARGET, expectedMessage);
    }

    @Test
    public void parse_invalidGoalTarget_failure() {
        // out of range
        assertParseFailure(parser, SetCommand.COMMAND_WORD + WHITESPACE + PREFIX_SET_GOAL
                + INVALID_GOAL_TARGET, GoalTarget.MESSAGE_CONSTRAINTS);
    }
}
