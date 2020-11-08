package seedu.address.model;

import org.junit.jupiter.api.Test;
import seedu.address.model.module.GoalTarget;
import seedu.address.model.util.ModuleInfoRetriever;
import seedu.address.model.util.ModuleListFilter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.setInvalidSemester;
import static seedu.address.logic.commands.CommandTestUtil.setValidCorrectSemester;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalModules.getTypicalGradeBook;

public class ModuleListFilterTest {

    private Model model = new ModelManager(getTypicalGradeBook(), new UserPrefs(), new GoalTarget());

    @Test
    public void filterValidSemesterSuccessfulModules() {
        setValidCorrectSemester();
        assertEquals(model.filterModuleListBySem().size(), 2);
    }

    @Test
    public void filterInvalidSemesterSuccessfulModules() {
        setInvalidSemester();
        assertEquals(model.filterModuleListBySem().size(), 7);
    }
}
