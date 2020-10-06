package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ModuleNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ModuleName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new ModuleName(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> ModuleName.isValidModName(null));

        // invalid name
        assertFalse(ModuleName.isValidModName("")); // empty string
        assertFalse(ModuleName.isValidModName(" ")); // spaces only
        assertFalse(ModuleName.isValidModName("^")); // only non-alphanumeric characters
        assertFalse(ModuleName.isValidModName("peter*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(ModuleName.isValidModName("peter jack")); // alphabets only
        assertTrue(ModuleName.isValidModName("12345")); // numbers only
        assertTrue(ModuleName.isValidModName("peter the 2nd")); // alphanumeric characters
        assertTrue(ModuleName.isValidModName("Capital Tan")); // with capital letters
        assertTrue(ModuleName.isValidModName("David Roger Jackson Ray Jr 2nd")); // long names
    }
}
