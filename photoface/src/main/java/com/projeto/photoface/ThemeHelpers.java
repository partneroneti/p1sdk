package com.projeto.photoface;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;

import com.projeto.photoface.R;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecCustomization;
import com.facetec.sdk.FaceTecSDK;

public class ThemeHelpers {

    public static void setAppTheme(Context context, String theme) {
        Config.currentCustomization = getCustomizationForTheme(context);
        Config.currentLowLightCustomization = getLowLightCustomizationForTheme(context, theme);
        Config.currentDynamicDimmingCustomization = getDynamicDimmingCustomizationForTheme(context, theme);

        //SampleAppUtilities.setVocalGuidanceSoundFiles();

        FaceTecSDK.setCustomization(Config.currentCustomization);
        FaceTecSDK.setLowLightCustomization(Config.currentLowLightCustomization);
        FaceTecSDK.setDynamicDimmingCustomization(Config.currentDynamicDimmingCustomization);
    }

    public static FaceTecCustomization getCustomizationForTheme(Context context) {
        FaceTecCustomization currentCustomization = new FaceTecCustomization();

        int[] retryScreenSlideshowImages = new int[]{R.drawable.ideal_image_1, R.drawable.ideal_image_2, R.drawable.ideal_image_3, R.drawable.ideal_image_4, R.drawable.ideal_image_5};


            int primaryColor = Color.parseColor("#2B2B2B"); // black
            int secondaryColor = Color.parseColor("#454545"); // cinza
            int backgroundColor = Color.parseColor("#EEF6F8"); // white
            int buttonBackgroundDisabledColor = Color.parseColor("#adadad");

            Typeface boldTypeface = Typeface.create("sans-serif", Typeface.BOLD);
            Typeface normalTypeface = Typeface.create("sans-serif", Typeface.NORMAL);

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = backgroundColor;
            currentCustomization.getOverlayCustomization().showBrandingImage = false;
            currentCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = boldTypeface;
            currentCustomization.getGuidanceCustomization().subtextFont = normalTypeface;
            currentCustomization.getGuidanceCustomization().buttonFont = boldTypeface;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 30;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 10;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 2000;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_shutter_offblack;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenDocumentImage = true;
            currentCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_offblack;
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = Color.parseColor("#565656");
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageFont = normalTypeface;
            currentCustomization.getIdScanCustomization().headerFont = boldTypeface;
            currentCustomization.getIdScanCustomization().subtextFont = normalTypeface;
            currentCustomization.getIdScanCustomization().buttonFont = boldTypeface;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 30;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_black;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_black;
            currentCustomization.getIdScanCustomization().customNFCStartingAnimation = R.drawable.facetec_nfc_starting_animation_black;
            currentCustomization.getIdScanCustomization().customNFCScanningAnimation = R.drawable.facetec_nfc_scanning_animation;
            currentCustomization.getIdScanCustomization().customNFCSkipOrErrorAnimation = R.drawable.pseudo_fullscreen_animated_unsuccess;
            currentCustomization.getIdScanCustomization().customStaticNFCStartingAnimation = R.drawable.facetec_nfc_starting_static_vector_drawable_black;
            currentCustomization.getIdScanCustomization().customStaticNFCScanningAnimation = R.drawable.facetec_nfc_scanning_static_vector_drawable;
            currentCustomization.getIdScanCustomization().customStaticNFCSkipOrErrorAnimation = R.drawable.pseudo_fullscreen_static_unsuccess_vector_drawable;
           /* currentCustomization.getIdScanCustomization().additionalReviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().additionalReviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().additionalReviewScreenImage = R.drawable.review_offblack;
            currentCustomization.getIdScanCustomization().additionalReviewScreenAnimation = 0;
            currentCustomization.getIdScanCustomization().additionalReviewScreenStaticAnimation = 0;*/
            // OCR Confirmation Screen Customization
            currentCustomization.getOcrConfirmationCustomization().backgroundColors = backgroundColor;
            currentCustomization.getOcrConfirmationCustomization().mainHeaderDividerLineColor = secondaryColor;
            currentCustomization.getOcrConfirmationCustomization().mainHeaderDividerLineWidth = 2;
            currentCustomization.getOcrConfirmationCustomization().mainHeaderFont = boldTypeface;
            currentCustomization.getOcrConfirmationCustomization().sectionHeaderFont = boldTypeface;
            currentCustomization.getOcrConfirmationCustomization().fieldLabelFont = normalTypeface;
            currentCustomization.getOcrConfirmationCustomization().fieldValueFont = normalTypeface;
            currentCustomization.getOcrConfirmationCustomization().inputFieldFont = normalTypeface;
            currentCustomization.getOcrConfirmationCustomization().inputFieldPlaceholderFont = normalTypeface;
            currentCustomization.getOcrConfirmationCustomization().mainHeaderTextColor = secondaryColor;
            currentCustomization.getOcrConfirmationCustomization().sectionHeaderTextColor = primaryColor;
            currentCustomization.getOcrConfirmationCustomization().fieldLabelTextColor = primaryColor;
            currentCustomization.getOcrConfirmationCustomization().fieldValueTextColor = primaryColor;
            currentCustomization.getOcrConfirmationCustomization().inputFieldTextColor = primaryColor;
            currentCustomization.getOcrConfirmationCustomization().inputFieldPlaceholderTextColor = Color.parseColor("#663BC371");
            currentCustomization.getOcrConfirmationCustomization().inputFieldBackgroundColor = Color.TRANSPARENT;
            currentCustomization.getOcrConfirmationCustomization().inputFieldBorderColor = secondaryColor;
            currentCustomization.getOcrConfirmationCustomization().inputFieldBorderWidth = 2;
            currentCustomization.getOcrConfirmationCustomization().inputFieldCornerRadius = 0;
            currentCustomization.getOcrConfirmationCustomization().showInputFieldBottomBorderOnly = true;
            currentCustomization.getOcrConfirmationCustomization().buttonFont = boldTypeface;
            currentCustomization.getOcrConfirmationCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getOcrConfirmationCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getOcrConfirmationCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getOcrConfirmationCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getOcrConfirmationCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getOcrConfirmationCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getOcrConfirmationCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getOcrConfirmationCustomization().buttonBorderWidth = 0;
            currentCustomization.getOcrConfirmationCustomization().buttonCornerRadius = 30;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = boldTypeface;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 800;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage =0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.pseudo_fullscreen_animated_success;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_animated_unsuccess;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.pseudo_fullscreen_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#332B2B2B");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = boldTypeface;
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 0;
            currentCustomization.getFrameCustomization().cornerRadius = 0;
            currentCustomization.getFrameCustomization().elevation = 0;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF3BC371");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF3BC371");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offblack;
            currentCustomization.getCancelButtonCustomization().setLocation(FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM);
            currentCustomization.getCancelButtonCustomization().setCustomLocation(new Rect(10, 10, 25, 25));
            // Securing Camera Screen Customization (Exclusive to Photo ID Scan Only Mode)
           /* currentCustomization.getInitialLoadingAnimationCustomization().backgroundColors = backgroundColor;
            currentCustomization.getInitialLoadingAnimationCustomization().foregroundColor = primaryColor;
            currentCustomization.getInitialLoadingAnimationCustomization().customAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator;
            currentCustomization.getInitialLoadingAnimationCustomization().customAnimationImage = 0;
            currentCustomization.getInitialLoadingAnimationCustomization().customAnimationImageRotationInterval = 800;
            currentCustomization.getInitialLoadingAnimationCustomization().animationRelativeScale = 1.0f;
            currentCustomization.getInitialLoadingAnimationCustomization().defaultAnimationBackgroundColor = Color.parseColor("#E6E6E6");
            currentCustomization.getInitialLoadingAnimationCustomization().defaultAnimationForegroundColor = primaryColor;
            currentCustomization.getInitialLoadingAnimationCustomization().messageFont = boldTypeface;*/

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().readyScreenHeaderFont = boldTypeface;
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentCustomization.getGuidanceCustomization().readyScreenSubtextFont = normalTypeface;
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = Color.parseColor("#565656");
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().retryScreenHeaderFont = boldTypeface;
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentCustomization.getGuidanceCustomization().retryScreenSubtextFont = normalTypeface;
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = Color.parseColor("#565656");


