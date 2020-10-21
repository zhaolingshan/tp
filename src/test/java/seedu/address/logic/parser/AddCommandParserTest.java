package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.GRADE_DESC_A;
import static seedu.address.logic.commands.CommandTestUtil.GRADE_DESC_B;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_GRADE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_MOD_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.MODULAR_CREDIT_DESC;
import static seedu.address.logic.commands.CommandTestUtil.MOD_NAME_DESC_A;
import static seedu.address.logic.commands.CommandTestUtil.MOD_NAME_DESC_B;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MODULAR_CREDIT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SEMESTER;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalModules.MOD_A;
import static seedu.address.testutil.TypicalModules.MOD_B;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.module.Grade;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.ModuleBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Module expectedModule = new ModuleBuilder(MOD_B).withTags(VALID_TAG_FRIEND)
                .withModularCredit(VALID_MODULAR_CREDIT).withSemester(VALID_SEMESTER.toString()).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + MOD_NAME_DESC_B
                + GRADE_DESC_B + TAG_DESC_FRIEND + MODULAR_CREDIT_DESC, new AddCommand(expectedModule));

        // multiple names - last name accepted
        assertParseSuccess(parser, MOD_NAME_DESC_A + MOD_NAME_DESC_B
                + GRADE_DESC_B + TAG_DESC_FRIEND + MODULAR_CREDIT_DESC, new AddCommand(expectedModule));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, MOD_NAME_DESC_B + GRADE_DESC_A
                + GRADE_DESC_B + TAG_DESC_FRIEND + MODULAR_CREDIT_DESC, new AddCommand(expectedModule));

        // multiple tags - all accepted
        Module expectedModuleMultipleTags = new ModuleBuilder(MOD_B).withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
                .build();
        assertParseSuccess(parser, MOD_NAME_DESC_B + GRADE_DESC_B
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND + MODULAR_CREDIT_DESC, new AddCommand(expectedModuleMultipleTags));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Module expectedModule = new ModuleBuilder(MOD_A).withTags()
                .withModularCredit(VALID_MODULAR_CREDIT).withSemester(VALID_SEMESTER.toString()).build();
        assertParseSuccess(parser, MOD_NAME_DESC_A + GRADE_DESC_A + MODULAR_CREDIT_DESC,
                new AddCommand(expectedModule));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_MOD_NAME_B + GRADE_DESC_B,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_MOD_NAME_DESC + GRADE_DESC_B
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, ModuleName.MESSAGE_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, MOD_NAME_DESC_B + INVALID_GRADE_DESC
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Grade.MESSAGE_CONSTRAINTS);

        // invalid tag
        assertParseFailure(parser, MOD_NAME_DESC_B + GRADE_DESC_B
                + INVALID_TAG_DESC + VALID_TAG_FRIEND, Tag.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_MOD_NAME_DESC + INVALID_GRADE_DESC,
                ModuleName.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + MOD_NAME_DESC_B
                + GRADE_DESC_B + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
