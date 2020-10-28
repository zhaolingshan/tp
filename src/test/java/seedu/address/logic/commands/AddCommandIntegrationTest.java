package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalModules.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;
import seedu.address.model.module.Module;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;
import seedu.address.testutil.ModuleBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget());
    }

    @Test
    public void execute_newModule_success() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y4S2);

        Module validModule = new ModuleBuilder().withName("IS1103").build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), new GoalTarget());
        expectedModel.addModule(validModule);

        assertCommandSuccess(new AddCommand(validModule), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validModule), expectedModel);
    }

    @Test
    public void execute_duplicateModule_throwsCommandException() {
        SemesterManager semesterManager = SemesterManager.getInstance();
        semesterManager.setCurrentSemester(Semester.Y4S1);

        Module moduleInList = model.getAddressBook().getModuleList().get(0);
        assertCommandFailure(new AddCommand(moduleInList), model, AddCommand.MESSAGE_DUPLICATE_MODULE);
    }

}
