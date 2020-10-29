package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOUBLE_DEGREE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ProgressCommand;

public class ProgressCommandParserTest {
    
    private ProgressCommandParser parser = new ProgressCommandParser();

    private final boolean isDdp = true;
    
    private static final String INVALID_INPUT = "invalid input";
    
    @Test
    public void parse_no_input_success() {
        assertParseSuccess(parser, "", new ProgressCommand(!isDdp));
    }
    
    @Test
    public void parse_input_ddp_success() {
        assertParseSuccess(parser, PREFIX_DOUBLE_DEGREE.getPrefix(), new ProgressCommand(isDdp));
    }
    
    @Test
    public void parse_invalid_input_failure() {
        assertParseFailure(parser, INVALID_INPUT, String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, ProgressCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_ddp_with_invalid_input_failure() {
        String userInput = PREFIX_DOUBLE_DEGREE + " " + INVALID_INPUT;
        assertParseFailure(parser, userInput, String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, ProgressCommand.MESSAGE_USAGE));
    }
}
