package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModularCredit;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Module[] getSampleModule() {
        return new Module[] {
            new Module(new ModuleName("CS2100 Computer Organisation"),
                new Grade("A"),
                getTagSet("CS2100"), new ModularCredit(4)),
            new Module(new ModuleName("CS2103T Software Engineering"),
                new Grade("A+"),
                getTagSet("CS2103T"), new ModularCredit(4)),
            new Module(new ModuleName("GEQ1000 Asking Questions"),
                new Grade("B"),
                getTagSet("GEQ1000"), new ModularCredit(4)),
            new Module(new ModuleName("ST2334 Probability and Statistics"),
                new Grade("B+"),
                getTagSet("ST2334"), new ModularCredit(4)),
            new Module(new ModuleName("GER1000 Quantitative Reasoning"),
                new Grade("A"),
                getTagSet("GER1000"), new ModularCredit(4)),
            new Module(new ModuleName("MA1521 Calculus for Computing"),
                new Grade("A-"),
                getTagSet("MA1521"), new ModularCredit(4))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Module sampleModule : getSampleModule()) {
            sampleAb.addModule(sampleModule);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
