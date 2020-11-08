package seedu.address.ui;

import org.junit.jupiter.api.Test;
import seedu.address.model.semester.Semester;

import static org.junit.jupiter.api.Assertions.*;

public class SemBoxTest {

    @Test
    public void setSemDisplayMethodTestSuccess() {
        SemBox semBox = new SemBox("Y1S1");
        String expectedDisplaySuccess = "Currently editing: Y1S1";

        String testDisplay = semBox.getCurrentSemDisplay().getText();

        assertEquals(testDisplay, expectedDisplaySuccess);

    }

    @Test
    public void setSemDisplayMethodTestRemainSameFalse() {
        SemBox semBox = new SemBox("Y2S2");
        String expectedDisplayFail = "Currently editing: Y1S1";

        String testDisplay = semBox.getCurrentSemDisplay().getText();

        assertNotEquals(expectedDisplayFail, testDisplay);
    }
}
