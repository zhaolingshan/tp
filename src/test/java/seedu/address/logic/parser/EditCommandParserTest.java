package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.GRADE_DESC_A;
import static seedu.address.logic.commands.CommandTestUtil.GRADE_DESC_B;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_GRADE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_MOD_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.MOD_NAME_DESC_A;
import static seedu.address.logic.commands.CommandTestUtil.NO_GRADE;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADE_A;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADE_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_A;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MOD_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_MODULE;
import static seedu.address.testutil.TypicalModules.COM_ORG;
import static seedu.address.testutil.TypicalModules.SWE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditModNameDescriptor;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.EditModNameDescriptorBuilder;

public class EditCommandParserTest {

    private static final String TAG_EMPTY = " " + PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
//        // no index specified
//        assertParseFailure(parser, VALID_MOD_NAME_A, MESSAGE_INVALID_FORMAT);
//
//        // no field specified
//        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);

        // no module and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

// Not using index to edit mods -XY
//    @Test
//    public void parse_invalidPreamble_failure() {
//        // negative index
//        assertParseFailure(parser, "-5" + MOD_NAME_DESC_A, MESSAGE_INVALID_FORMAT);
//
//        // zero index
//        assertParseFailure(parser, "0" + MOD_NAME_DESC_A, MESSAGE_INVALID_FORMAT);
//
//        // invalid arguments being parsed as preamble
//        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);
//
//        // invalid prefix being parsed as preamble
//        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
//    }

    @Test
    public void parse_invalidValue_failure() {
        String moduleName = COM_ORG.getModuleName().fullModName;
        assertParseFailure(parser, INVALID_MOD_NAME_DESC, ModuleName.MESSAGE_CONSTRAINTS); // invalid module name
        assertParseFailure(parser,  " " + PREFIX_MOD_NAME + moduleName + INVALID_GRADE_DESC, Grade.MESSAGE_CONSTRAINTS); // invalid grade
        assertParseFailure(parser, " " + PREFIX_MOD_NAME + moduleName + INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS); // invalid tag

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Person} being edited,
        // parsing it together with a valid tag results in error
        assertParseFailure(parser, " " + PREFIX_MOD_NAME + moduleName + TAG_DESC_FRIEND + TAG_DESC_HUSBAND + TAG_EMPTY, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, " " + PREFIX_MOD_NAME + moduleName + TAG_DESC_FRIEND + TAG_EMPTY + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, " " + PREFIX_MOD_NAME + moduleName + TAG_EMPTY + TAG_DESC_FRIEND + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, INVALID_MOD_NAME_DESC + INVALID_GRADE_DESC, ModuleName.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        ModuleName NAME_THIRD_MODULE = SWE.getModuleName();
        String userInput = PREFIX_MOD_NAME + NAME_THIRD_MODULE.fullModName + TAG_DESC_HUSBAND
                + GRADE_DESC_A + MOD_NAME_DESC_A + TAG_DESC_FRIEND;

        EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_A)
                .withGrade(VALID_GRADE_A)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
        EditCommand expectedCommand = new EditCommand(NAME_THIRD_MODULE, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    //commented away since this is testing on email entry
    //@Test
    //public void parse_someFieldsSpecified_success() {
    //Index targetIndex = INDEX_FIRST_PERSON;
    //String userInput = targetIndex.getOneBased() + EMAIL_DESC_AMY;
    //
    //EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder()
    //.build();
    //EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
    //
    //assertParseSuccess(parser, userInput, expectedCommand);
    //}

    @Test
    public void parse_oneFieldSpecified_success() {
        // name
        ModuleName NAME_THIRD_MODULE = SWE.getModuleName();
        String userInput = MOD_NAME_DESC_A;
        EditCommand.EditModNameDescriptor descriptor =
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_A).withGrade(NO_GRADE).build();
        EditCommand expectedCommand = new EditCommand(NAME_THIRD_MODULE, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // grade
        userInput = MOD_NAME_DESC_A + GRADE_DESC_A;
        descriptor = new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_A).withGrade(VALID_GRADE_A).build();
        expectedCommand = new EditCommand(NAME_THIRD_MODULE, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // tags
        userInput = MOD_NAME_DESC_A + TAG_DESC_FRIEND;
        descriptor = new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_A)
                .withGrade(NO_GRADE).withTags(VALID_TAG_FRIEND).build();
        expectedCommand = new EditCommand(NAME_THIRD_MODULE, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_acceptsLast() {
        ModuleName NAME_FIRST_MODULE = COM_ORG.getModuleName();
        String userInput = " " + PREFIX_MOD_NAME + NAME_FIRST_MODULE.fullModName + GRADE_DESC_A
                + TAG_DESC_FRIEND + GRADE_DESC_A + TAG_DESC_FRIEND
                + GRADE_DESC_B + TAG_DESC_HUSBAND;

        EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder()
                .withName(NAME_FIRST_MODULE.fullModName)
                .withGrade(VALID_GRADE_B).withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
                .build();
        EditCommand expectedCommand = new EditCommand(NAME_FIRST_MODULE, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidValueFollowedByValidValue_success() {
        //Original first assert has only phone in userInput, now deleted - kunnan 5/10/2020
        // no other valid values specified
        ModuleName NAME_FIRST_MODULE = COM_ORG.getModuleName();
        Index targetIndex = INDEX_FIRST_MODULE;
        String userInput;
        EditCommand.EditModNameDescriptor descriptor;
        EditCommand expectedCommand;
        //assertParseSuccess(parser, userInput, expectedCommand);

        // other valid values specified
        userInput = " " + PREFIX_MOD_NAME + NAME_FIRST_MODULE.fullModName + GRADE_DESC_B;
        descriptor = new EditModNameDescriptorBuilder()
                .withName(NAME_FIRST_MODULE.fullModName).withGrade(VALID_GRADE_B).build();
        expectedCommand = new EditCommand(NAME_FIRST_MODULE, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_resetTags_success() {
        ModuleName NAME_THIRD_MODULE = SWE.getModuleName();
        String userInput = " " + PREFIX_MOD_NAME + NAME_THIRD_MODULE.fullModName + TAG_EMPTY;

        EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder()
                .withName(VALID_MOD_NAME_A).withGrade(NO_GRADE).withTags().build();
        EditCommand expectedCommand = new EditCommand(NAME_THIRD_MODULE, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
