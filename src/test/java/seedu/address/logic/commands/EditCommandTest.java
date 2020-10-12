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
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.testutil.EditModNameDescriptorBuilder;
import seedu.address.testutil.ModuleBuilder;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for EditCommand.
 */
public class EditCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    
    private final ModuleName NAME_FIRST_MODULE = COM_ORG.getModuleName();
    private final ModuleName NAME_SECOND_MODULE = EFF_COM.getModuleName();
    
    private final Index INDEX_FIRST_MODULE = 
            GetModuleIndex.getIndex(model.getFilteredModuleList(), NAME_FIRST_MODULE);

    private final Index INDEX_SECOND_MODULE =
            GetModuleIndex.getIndex(model.getFilteredModuleList(), NAME_SECOND_MODULE);
    
        @Test
        public void execute_allFieldsSpecifiedUnfilteredList_success() {
            Module editedModule = new ModuleBuilder().withName(NAME_FIRST_MODULE.fullModName).withGrade(VALID_GRADE_A).build();
            EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder(editedModule).build();
            EditCommand editCommand = new EditCommand(NAME_FIRST_MODULE, descriptor);

            String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

            Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
            expectedModel.setModule(model.getFilteredModuleList().get(0), editedModule);

            assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
        }
        
        @Test
        public void execute_someFieldsSpecifiedUnfilteredList_success() {
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

            Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
            expectedModel.setModule(firstModule, editedModule);

            assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
        }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        EditCommand editCommand = new EditCommand(NAME_FIRST_MODULE, new EditModNameDescriptor());
        Module editedModule = model.getFilteredModuleList().get(INDEX_FIRST_MODULE.getZeroBased());

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {
        showModuleAtIndex(model, INDEX_FIRST_MODULE);

        Module moduleInFilteredList = model.getFilteredModuleList().get(INDEX_FIRST_MODULE.getZeroBased());
        Module editedModule = new ModuleBuilder(moduleInFilteredList).withName(VALID_MOD_NAME_B).build();
        EditCommand editCommand = new EditCommand(NAME_FIRST_MODULE, 
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_B).build());

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_MODULE_SUCCESS, editedModule);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setModule(model.getFilteredModuleList().get(0), editedModule);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

// Shouldn't have duplicate mods because module name is not changed -XY
//    
//    @Test
//    public void execute_duplicateModuleUnfilteredList_failure() {
//        Module firstModule = model.getFilteredModuleList().get(INDEX_FIRST_MODULE.getZeroBased());
//        EditCommand.EditModNameDescriptor descriptor = new EditModNameDescriptorBuilder(firstModule).build();
//        EditCommand editCommand = new EditCommand(INDEX_SECOND_MODULE, descriptor);
//
//        assertCommandFailure(editCommand, model, EditCommand.MESSAGE_DUPLICATE_MODULE);
//    }
//
//    @Test
//    public void execute_duplicateModuleFilteredList_failure() {
//        showModuleAtIndex(model, INDEX_FIRST_MODULE);
//
//        // edit person in filtered list into a duplicate in address book
//        Module moduleInList = model.getAddressBook().getModuleList().get(INDEX_SECOND_MODULE.getZeroBased());
//        EditCommand editCommand = new EditCommand(INDEX_FIRST_MODULE,
//                new EditModNameDescriptorBuilder(moduleInList).build());
//
//        assertCommandFailure(editCommand, model, EditCommand.MESSAGE_DUPLICATE_MODULE);
//    }

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
        showModuleAtIndex(model, INDEX_FIRST_MODULE);
        Index outOfBoundIndex = INDEX_SECOND_MODULE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(model.getAddressBook().getModuleList().get(INDEX_SECOND_MODULE.getZeroBased()).getModuleName()
                .equals(NAME_SECOND_MODULE));

        EditCommand editCommand = new EditCommand(NAME_SECOND_MODULE, 
                new EditModNameDescriptorBuilder().withName(VALID_MOD_NAME_B).build());

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_MODULE_DISPLAYED_NAME);
    }

    @Test
    public void equals() {
        final EditCommand standardCommand = new EditCommand(NAME_FIRST_MODULE, DESC_A);

        // same values -> returns true
        EditCommand.EditModNameDescriptor copyDescriptor = new EditCommand.EditModNameDescriptor(DESC_A);
        EditCommand commandWithSameValues = new EditCommand(NAME_FIRST_MODULE, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditCommand(NAME_SECOND_MODULE, DESC_A)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditCommand(NAME_FIRST_MODULE, DESC_B)));
    }

}
