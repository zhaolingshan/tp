package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.ListCommand;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class ListCommandParserTest {

    private ListCommandParser parser = new ListCommandParser();

    @Test
    public void parse_invalidValue_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        final String invalidValue = "hello";
        assertParseFailure(parser, invalidValue,
                String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validValue_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        final String validValue = "";
        ListCommand listCommand = new ListCommand();
        assertParseSuccess(parser, validValue, listCommand);
    }
}
