package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class ExitCommandParserTest {

    private ExitCommandParser parser = new ExitCommandParser();

    @Test
    public void parse_invalidValue_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        final String invalidValue = "hello";
        assertParseFailure(parser, invalidValue,
                String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, ExitCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validValue_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        final String validValue = "";
        ExitCommand exitCommand = new ExitCommand();
        assertParseSuccess(parser, validValue, exitCommand);
    }
}
