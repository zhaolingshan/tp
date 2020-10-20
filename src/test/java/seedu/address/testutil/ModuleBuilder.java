package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.module.Grade;
import seedu.address.model.module.ModularCredit;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.semester.Semester;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Module objects.
 */
public class ModuleBuilder {

    public static final String DEFAULT_NAME = "CS2103T Software Engineering";
    public static final String DEFAULT_GRADE = "A+";
    public static final int DEFAULT_MODULAR_CREDIT = 4;
    public static final Semester DEFAULT_SEMESTER = Semester.Y1S1;

    private ModuleName moduleName;
    private Grade grade;
    private Set<Tag> tags;
    private ModularCredit modularCredit;
    private Semester semester;

    /**
     * Creates a {@code ModuleBuilder} with the default details.
     */
    public ModuleBuilder() {
        moduleName = new ModuleName(DEFAULT_NAME);
        grade = new Grade(DEFAULT_GRADE);
        tags = new HashSet<>();
        modularCredit = new ModularCredit(DEFAULT_MODULAR_CREDIT);
        semester = DEFAULT_SEMESTER;
    }

    /**
     * Initializes the ModuleBuilder with the data of {@code moduleToCopy}.
     */
    public ModuleBuilder(Module moduleToCopy) {
        moduleName = moduleToCopy.getModuleName();
        grade = moduleToCopy.getGrade();
        tags = new HashSet<>(moduleToCopy.getTags());
        modularCredit = moduleToCopy.getModularCredit();
        semester = moduleToCopy.getSemester();
    }

    /**
     * Sets the {@code Name} of the {@code Module} that we are building.
     */
    public ModuleBuilder withName(String name) {
        this.moduleName = new ModuleName(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Module} that we are building.
     */
    public ModuleBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Grade} of the {@code Module} that we are building.
     */
    public ModuleBuilder withGrade(String grade) {
        this.grade = new Grade(grade);
        return this;
    }

    /**
     * Sets the {@code ModularCredit} of the {@code Module} that we are building.
     */
    public ModuleBuilder withModularCredit(int modularCredit) {
        this.modularCredit = new ModularCredit(modularCredit);
        return this;
    }

    /**
     * Sets the {@code Semester} of the {@code Module} that we are building.
     */
    // not sure if parameter is a string or semester
    public ModuleBuilder withSemester(String semester) {
        this.semester = Semester.valueOf(semester);
        return this;
    }

    public Module build() {
        return new Module(moduleName, grade, tags, modularCredit, semester);
    }

}
