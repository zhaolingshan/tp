package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.INVALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalModules.COM_ORG;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SuCommand;
import seedu.address.logic.commands.UpdateCommand;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModuleName;

public class SuCommandParserTest {

    private Parser parser = new SuCommandParser();

    @Test
    public void parse_validArgs_returnsSuCommand() {

        ModuleName moduleName = COM_ORG.getModuleName();

        UpdateCommand.UpdateModNameDescriptor updateModNameDescriptor = new UpdateCommand.UpdateModNameDescriptor();
        updateModNameDescriptor.setName(moduleName);
        updateModNameDescriptor.setGrade(new Grade("SU"));

        assertParseSuccess(parser, VALID_MOD_NAME_B, new SuCommand(moduleName, updateModNameDescriptor));
    }

    @Test
    public void parse_invalidArgs_failure() {

        assertParseFailure(parser, INVALID_MOD_NAME_B, ModuleName.MESSAGE_CONSTRAINTS);
    }

}
