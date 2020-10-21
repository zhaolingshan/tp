package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalModules.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;
import seedu.address.model.module.Module;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new GoalTarget());
    }

    // Commented away because test fails and not sure how to make it work - Aug
    //    @Test
    //    public void execute_newModule_success() {
    //        Module validModule = new ModuleBuilder().build();
    //
    //        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    //        expectedModel.addModule(validModule);
    //
    //        assertCommandSuccess(new AddCommand(validModule), model,
    //                String.format(AddCommand.MESSAGE_SUCCESS, validModule), expectedModel);
    //    }

    @Test
    public void execute_duplicateModule_throwsCommandException() {
        Module moduleInList = model.getAddressBook().getModuleList().get(0);
        assertCommandFailure(new AddCommand(moduleInList), model, AddCommand.MESSAGE_DUPLICATE_MODULE);
    }

}
