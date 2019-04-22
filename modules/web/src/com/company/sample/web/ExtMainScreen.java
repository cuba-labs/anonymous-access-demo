package com.company.sample.web;

import com.company.sample.web.promo.PromoScreen;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;

@UiController("main")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Subscribe("goToPromoLink")
    private void onGoToPromoLinkClick(Button.ClickEvent event) {
        PromoScreen promoScreen = UiControllerUtils.getScreenContext(this)
                .getScreens()
                .create(PromoScreen.class, OpenMode.ROOT);

        promoScreen.show();
    }
}