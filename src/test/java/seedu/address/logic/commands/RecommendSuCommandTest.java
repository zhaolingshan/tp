package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.GoalTarget;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RecommendSuCommand.
 */
public class RecommendSuCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(new AddressBook(), new UserPrefs(), new GoalTarget(4));
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), new GoalTarget(4));
    }

    @Test
    public void execute_recommendSu_showList() {
        assertCommandSuccess(new RecommendSuCommand(), model, RecommendSuCommand.MESSAGE_SUCCESS_NO_RECOMMENDATION,
                expectedModel);
    }
}
