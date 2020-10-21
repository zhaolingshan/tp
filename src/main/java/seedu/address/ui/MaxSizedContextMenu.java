package seedu.address.ui;

import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.layout.Region;

public class MaxSizedContextMenu extends ContextMenu {

    /**
     * Current implementation of javafx ContextMenu's height does not allow us
     * to limiting the size of popup is not supported: the Region that's responsible
     * for showing the MenuItems is ContextMenuContent and implements its
     * computeMaxHeight to return the screenHeight. That container is created by
     * ContextMenuSkin and stored into a private final field, so there's no way to
     * replace it with a custom implementation with a more intelligent implementation.
     *
     * This implementation below access that region and set its maxHeight to the same
     * value as the ContextMenu.
     *
     */
    public MaxSizedContextMenu() {
        addEventHandler(Menu.ON_SHOWING, e -> {
            Node content = getSkin().getNode();
            if (content instanceof Region) {
                Region region = (Region) content;
                region.setMaxHeight(getMaxHeight());
            }
        });
    }
}
