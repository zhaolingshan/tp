package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOUBLE_DEGREE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ProgressCommand;

public class ProgressCommandParserTest {

    private static final boolean IS_DDP = true;

    private static final String INVALID_INPUT = "invalid input";

    private ProgressCommandParser parser = new ProgressCommandParser();

    @Test
    public void parse_noInput_success() {
        assertParseSuccess(parser, "", new ProgressCommand(!IS_DDP));
    }

    @Test
    public void parse_inputDdp_success() {
        assertParseSuccess(parser, PREFIX_DOUBLE_DEGREE.getPrefix(), new ProgressCommand(IS_DDP));
    }

    @Test
    public void parse_invalidInput_failure() {
        assertParseFailure(parser, INVALID_INPUT, String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, ProgressCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_ddpWithInvalidInput_failure() {
        String userInput = PREFIX_DOUBLE_DEGREE + " " + INVALID_INPUT;
        assertParseFailure(parser, userInput, String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, ProgressCommand.MESSAGE_USAGE));
    }
}
