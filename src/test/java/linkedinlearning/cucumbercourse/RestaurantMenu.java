package linkedinlearning.cucumbercourse;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {

    private final List<RestaurantMenuItem> menuItems = new ArrayList<>();

    public static final String DUPLICATE_MESSAGE_EXCEPTION = "Duplicate menu item";


    public void addMenuItem(RestaurantMenuItem newMenuItem) {
        if(doesExistis(newMenuItem))
            throw new IllegalArgumentException(DUPLICATE_MESSAGE_EXCEPTION);

        menuItems.add(newMenuItem);
    }

    public boolean doesExistis(RestaurantMenuItem newMenuItem){
        return menuItems.contains(newMenuItem);
    }
}
