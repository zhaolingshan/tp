package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_A;
import static seedu.address.logic.commands.CommandTestUtil.DESC_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditCommand.EditModNameDescriptor;
import seedu.address.testutil.EditModNameDescriptorBuilder;

public class EditModNameDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditModNameDescriptor descriptorWithSameValues = new EditCommand.EditModNameDescriptor(DESC_A);
        assertTrue(DESC_A.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_A.equals(DESC_A));

        // null -> returns false
        assertFalse(DESC_A.equals(null));

        // different types -> returns false
        assertFalse(DESC_A.equals(5));

        // different values -> returns false
        assertFalse(DESC_A.equals(DESC_B));

        // different name -> returns false
        EditCommand.EditModNameDescriptor editedAmy = new EditModNameDescriptorBuilder(DESC_A).withName(VALID_MOD_NAME_B).build();
        assertFalse(DESC_A.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditModNameDescriptorBuilder(DESC_A).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_A.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditModNameDescriptorBuilder(DESC_A).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_A.equals(editedAmy));
    }
}
