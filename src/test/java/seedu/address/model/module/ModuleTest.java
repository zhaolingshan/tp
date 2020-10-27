package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_A;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalModules.COM_ORG;
import static seedu.address.testutil.TypicalModules.MOD_B;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ModuleBuilder;

public class ModuleTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Module module = new ModuleBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> module.getTags().remove(0));
    }

    @Test
    public void isSameModule() {
        // same object -> returns true
        assertTrue(COM_ORG.isSameModule(COM_ORG));

        // null -> returns false
        assertFalse(COM_ORG.isSameModule(null));

        Module editedModule;
        // different module name -> returns false
        editedModule = new ModuleBuilder(COM_ORG).withName(VALID_MOD_NAME_A).build();
        assertFalse(COM_ORG.isSameModule(editedModule));

        // same module name, different attributes (Grade) -> returns true
        editedModule = new ModuleBuilder(COM_ORG).withGrade("A+")
               .build();
        assertTrue(COM_ORG.isSameModule(editedModule));

        // same module name, same grade, different attributes (number of MCs) -> returns true
        editedModule = new ModuleBuilder(COM_ORG).withGrade("A-").withModularCredit(2).build();
        assertTrue(COM_ORG.isSameModule(editedModule));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Module moduleCopy = new ModuleBuilder(COM_ORG).build();
        assertTrue(COM_ORG.equals(moduleCopy));

        // same object -> returns true
        assertTrue(COM_ORG.equals(COM_ORG));

        // null -> returns false
        assertFalse(COM_ORG.equals(null));

        // different type -> returns false
        assertFalse(COM_ORG.equals(5));

        // different module -> returns false
        assertFalse(COM_ORG.equals(MOD_B));

        // different module name -> returns false
        Module editedModule = new ModuleBuilder(COM_ORG).withName(VALID_MOD_NAME_A).build();
        assertFalse(COM_ORG.equals(editedModule));

        // different grade -> returns false
        editedModule = new ModuleBuilder(COM_ORG).withGrade("A+").build();
        assertFalse(COM_ORG.equals(editedModule));

        // different MCs -> returns false
        editedModule = new ModuleBuilder(COM_ORG).withModularCredit(2).build();
        assertFalse(COM_ORG.equals(editedModule));
    }
}
