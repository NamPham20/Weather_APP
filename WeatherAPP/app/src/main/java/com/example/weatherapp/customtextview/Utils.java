package com.example.weatherapp.customtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;

public class Utils {

    private static Typeface sfProTextTypeface;

    public static Typeface getSfProTextTypeface(Context context) {
        if (sfProTextTypeface == null){
            sfProTextTypeface = Typeface.createFromAsset(context.getAssets(),"fonts/sf_pro_text_regular.otf");
        }
        return sfProTextTypeface;
    }

    public static void setFullScreen(View decorView ){
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }
    }
