package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static java.util.Objects.requireNonNull;

public class CapBox extends UiPart<Region> {
    private static final String FXML = "capBox.fxml";

    @FXML
    private Text currentCAPDisplay;

    public CapBox(String currentCAP) {
        super(FXML);
        setCAPDisplay(currentCAP);
        currentCAPDisplay.setFill(Color.WHITE);
    }

    public void setCAPDisplay(String currentCAP) {
        requireNonNull(currentCAP);
        currentCAPDisplay.setText("Current CAP: " + currentCAP);
    }
}