        return currentCustomization;
    }

    static FaceTecCustomization getLowLightCustomizationForTheme(Context context, String theme) {
        FaceTecCustomization currentLowLightCustomization = getCustomizationForTheme(context);

        return currentLowLightCustomization;
    }

    static FaceTecCustomization getDynamicDimmingCustomizationForTheme(Context context, String theme) {
        FaceTecCustomization currentDynamicDimmingCustomization = getCustomizationForTheme(context);

        int[] retryScreenSlideshowImages = new int[]{R.drawable.ideal_image_1, R.drawable.ideal_image_2, R.drawable.ideal_image_3, R.drawable.ideal_image_4, R.drawable.ideal_image_5};



            int primaryColor = Color.parseColor("#EEF6F8"); // white
            int secondaryColor = Color.parseColor("#3BC371"); // green
            int backgroundColor = Color.BLACK;

            // Overlay Customization
            currentDynamicDimmingCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentDynamicDimmingCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.WHITE;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextDisabledColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = Color.parseColor("#BFEEF6F8");
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            // ID Scan Customization
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.WHITE;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = Color.parseColor("#BFEEF6F8");
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().customNFCStartingAnimation = R.drawable.facetec_nfc_starting_animation_black;
            currentDynamicDimmingCustomization.getIdScanCustomization().customNFCScanningAnimation = R.drawable.facetec_nfc_scanning_animation;
            currentDynamicDimmingCustomization.getIdScanCustomization().customNFCSkipOrErrorAnimation = R.drawable.pseudo_fullscreen_animated_unsuccess_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().customStaticNFCStartingAnimation = R.drawable.facetec_nfc_starting_static_vector_drawable_black;
            currentDynamicDimmingCustomization.getIdScanCustomization().customStaticNFCScanningAnimation = R.drawable.facetec_nfc_scanning_static_vector_drawable;
            currentDynamicDimmingCustomization.getIdScanCustomization().customStaticNFCSkipOrErrorAnimation = R.drawable.pseudo_fullscreen_static_unsuccess_offwhite_vector_drawable;
           /* currentDynamicDimmingCustomization.getIdScanCustomization().additionalReviewScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().additionalReviewScreenImage = R.drawable.review_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().additionalReviewScreenAnimation = 0;
            currentDynamicDimmingCustomization.getIdScanCustomization().additionalReviewScreenStaticAnimation = 0;*/
            // OCR Confirmation Screen Customization
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().mainHeaderDividerLineColor = secondaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().mainHeaderTextColor = secondaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().sectionHeaderTextColor = primaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().fieldLabelTextColor = primaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().fieldValueTextColor = primaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().inputFieldTextColor = primaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().inputFieldPlaceholderTextColor = Color.parseColor("#663BC371");
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().inputFieldBackgroundColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().inputFieldBorderColor = secondaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonTextNormalColor = backgroundColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonBackgroundNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonBackgroundHighlightColor = Color.WHITE;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonTextDisabledColor = backgroundColor;
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonBackgroundDisabledColor = Color.parseColor("#BFEEF6F8");
            currentDynamicDimmingCustomization.getOcrConfirmationCustomization().buttonBorderColor = Color.TRANSPARENT;
            // Result Screen Customization
            currentDynamicDimmingCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator_offwhite;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = secondaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.pseudo_fullscreen_animated_success_offwhite;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_animated_unsuccess_offwhite;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.pseudo_fullscreen_static_success_offwhite_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_static_unsuccess_offwhite_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#332B2B2B");
            currentDynamicDimmingCustomization.getResultScreenCustomization().uploadProgressFillColor = secondaryColor;
            // Feedback Customization
            currentDynamicDimmingCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentDynamicDimmingCustomization.getFeedbackCustomization().textColor = backgroundColor;
            // Frame Customization
            currentDynamicDimmingCustomization.getFrameCustomization().borderColor = primaryColor;
            // Oval Customization
            currentDynamicDimmingCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentDynamicDimmingCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF3BC371");
            currentDynamicDimmingCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF3BC371");
            // Cancel Button Customization
            currentDynamicDimmingCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offwhite;
            // Securing Camera Screen Customization (Exclusive to Photo ID Scan Only Mode)
            /*currentDynamicDimmingCustomization.getInitialLoadingAnimationCustomization().foregroundColor = primaryColor;
            currentDynamicDimmingCustomization.getInitialLoadingAnimationCustomization().customAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator_offwhite;
            currentDynamicDimmingCustomization.getInitialLoadingAnimationCustomization().customAnimationImage = 0;
            currentDynamicDimmingCustomization.getInitialLoadingAnimationCustomization().defaultAnimationBackgroundColor = Color.parseColor("#332B2B2B");
            currentDynamicDimmingCustomization.getInitialLoadingAnimationCustomization().defaultAnimationForegroundColor = secondaryColor;*/

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = primaryColor;
            // Ready Screen Header
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = primaryColor;


        return currentDynamicDimmingCustomization;
    }

}
