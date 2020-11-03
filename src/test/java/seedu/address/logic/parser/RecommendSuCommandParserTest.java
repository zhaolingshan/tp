package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.RecommendSuCommand;

public class RecommendSuCommandParserTest {

    private RecommendSuCommandParser parser = new RecommendSuCommandParser();

    @Test
    public void parse_invalidValue_failure() {
        final String invalidValue = "e";
        assertParseFailure(parser, invalidValue,
                String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, RecommendSuCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validValue_success() {
        final String validValue = "";
        RecommendSuCommand recommendSuCommand = new RecommendSuCommand();
        assertParseSuccess(parser, validValue, recommendSuCommand);
    }
}
