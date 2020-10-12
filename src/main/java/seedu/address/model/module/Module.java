package seedu.address.model.module;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Module in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Module {

    // Identity fields
    private final ModuleName moduleName;

    // Data fields
    private Grade grade;
    private final Set<Tag> tags = new HashSet<>();
    private boolean hasGrade;

    /**
     * Every field must be present and not null.
     */
    public Module(ModuleName moduleName, Grade grade, Set<Tag> tags) {
        requireAllNonNull(moduleName, grade, tags);
        this.moduleName = moduleName;
        this.grade = grade;
        this.tags.addAll(tags);
        hasGrade = true;
    }

    /**
     * Grade field can be empty.
     */
    public Module(ModuleName moduleName, Set<Tag> tags) {
        this.moduleName = moduleName;
        this.tags.addAll(tags);
        hasGrade = false;
    }

    public ModuleName getModuleName() {
        return moduleName;
    }

    public Grade getGrade() {
        if (hasGrade) {
            return grade;
        } else {
            String emptyGrade = "NA";
            return new Grade(emptyGrade);
        }
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both module of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two modules.
     */
    public boolean isSameModule(Module otherModule) {
        if (otherModule == this) {
            return true;
        }

        return otherModule != null
                && otherModule.getModuleName().equals(getModuleName());
    }

    /**
     * Returns true if both modules have the same identity and data fields.
     * This defines a stronger notion of equality between two modules.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Module)) {
            return false;
        }

        Module otherModule = (Module) other;
        return otherModule.getModuleName().equals(getModuleName())
                && otherModule.getGrade().equals(getGrade())
                && otherModule.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(moduleName, grade, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getModuleName())
                .append(" Grade: ")
                .append(getGrade())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
