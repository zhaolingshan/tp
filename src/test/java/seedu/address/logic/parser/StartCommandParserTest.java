package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.StartCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.semester.Semester;

public class StartCommandParserTest {

    private StartCommandParser parser = new StartCommandParser();

    @Test
    public void parse_invalidValue_failure() {
        final String invalidValue = "hello";
        assertParseFailure(parser, invalidValue, Messages.MESSAGE_INVALID_SEMESTER);
    }

    @Test
    public void parse_invalidSemester_failure() {
        Semester invalidSemester = Semester.NA;
        assertParseFailure(parser, invalidSemester.toString(), Messages.MESSAGE_INVALID_SEMESTER);
    }

    @Test
    public void parse_validSemester_success() throws ParseException {
        Semester validSemester = Semester.Y3S1;
        StartCommand startCommand = new StartCommand(validSemester);
        assertParseSuccess(parser, validSemester.toString(), startCommand);
    }
}
