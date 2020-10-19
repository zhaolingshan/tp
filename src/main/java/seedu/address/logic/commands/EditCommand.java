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
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing module in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the module identified "
            + "by the module name displayed in the module list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters:"
            + "[" + PREFIX_MOD_NAME + "MODULE_NAME] "
            + "[" + PREFIX_GRADE + "GRADE] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " --mod CS2103T --grade A";

    public static final String MESSAGE_EDIT_MODULE_SUCCESS = "Edited Module: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_MODULE = "This module already exists in the address book.";

    private final ModuleName moduleName;
    private final EditModNameDescriptor editModNameDescriptor;

    /**
     * @param moduleName of the module in the filtered module list to edit
     * @param editModNameDescriptor details to edit the module with
     */
    public EditCommand(ModuleName moduleName, EditModNameDescriptor editModNameDescriptor) {
        requireNonNull(moduleName);
        requireNonNull(editModNameDescriptor);

        this.moduleName = moduleName;
        this.editModNameDescriptor = new EditModNameDescriptor(editModNameDescriptor);
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

        Module moduleToEdit = lastShownList.get(index.getZeroBased());
        Module editedModule = createEditedModule(moduleToEdit, editModNameDescriptor);

        if (!moduleToEdit.isSameModule(editedModule) && model.hasModule(editedModule)) {
            throw new CommandException(MESSAGE_DUPLICATE_MODULE);
        }

        model.setModule(moduleToEdit, editedModule);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
        return new CommandResult(String.format(MESSAGE_EDIT_MODULE_SUCCESS, editedModule));
    }

    /**
     * Creates and returns a {@code Module} with the details of {@code moduleToEdit}
     * edited with {@code editModuleDescriptor}.
     */
    private static Module createEditedModule(Module moduleToEdit, EditModNameDescriptor editModNameDescriptor) {
        assert moduleToEdit != null;

        ModuleName updatedModuleName = editModNameDescriptor.getName().orElse(moduleToEdit.getModuleName());
        Grade updatedGrade = editModNameDescriptor.getGrade().orElse(moduleToEdit.getGrade());
        Set<Tag> updatedTags = editModNameDescriptor.getTags().orElse(moduleToEdit.getTags());
        // modularCredit is not edited
        ModularCredit modularCredit = moduleToEdit.getModularCredit();
        return new Module(updatedModuleName, updatedGrade, updatedTags, modularCredit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return moduleName.equals(e.moduleName)
                && editModNameDescriptor.equals(e.editModNameDescriptor);
    }

    /**
     * Stores the details to edit the module with. Each non-empty field value will replace the
     * corresponding field value of the module.
     */
    public static class EditModNameDescriptor {
        private ModuleName moduleName;
        private Grade grade;
        private Set<Tag> tags;

        public EditModNameDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditModNameDescriptor(EditModNameDescriptor toCopy) {
            setName(toCopy.moduleName);
            setGrade(toCopy.grade);
            setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
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
            if (!(other instanceof EditModNameDescriptor)) {
                return false;
            }

            // state check
            EditModNameDescriptor e = (EditModNameDescriptor) other;

            return getName().equals(e.getName())
                    && getGrade().equals(e.getGrade())
                    && getTags().equals(e.getTags());
        }
    }
}
