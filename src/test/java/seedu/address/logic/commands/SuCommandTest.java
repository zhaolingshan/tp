package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.GetModuleIndex;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UpdateCommand.UpdateModNameDescriptor;
import seedu.address.model.GradeBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;
import seedu.address.testutil.ModuleBuilder;
import seedu.address.testutil.UpdateModNameDescriptorBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.TypicalModules.*;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * UpdateCommand.
 */
public class SuCommandTest {

    private Model model = new ModelManager(getTypicalGradeBook(), new UserPrefs(), new GoalTarget());

    private final ModuleName nameFirstModule = COM_ORG.getModuleName();
    private final ModuleName nameSecondModule = EFF_COM.getModuleName();

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        setValidCorrectSemester();

        Module updatedModule = new ModuleBuilder().withName(nameSecondModule.fullModName)
                .withGrade(VALID_GRADE_SU).build();
        UpdateModNameDescriptor descriptor = new UpdateModNameDescriptorBuilder(updatedModule).build();
        SuCommand suCommand = new SuCommand(nameSecondModule, descriptor);

        String expectedMessage = String.format(UpdateCommand.MESSAGE_UPDATE_MODULE_SUCCESS, updatedModule);

        Model expectedModel = new ModelManager(new GradeBook(model.getGradeBook()), new UserPrefs(),
                new GoalTarget());
        expectedModel.setModule(model.getFilteredModuleList().get(1), updatedModule);

        assertCommandSuccess(suCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidModuleNameUnfilteredList_failure() {
        setValidCorrectSemester();
        ModuleName invalidModuleName = new ModuleName("No such module");
        UpdateModNameDescriptor descriptor =
                new UpdateModNameDescriptorBuilder().withGrade(VALID_GRADE_SU).build();
        UpdateCommand updateCommand = new UpdateCommand(invalidModuleName, descriptor);

        assertCommandFailure(updateCommand, model, Messages.MESSAGE_INVALID_MODULE_DISPLAYED_NAME);
    }


    @Test
    public void equals() {
        final SuCommand standardCommand = new SuCommand(nameFirstModule, DESC_SU);

        // same values -> returns true
        UpdateModNameDescriptor copyDescriptor = new UpdateModNameDescriptor(DESC_SU);
        SuCommand commandWithSameValues = new SuCommand(nameFirstModule, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new UpdateCommand(nameSecondModule, DESC_SU)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new UpdateCommand(nameFirstModule, DESC_B)));
    }

    @Test
    public void execute_invalidSemester_throwsCommandException() {
        setInvalidSemester();

        Module updatedModule = new ModuleBuilder().withName(nameFirstModule.fullModName)
                .withGrade(VALID_GRADE_A).build();
        UpdateModNameDescriptor descriptor = new UpdateModNameDescriptorBuilder(updatedModule).build();
        SuCommand updateCommand = new SuCommand(nameFirstModule, descriptor);

        assertCommandFailure(updateCommand, model, Messages.MESSAGE_INVALID_COMMAND_SEQUENCE);
    }

    @Test
    public void execute_wrongSemester_throwsCommandException() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        setValidWrongSemester();

        Module updatedModule = new ModuleBuilder().withName(nameFirstModule.fullModName)
                .withGrade(VALID_GRADE_SU).build();
        UpdateModNameDescriptor descriptor = new UpdateModNameDescriptorBuilder(updatedModule).build();
        SuCommand updateCommand = new SuCommand(nameFirstModule, descriptor);

        Semester semesterOfFirstModule = COM_ORG.getSemester();

        String expectedMessage = Messages.MESSAGE_UPDATE_MODULE_IN_WRONG_SEMESTER + semesterOfFirstModule + ".\n"
                + Messages.MESSAGE_CURRENT_SEMESTER + semesterManager.getCurrentSemester() + ".\n"
                + Messages.MESSAGE_DIRECT_TO_CORRECT_SEMESTER + semesterOfFirstModule
                + Messages.MESSAGE_DIRECT_TO_CORRECT_SEMESTER_TO_UPDATE;

        assertCommandFailure(updateCommand, model, expectedMessage);
    }
}
