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
    private final String invalidValue = "hi";
    private final String validValue = "";

    @Test
    public void parse_invalidValue_validSemester_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        assertParseFailure(parser, invalidValue, Messages.MESSAGE_INVALID_SEMESTER);
    }

    @Test
    public void parse_invalidValue_invalidSemester_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.NA);
        assertParseFailure(parser, invalidValue, Messages.MESSAGE_INVALID_DONE_COMMAND);
    }

    @Test
    public void parse_validValue_invalidSemester_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.NA);
        assertParseFailure(parser, validValue, Messages.MESSAGE_INVALID_DONE_COMMAND);
    }

    @Test
    public void parse_validValue_validSemester_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y1S1);
        DoneCommand doneCommand = new DoneCommand();
        assertParseSuccess(parser, "", new DoneCommand());
    }
}
