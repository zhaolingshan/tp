package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.control.TextArea;

@ExtendWith(ApplicationExtension.class)
class ResultDisplayTest_JUnit5Hamcrest {

    ResultDisplay resultDisplay;
    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage stage) throws IOException {
        resultDisplay = new ResultDisplay();
        stage.setScene(new Scene(new AnchorPane(resultDisplay.getRoot()), 100, 100));
        stage.show();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void result_display_test(FxRobot robot) {
        TextArea textArea = robot.lookup("#resultDisplay").queryAs(TextArea.class);
        assertNotNull(textArea);

        resultDisplay.setFeedbackToUser("TEST");
        assertEquals("TEST", textArea.getText());
    }
}
