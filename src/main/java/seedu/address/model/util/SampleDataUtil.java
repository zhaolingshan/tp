package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.GradeBook;
import seedu.address.model.ReadOnlyGradeBook;
import seedu.address.model.module.Module;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code GradeBook} with sample data.
 */
public class SampleDataUtil {
    public static Module[] getSampleModule() {
        return new Module[] {

        };
    }

    public static ReadOnlyGradeBook getSampleGradeBook() {
        GradeBook sampleAb = new GradeBook();
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
