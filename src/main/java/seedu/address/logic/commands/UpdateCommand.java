package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MOD_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MODULES;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.GetModuleIndex;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModularCredit;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.semester.Semester;
import seedu.address.model.tag.Tag;

/**
 * Updates the details of an existing module in the address book.
 */
public class UpdateCommand extends Command {

    public static final String COMMAND_WORD = "Update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the details of the module identified "
            + "by the module name displayed in the module list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters:"
            + PREFIX_MOD_NAME + "MODULE_NAME "
            + "[" + PREFIX_GRADE + "GRADE] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " --mod CS2103T --grade A";

    public static final String MESSAGE_UPDATE_MODULE_SUCCESS = "Updated Module: %1$s";
    public static final String MESSAGE_NOT_UPDATED = "At least one field to update must be provided.";
    public static final String MESSAGE_DUPLICATE_MODULE = "This module already exists in the address book.";

    private final ModuleName moduleName;
    private final UpdateModNameDescriptor updateModNameDescriptor;

    /**
     * @param moduleName of the module in the filtered module list to update
     * @param updateModNameDescriptor details to update the module with
     */
    public UpdateCommand(ModuleName moduleName, UpdateModNameDescriptor updateModNameDescriptor) {
        requireNonNull(moduleName);
        requireNonNull(updateModNameDescriptor);

        this.moduleName = moduleName;
        this.updateModNameDescriptor = new UpdateModNameDescriptor(updateModNameDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Module> lastShownList = model.getFilteredModuleList();

        Index index;
        try {
            index = GetModuleIndex.getIndex(model.getFilteredModuleList(), moduleName);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_NAME);
        }

        Module moduleToUpdate = lastShownList.get(index.getZeroBased());
        Module updatedModule = createUpdatedModule(moduleToUpdate, updateModNameDescriptor);

        if (!moduleToUpdate.isSameModule(updatedModule) && model.hasModule(updatedModule)) {
            throw new CommandException(MESSAGE_DUPLICATE_MODULE);
        }

        model.setModule(moduleToUpdate, updatedModule);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
        return new CommandResult(String.format(MESSAGE_UPDATE_MODULE_SUCCESS, updatedModule));
    }

    /**
     * Creates and returns a {@code Module} with the details of {@code moduleToUpdate}
     * updated with {@code updatedModuleDescriptor}.
     */
    private static Module createUpdatedModule(Module moduleToUpdate, UpdateModNameDescriptor updateModNameDescriptor) {
        assert moduleToUpdate != null;

        ModuleName updatedModuleName = updateModNameDescriptor.getName().orElse(moduleToUpdate.getModuleName());
        Grade updatedGrade = updateModNameDescriptor.getGrade().orElse(moduleToUpdate.getGrade());
        Set<Tag> updatedTags = updateModNameDescriptor.getTags().orElse(moduleToUpdate.getTags());
        // modularCredit is not edited
        ModularCredit modularCredit = moduleToUpdate.getModularCredit();
        Semester semester = moduleToUpdate.getSemester();
        return new Module(updatedModuleName, updatedGrade, updatedTags, modularCredit, semester);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UpdateCommand)) {
            return false;
        }

        // state check
        UpdateCommand e = (UpdateCommand) other;
        return moduleName.equals(e.moduleName)
                && updateModNameDescriptor.equals(e.updateModNameDescriptor);
    }

    /**
     * Stores the details to update the module with. Each non-empty field value will replace the
     * corresponding field value of the module.
     */
    public static class UpdateModNameDescriptor {
        private ModuleName moduleName;
        private Grade grade;
        private Set<Tag> tags;

        public UpdateModNameDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public UpdateModNameDescriptor(UpdateModNameDescriptor toCopy) {
            setName(toCopy.moduleName);
            setGrade(toCopy.grade);
            setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is updated.
         */
        public boolean isAnyFieldUpdated() {
            return CollectionUtil.isAnyNonNull(moduleName, grade, tags);
        }

        public void setName(ModuleName moduleName) {
            this.moduleName = moduleName;
        }

        public Optional<ModuleName> getName() {
            return Optional.ofNullable(moduleName);
        }

        public void setGrade(Grade grade) {
            this.grade = grade;
        }

        public Optional<Grade> getGrade() {
            return Optional.ofNullable(grade);
        }

        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setTags(Set<Tag> tags) {
            this.tags = (tags != null) ? new HashSet<>(tags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<Tag>> getTags() {
            return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof UpdateModNameDescriptor)) {
                return false;
            }

            // state check
            UpdateModNameDescriptor e = (UpdateModNameDescriptor) other;

            return getName().equals(e.getName())
                    && getGrade().equals(e.getGrade())
                    && getTags().equals(e.getTags());
        }
    }
}
