package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
class HelpWindowTest {

    private static final String startCommandFormat = "start SEMESTER\n\n";
    private static final String addCommandFormat = "add m/MODULE_CODE [g/GRADE] [mc/MODULAR CREDITS]\n\n";
    private static final String updateCommandFormat = "update m/MODULE_CODE [g/GRADE] [s/SEMESTER]\n\n";
    private static final String listCommandFormat = "list\n\n";
    private static final String goalCommandFormat = "goal set LEVEL OR goal list\n\n";
    private static final String recommendSuCommandFormat = "recommendSU\n\n";
    private static final String suCommandFormat = "su MODULE_CODE\n\n";
    private static final String deleteCommandFormat = "delete MODULE_CODE\n\n";
    private static final String doneCommandFormat = "done\n\n";
    private static final String findCommandFormat = "find KEYWORD\n\n";
    private static final String progressCommandFormat = "progress [ddp]\n\n";
    private static final String clearCommandFormat = "clear\n\n";
    private static final String helpCommandFormat = "help\n\n";
    private static final String exitCommandFormat = "exit\n\n";

    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage stage) throws IOException {
        HelpWindow helpWindow = new HelpWindow(stage);
        stage.setScene(new Scene(new AnchorPane(helpWindow.getRoot().getScene().getRoot()), 100, 100));
        stage.show();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void help_window_test(FxRobot robot) {
        Label labelHelpCommands = robot.lookup("#helpCommands").queryAs(Label.class);
        Label labelHelpMessage = robot.lookup("#helpMessage").queryAs(Label.class);
        assertNotNull(labelHelpCommands);
        assertNotNull(labelHelpMessage);

        String expectedCommands = "Command Formats:\n\n"
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
            + clearCommandFormat
            + helpCommandFormat
            + exitCommandFormat;
        assertEquals(expectedCommands, labelHelpCommands.getText());
        assertEquals("OR, ", labelHelpMessage.getText());

    }
}
