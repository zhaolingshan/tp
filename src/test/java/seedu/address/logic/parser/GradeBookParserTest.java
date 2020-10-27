package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.commands.CommandTestUtil.NO_GRADE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SEMESTER;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalModules.COM_ORG;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.StartCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleNameContainsKeywordsPredicate;
import seedu.address.model.semester.SemesterManager;
import seedu.address.testutil.EditModNameDescriptorBuilder;
import seedu.address.testutil.ModuleBuilder;
import seedu.address.testutil.ModuleUtil;

public class GradeBookParserTest {

    private final AddressBookParser parser = new AddressBookParser();

    @Test
    public void parseCommand_add() throws Exception {
        Module module = new ModuleBuilder().build();
        AddCommand command = (AddCommand) parser.parseCommand(ModuleUtil.getAddCommand(module));
        assertEquals(new AddCommand(module), command);
    }

    @Test
    public void parseCommand_clear() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        DeleteCommand command = (DeleteCommand) parser.parseCommand(
                DeleteCommand.COMMAND_WORD + " " + COM_ORG.getModuleName());
        assertEquals(new DeleteCommand(COM_ORG.getModuleName()), command);
    }

    @Test
    public void parseCommand_edit() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        Module module = new ModuleBuilder().build();
        EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder(module)
                .withName(COM_ORG.getModuleName().fullModName).withGrade(NO_GRADE).build();
        EditCommand command = (EditCommand) parser.parseCommand(EditCommand.COMMAND_WORD + " "
                + COM_ORG.getModuleName().fullModName + " " + ModuleUtil.getEditModuleDescriptorDetails(descriptor));
        assertEquals(new EditCommand(COM_ORG.getModuleName(), descriptor), command);
    }
    
    @Test
    public void parseCommand_start() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        StartCommand command = (StartCommand) parser.parseCommand(
                StartCommand.COMMAND_WORD + " " + VALID_SEMESTER);
        assertEquals(new StartCommand(VALID_SEMESTER), command);
    }
    
    @Test
    public void parseCommand_done() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertTrue(parser.parseCommand(DoneCommand.COMMAND_WORD) instanceof DoneCommand);
        assertTrue(parser.parseCommand(DoneCommand.COMMAND_WORD + "") instanceof DoneCommand);
    }

    @Test
    public void parseCommand_exit() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_find() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        List<String> keywords = Arrays.asList("foo", "bar", "baz");
        FindCommand command = (FindCommand) parser.parseCommand(
                FindCommand.COMMAND_WORD + " " + keywords.stream().collect(Collectors.joining(" ")));
        assertEquals(new FindCommand(new ModuleNameContainsKeywordsPredicate(keywords)), command);
    }

    @Test
    public void parseCommand_help() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_list() throws Exception {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD) instanceof ListCommand);
        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD + " 3") instanceof ListCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
            -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(VALID_SEMESTER);
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}
