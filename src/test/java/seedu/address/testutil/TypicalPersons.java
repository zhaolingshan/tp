package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_A;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.module.Module;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Module ALICE = new ModuleBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111")
            .withTags("friends").build();
    public static final Module BENSON = new ModuleBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withTags("owesMoney", "friends").build();
    public static final Module CARL = new ModuleBuilder().withName("Carl Kurz")
            .withAddress("wall street").build();
    public static final Module DANIEL = new ModuleBuilder().withName("Daniel Meier")
            .withAddress("10th street").withTags("friends").build();
    public static final Module ELLE = new ModuleBuilder().withName("Elle Meyer")
            .withAddress("michegan ave").build();
    public static final Module FIONA = new ModuleBuilder().withName("Fiona Kunz")
            .withAddress("little tokyo").build();
    public static final Module GEORGE = new ModuleBuilder().withName("George Best")
            .withAddress("4th street").build();

    // Manually added
    public static final Module HOON = new ModuleBuilder().withName("Hoon Meier")
            .withAddress("little india").build();
    public static final Module IDA = new ModuleBuilder().withName("Ida Mueller")
            .withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Module AMY = new ModuleBuilder().withName(VALID_MOD_NAME_A)
            .withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Module BOB = new ModuleBuilder().withName(VALID_MOD_NAME_B)
            .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Module module : getTypicalPersons()) {
            ab.addModule(module);
        }
        return ab;
    }

    public static List<Module> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
