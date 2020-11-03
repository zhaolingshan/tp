package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_MOD_NAME;

import seedu.address.model.module.ModuleName;
import seedu.address.model.util.ModuleInfoRetriever;


/**
 * SUs the module indicated
 */
public class SuCommand extends UpdateCommand {
    public static final String COMMAND_WORD = "su";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": SUs the module identified "
            + "by the module name displayed in the module list.\n"
            + "Parameters: "
            + PREFIX_MOD_NAME + "MODULE_NAME \n"
            + "Example: " + COMMAND_WORD 
            + PREFIX_MOD_NAME + "CS2103T";

    /**
     * @param moduleName              of the module in the filtered module list to update
     * @param updateModNameDescriptor details to update the module with
     */
    public SuCommand(ModuleName moduleName, UpdateModNameDescriptor updateModNameDescriptor) {
        super(moduleName, updateModNameDescriptor);
    }

    /**
     * Returns true if module can be S/U from data.
     *
     * @param moduleName Module to be checked.
     * @return True if module can be S/U, false otherwise.
     */
    public static boolean isModSuAble(ModuleName moduleName) {
        String status = ModuleInfoRetriever.retrieve(moduleName.fullModName).get("su");
        return status.contains("true");
    }

}
