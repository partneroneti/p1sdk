package com.projeto.photoface;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.FaceDetector;



class ThemeHelpers {

    public static void setAppTheme(Context context, String theme) {
        Typeface font = Typeface.createFromAsset(context.getAssets(),"SFProDisplay-Regular.ttf");
        Config.font= font;
//        Config.currentCustomization = getCustomizationForTheme(context);
//        Config.currentLowLightCustomization = getLowLightCustomizationForTheme(context, theme);
//        Config.currentDynamicDimmingCustomization = getDynamicDimmingCustomizationForTheme(context, theme);


        //SampleAppUtilities.setVocalGuidanceSoundFiles();


    }

//    public static FaceTecCustomization getCustomizationForTheme(Context context) {
//        FaceTecCustomization currentCustomization = new FaceTecCustomization();
//        currentCustomization.vocalGuidanceCustomization.mode = FaceTecVocalGuidanceCustomization.VocalGuidanceMode.NO_VOCAL_GUIDANCE;
//        currentCustomization = Config.retrieveConfigurationWizardCustomization();
//        currentCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offwhite;
//        return currentCustomization;
//    }
//
//    static FaceTecCustomization getLowLightCustomizationForTheme(Context context, String theme) {
//        FaceTecCustomization currentLowLightCustomization = Config.retrieveLowLightConfigurationWizardCustomization();
//        currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offwhite;
//        return currentLowLightCustomization;
//    }
//
//    static FaceTecCustomization getDynamicDimmingCustomizationForTheme(Context context, String theme) {
//        FaceTecCustomization currentDynamicDimmingCustomization = Config.retrieveDynamicDimmingConfigurationWizardCustomization();
//        currentDynamicDimmingCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offwhite;
//
//        return currentDynamicDimmingCustomization;
//    }

}
