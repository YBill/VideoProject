package com.bill.videoproject.setting;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        PlayerType.PV_PLAYER__NONE,
        PlayerType.PV_PLAYER__AndroidMediaPlayer,
        PlayerType.PV_PLAYER__IjkMediaPlayer,
        PlayerType.PV_PLAYER__IjkExoMediaPlayer,
})
@Retention(RetentionPolicy.SOURCE)
public @interface PlayerType {
    int PV_PLAYER__NONE = 0;
    int PV_PLAYER__AndroidMediaPlayer = 1;
    int PV_PLAYER__IjkMediaPlayer = 2;
    int PV_PLAYER__IjkExoMediaPlayer = 3;
}