package seedu.address.ui;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DragResizerTest {
    @Test
    public void constructor_test() {
        assertThrows(NullPointerException.class, () -> DragResizer.makeResizable(null));
    }
}
