package com.projeto.photoface;

import android.content.res.Resources;

import com.acesso.acessobio_android.onboarding.IAcessoBioTheme;

public class UnicoTheme implements IAcessoBioTheme {

    private final Resources resources;

    public UnicoTheme(Resources resources) {
        this.resources = resources;
    }

    @Override
    public Object getColorBackground() {
        return "727175";
    }

    @Override
    public Object getColorBoxMessage() {
        return "#00EC55";
    }

    @Override
    public Object getColorTextMessage() {
        return "#1F193D";
    }

    @Override
    public Object getColorBackgroundPopupError() {
        return "#1F193D";
    }

    @Override
    public Object getColorTextPopupError() {
        return "#ffffff";
    }

    @Override
    public Object getColorBackgroundButtonPopupError() {
        return "#00EC55";
    }

    @Override
    public Object getColorTextButtonPopupError() {
        return "#727175";
    }

    @Override
    public Object getColorBackgroundTakePictureButton() {
        return "#00EC55";
    }

    @Override
    public Object getColorIconTakePictureButton() {
        return "#1F193D";
    }

    @Override
    public Object getColorBackgroundBottomDocument() {
        return "#727175";
    }

    @Override
    public Object getColorTextBottomDocument() {
        return  "#00EC55";
    }

    @Override
    public Object getColorSilhouetteSuccess() {
        return "#ffffff";
    }

    @Override
    public Object getColorSilhouetteError() {
        return "#ffffff";
    }

    @Override
    public Object getColorSilhouetteNeutral() {
        return "#ffffff";
    }
}
