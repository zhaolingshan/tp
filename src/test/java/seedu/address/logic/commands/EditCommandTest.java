package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_A;
import static seedu.address.logic.commands.CommandTestUtil.DESC_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADE_A;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showModuleAtIndex;
import static seedu.address.testutil.TypicalModules.COM_ORG;
import static seedu.address.testutil.TypicalModules.EFF_COM;
import static seedu.address.testutil.TypicalModules.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.GetModuleIndex;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand.EditModNameDescriptor;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;
import seedu.address.testutil.EditModNameDescriptorBuilder;
import seedu.address.testutil.ModuleBuilder;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for EditCommand.
 */
public class EditCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget());

    private final ModuleName nameFirstModule = COM_ORG.getModuleName();
    private final ModuleName nameSecondModule = EFF_COM.getModuleName();

    private final Index indexFirstModule =
            GetModuleIndex.getIndex(model.getFilteredModuleList(), nameFirstModule);

    private final Index indexSecondModule =
            GetModuleIndex.getIndex(model.getFilteredModuleList(), nameSecondModule);

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y4S1);
        
        Module editedModule = new ModuleBuilder().withName(nameFirstModule.fullModName)
                .withGrade(VALID_GRADE_A).build();
        EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder(editedModule).build();
        EditCommand editCommand = new EditCommand(nameFirstModule, descriptor);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs(),
                new GoalTarget());
        expectedModel.setModule(model.getFilteredModuleList().get(0), editedModule);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_someFieldsSpecifiedUnfilteredList_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y3S2);
        
        ModuleName firstModuleName = COM_ORG.getModuleName();
        Index indexLastModule = GetModuleIndex.getIndex(model.getFilteredModuleList(), firstModuleName);
        Module firstModule = model.getFilteredModuleList().get(indexLastModule.getZeroBased());

        ModuleBuilder moduleInList = new ModuleBuilder(firstModule);
        Module editedModule = moduleInList.withName(VALID_MOD_NAME_B).withGrade(VALID_GRADE_A)
                .withTags(VALID_TAG_HUSBAND).build();

        EditCommand.EditModNameDescriptor descriptor =
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_B).withGrade(VALID_GRADE_A)
                        .withTags(VALID_TAG_HUSBAND).build();
        EditCommand editCommand = new EditCommand(firstModuleName, descriptor);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs(),
                new GoalTarget());
        expectedModel.setModule(firstModule, editedModule);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y3S1);
        
        EditCommand editCommand = new EditCommand(nameFirstModule, new EditModNameDescriptor());
        Module editedModule = model.getFilteredModuleList().get(indexFirstModule.getZeroBased());

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs(),
                new GoalTarget());

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y5S2);
        
        showModuleAtIndex(model, indexFirstModule);

        Module moduleInFilteredList = model.getFilteredModuleList().get(indexFirstModule.getZeroBased());
        Module editedModule = new ModuleBuilder(moduleInFilteredList).withName(VALID_MOD_NAME_B).build();
        EditCommand editCommand = new EditCommand(nameFirstModule,
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_B).build());

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs(),
                new GoalTarget());
        expectedModel.setModule(model.getFilteredModuleList().get(0), editedModule);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidModuleNameUnfilteredList_failure() {
        ModuleName invalidModuleName = new ModuleName("No such module");
        EditCommand.EditModNameDescriptor descriptor =
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_B).build();
        EditCommand editCommand = new EditCommand(invalidModuleName, descriptor);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_MODULE_DISPLAYED_NAME);
    }

    /**
     * Edit filtered list where module name is not in filtered list,
     * but still in address book
     */
    @Test
    public void execute_invalidModuleNameFilteredList_failure() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y5S1);
        
        showModuleAtIndex(model, indexFirstModule);
        Index outOfBoundIndex = indexSecondModule;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(model.getAddressBook().getModuleList().get(indexSecondModule.getZeroBased()).getModuleName()
                .equals(nameSecondModule));

        EditCommand editCommand = new EditCommand(nameSecondModule,
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_B).build());

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_MODULE_DISPLAYED_NAME);
    }

    @Test
    public void equals() {
        final EditCommand standardCommand = new EditCommand(nameFirstModule, DESC_A);

        // same values -> returns true
        EditCommand.EditModNameDescriptor copyDescriptor = new EditCommand.EditModNameDescriptor(DESC_A);
        EditCommand commandWithSameValues = new EditCommand(nameFirstModule, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditCommand(nameSecondModule, DESC_A)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditCommand(nameFirstModule, DESC_B)));
    }

    @Test
    public void execute_invalidSemester_throwsCommandException() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.NA);

        Module editedModule = new ModuleBuilder().withName(nameFirstModule.fullModName)
                .withGrade(VALID_GRADE_A).build();
        EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder(editedModule).build();
        EditCommand editCommand = new EditCommand(nameFirstModule, descriptor);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_COMMAND_SEQUENCE);
    }
}
