package com.bill.videoproject.text;

import android.support.annotation.NonNull;

import com.bill.videoproject.setting.PlayerType;
import com.bill.videoproject.widget.media.IRenderView;
import com.bill.videoproject.widget.media.IjkVideoView;

public class PlayerText {
    @NonNull
    public static String getPlayerText(@PlayerType int player) {
        String text;
        switch (player) {
            case PlayerType.PV_PLAYER__AndroidMediaPlayer:
                text = "Player: AndroidMediaPlayer";
                break;
            case PlayerType.PV_PLAYER__IjkMediaPlayer:
                text = "Player: IjkMediaPlayer";
                break;
            case PlayerType.PV_PLAYER__IjkExoMediaPlayer:
                text = "Player: IjkExoMediaPlayer";
                break;
            default:
                text = "N/A";
                break;
        }
        return text;
    }

    @NonNull
    public static String getAspectRatioText(int aspectRatio) {
        String text;
        switch (aspectRatio) {
            case IRenderView.AR_ASPECT_FIT_PARENT:
                text = "Aspect / Fit parent";
                break;
            case IRenderView.AR_ASPECT_FILL_PARENT:
                text = "Aspect / Fill parent";
                break;
            case IRenderView.AR_ASPECT_WRAP_CONTENT:
                text = "Aspect / Wrap content";
                break;
            case IRenderView.AR_MATCH_PARENT:
                text = "Free / Fill parent";
                break;
            case IRenderView.AR_16_9_FIT_PARENT:
                text = "16:9 / Fit parent";
                break;
            case IRenderView.AR_4_3_FIT_PARENT:
                text = "4:3 / Fit parent";
                break;
            default:
                text = "N/A";
                break;
        }
        return text;
    }

    @NonNull
    public static String getRenderText(int render) {
        String text;
        switch (render) {
            case IjkVideoView.RENDER_NONE:
                text = "Render: None";
                break;
            case IjkVideoView.RENDER_SURFACE_VIEW:
                text = "Render: SurfaceView";
                break;
            case IjkVideoView.RENDER_TEXTURE_VIEW:
                text = "Render: TextureView";
                break;
            default:
                text = "N/A";
                break;
        }
        return text;
    }

}
