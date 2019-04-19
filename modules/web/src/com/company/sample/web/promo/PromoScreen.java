package com.company.sample.web.promo;

import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;

import static com.haulmont.cuba.gui.screen.UiControllerUtils.getScreenContext;

@Route(path = "promo", root = true)
@UiController("promo")
@UiDescriptor("promo-screen.xml")
public class PromoScreen extends Screen {

    @Subscribe("goToAppLink")
    private void onGoToAppLinkClick(Button.ClickEvent event) {
        MainScreen mainScreen = getScreenContext(this)
                .getScreens()
                .create(MainScreen.class, OpenMode.ROOT);
        mainScreen.show();
    }
}