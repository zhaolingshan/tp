package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditModNameDescriptor;
import seedu.address.model.module.Grade;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditModNameDescriptorBuilder {

    private EditCommand.EditModNameDescriptor descriptor;

    public EditModNameDescriptorBuilder() {
        descriptor = new EditCommand.EditModNameDescriptor();
    }

    public EditModNameDescriptorBuilder(EditCommand.EditModNameDescriptor descriptor) {
        this.descriptor = new EditModNameDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditModNameDescriptor} with fields containing {@code module}'s details
     */
    public EditModNameDescriptorBuilder(Module module) {
        descriptor = new EditCommand.EditModNameDescriptor();
        descriptor.setName(module.getModuleName());
        descriptor.setGrade(module.getGrade());
        descriptor.setTags(module.getTags());
    }

    /**
     * Sets the {@code module name} of the {@code EditModNameDescriptor} that we are building.
     */
    public EditModNameDescriptorBuilder withName(String name) {
        descriptor.setName(new ModuleName(name));
        return this;
    }

    /**
     * Sets the {@code Grade} of the {@code EditModNameDescriptor} that we are building.
     */
    public EditModNameDescriptorBuilder withGrade(String grade) {
        descriptor.setGrade(new Grade(grade));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditModNameDescriptor}
     * that we are building.
     */
    public EditModNameDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditCommand.EditModNameDescriptor build() {
        return descriptor;
    }
}
