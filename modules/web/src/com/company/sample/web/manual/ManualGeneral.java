package com.company.sample.web.manual;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.components.UrlResource;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

@UiController("sample_ManualGeneral")
@UiDescriptor("manual-general.xml")
public class ManualGeneral extends Screen {

    @Inject
    private Image testImage;

    @Subscribe
    private void onInit(InitEvent event) {
        updateImage();
    }

    @Subscribe("showOtherImage")
    private void onShowOtherImageClick(Button.ClickEvent event) {
        updateImage();
    }

    private void updateImage() {
        testImage.setSource(UrlResource.class)
                .setUrl(getImageUrl());

    }

    private URL getImageUrl() {
        URL imageUrl;

        try {
            imageUrl = new URL("https://picsum.photos/300/200?random=" + new Random().nextInt(1000));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create an URL for image", e);
        }

        return imageUrl;
    }
}