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
        return resources.getColor( R.color.liveness_background);
    }

    @Override
    public Object getColorBoxMessage() {
        return resources.getColor( R.color.liveness_color_box_message);
    }

    @Override
    public Object getColorTextMessage() {
        return resources.getColor( R.color.liveness_color_text_message);
    }

    @Override
    public Object getColorBackgroundPopupError() {
        return resources.getColor( R.color.liveness_color_popup_error);
    }

    @Override
    public Object getColorTextPopupError() {
        return resources.getColor( R.color.liveness_color_text_popup_error);
    }

    @Override
    public Object getColorBackgroundButtonPopupError() {
        return resources.getColor( R.color.liveness_color_button_popup_error);
    }

    @Override
    public Object getColorTextButtonPopupError() {
        return resources.getColor( R.color.liveness_color_text_button_popup_error);
    }

    @Override
    public Object getColorBackgroundTakePictureButton() {
        return resources.getColor( R.color.liveness_color_background_take_picture_button);
    }

    @Override
    public Object getColorIconTakePictureButton() {
        return resources.getColor( R.color.liveness_color_icon_take_picture_button);
    }

    @Override
    public Object getColorBackgroundBottomDocument() {
        return resources.getColor( R.color.liveness_color_background_document_button);
    }

    @Override
    public Object getColorTextBottomDocument() {
        return resources.getColor( R.color.liveness_color_text_button_document);
    }

    @Override
    public Object getColorSilhouetteSuccess() {
        return resources.getColor( R.color.liveness_color_silhouette_success);
    }

    @Override
    public Object getColorSilhouetteError() {
        return resources.getColor( R.color.liveness_color_silhouette_success_error);
    }

    @Override
    public Object getColorSilhouetteNeutral() {
        return resources.getColor( R.color.liveness_color_silhouette_neutral);
    }
}
