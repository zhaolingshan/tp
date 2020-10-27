package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.VALID_MODULAR_CREDIT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalModules.COM_ORG;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.semester.Semester;
import seedu.address.testutil.ModuleBuilder;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();
    private final ModuleName moduleName = COM_ORG.getModuleName();
    private final String userInputModuleName = "CS2100";

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        System.out.println(new DeleteCommand(moduleName));
        assertParseSuccess(parser, userInputModuleName, new DeleteCommand(moduleName));
    }

    @Test
    public void parse_invalidSemester_failure() {
        Semester invalidSemester = Semester.NA;
        assertParseFailure(parser, invalidSemester.toString(), Messages.MESSAGE_INVALID_COMMAND_SEQUENCE);
    }

    @Test
    public void parse_validSemester_success() {
        Semester validSemester = Semester.Y4S1;
        Module expectedModule = new ModuleBuilder(COM_ORG).withTags(VALID_TAG_FRIEND)
                .withModularCredit(VALID_MODULAR_CREDIT).withSemester(validSemester.toString()).build();
        DeleteCommand deleteCommand = new DeleteCommand(expectedModule.getModuleName());
        assertParseSuccess(parser, userInputModuleName, deleteCommand);
    }
}
