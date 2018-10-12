package com.bill.videoproject.setting;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        RenderType.RENDER_NONE,
        RenderType.RENDER_SURFACE_VIEW,
        RenderType.RENDER_TEXTURE_VIEW,
        RenderType.RENDER_NONE_VIEW
})
@Retention(RetentionPolicy.SOURCE)
public @interface RenderType {
    int RENDER_NONE = 0;
    int RENDER_SURFACE_VIEW = 1;
    int RENDER_TEXTURE_VIEW = 2;
    int RENDER_NONE_VIEW = 3;
}