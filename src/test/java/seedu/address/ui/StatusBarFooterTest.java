package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;

@ExtendWith(ApplicationExtension.class)
class StatusBarFooterTest {

    StatusBarFooter statusBarFooter;
    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage stage) throws IOException {
        Path path = Path.of("data\\gradebook.json");
        statusBarFooter = new StatusBarFooter(path);
        stage.setScene(new Scene(new AnchorPane(statusBarFooter.getRoot()), 100, 100));
        stage.show();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void result_display_test(FxRobot robot) {
        Label label = robot.lookup("#saveLocationStatus").queryAs(Label.class);
        assertNotNull(label);

        assertEquals(".\\data\\gradebook.json", label.getText());
    }
}
