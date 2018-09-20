package com.bill.videoproject.setting;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        PixelFormatType.RGB_565,
        PixelFormatType.RGB_888,
        PixelFormatType.RGBX_8888,
        PixelFormatType.YV12,
        PixelFormatType.OpenGL_ES2,
})
@Retention(RetentionPolicy.SOURCE)
public @interface PixelFormatType {
    String RGB_565 = "fcc-rv16";
    String RGB_888 = "fcc-rv24";
    String RGBX_8888 = "fcc-rv32";
    String YV12 = "fcc-yv12";
    String OpenGL_ES2 = "fcc-_es2";
}