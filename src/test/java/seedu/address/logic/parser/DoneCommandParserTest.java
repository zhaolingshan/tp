package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class DoneCommandParserTest {

    private DoneCommandParser parser = new DoneCommandParser();

    @Test
    public void parse_invalidValue_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        final String invalidValue = "hi";
        assertParseFailure(parser, invalidValue, Messages.MESSAGE_INVALID_SEMESTER);
    }

    @Test
    public void parse_validValue_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        final String validValue = "";
        DoneCommand doneCommand = new DoneCommand();
        assertParseSuccess(parser, validValue, doneCommand);
    }
}