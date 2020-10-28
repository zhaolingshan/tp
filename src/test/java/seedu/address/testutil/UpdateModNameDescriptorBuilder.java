package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.UpdateCommand;
import seedu.address.logic.commands.UpdateCommand.UpdateModNameDescriptor;
import seedu.address.model.module.Grade;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building UpdatePersonDescriptor objects.
 */
public class UpdateModNameDescriptorBuilder {

    private UpdateModNameDescriptor descriptor;

    public UpdateModNameDescriptorBuilder() {
        descriptor = new UpdateCommand.UpdateModNameDescriptor();
    }

    public UpdateModNameDescriptorBuilder(UpdateModNameDescriptor descriptor) {
        this.descriptor = new UpdateModNameDescriptor(descriptor);
    }

    /**
     * Returns an {@code UpdateModNameDescriptor} with fields containing {@code module}'s details
     */
    public UpdateModNameDescriptorBuilder(Module module) {
        descriptor = new UpdateModNameDescriptor();
        descriptor.setName(module.getModuleName());
        descriptor.setGrade(module.getGrade());
        descriptor.setTags(module.getTags());
    }

    /**
     * Sets the {@code module name} of the {@code UpdateModNameDescriptor} that we are building.
     */
    public UpdateModNameDescriptorBuilder withName(String name) {
        descriptor.setName(new ModuleName(name));
        return this;
    }

    /**
     * Sets the {@code Grade} of the {@code UpdateModNameDescriptor} that we are building.
     */
    public UpdateModNameDescriptorBuilder withGrade(String grade) {
        descriptor.setGrade(new Grade(grade));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code UpdateModNameDescriptor}
     * that we are building.
     */
    public UpdateModNameDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public UpdateModNameDescriptor build() {
        return descriptor;
    }
}
