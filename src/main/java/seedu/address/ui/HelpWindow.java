package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2021s1-cs2103t-t17-1.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "OR, refer to the user guide: " + USERGUIDE_URL;

    private static final String startCommandFormat = "start SEMESTER\n\n";
    private static final String addCommandFormat = "add m/MODULE_CODE [g/GRADE]\n\n";
    private static final String updateCommandFormat = "update m/MODULE_CODE [g/GRADE]\n\n";
    private static final String listCommandFormat = "list\n\n";
    private static final String goalCommandFormat = "goal set LEVEL OR goal list\n\n";
    private static final String recommendSuCommandFormat = "recommendSU\n\n";
    private static final String suCommandFormat = "su MODULE_CODE\n\n";
    private static final String deleteCommandFormat = "delete MODULE_CODE\n\n";
    private static final String doneCommandFormat = "done SEMESTER\n\n";
    private static final String findCommandFormat = "find KEYWORD\n\n";
    private static final String progressCommandFormat = "progress [--ddp]\n\n";
    private static final String helpCommandFormat = "help\n\n";
    private static final String exitCommandFormat = "exit\n\n";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label helpCommands;

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        //setHelpCommands();

        setHelpCommands();
        scrollPane.setVvalue(0);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    private void setHelpCommands() {
        String helpCommandList =
                "Command Formats:\n\n"
                + startCommandFormat
                + addCommandFormat
                + updateCommandFormat
                + listCommandFormat
                + goalCommandFormat
                + recommendSuCommandFormat
                + suCommandFormat
                + deleteCommandFormat
                + doneCommandFormat
                + findCommandFormat
                + progressCommandFormat
                + helpCommandFormat
                + exitCommandFormat;

        helpCommands.setText(helpCommandList);
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
