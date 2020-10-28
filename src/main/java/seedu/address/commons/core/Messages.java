package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_MODULE_DISPLAYED_INDEX = "The module index provided is invalid";
    public static final String MESSAGE_INVALID_MODULE_DISPLAYED_NAME = "The module name provided is invalid";
    public static final String MESSAGE_MODULES_LISTED_OVERVIEW = "%1$d modules listed!";
    public static final String MESSAGE_INVALID_COMMAND_SEQUENCE = "Start a semester before modifying the module list.";
    public static final String MESSAGE_INVALID_DONE_COMMAND = "There is no semester being modified.";
    public static final String MESSAGE_INVALID_SEMESTER = "The semester you have entered is invalid.\n"
            + "Only Y1S1, Y1S2, Y2S1, Y2S2, Y3S1, Y3S2, Y4S1, Y4S2, Y5S1, and Y5S2 are accepted.";
}
