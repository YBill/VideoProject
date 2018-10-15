package com.bill.videoproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.bill.videoproject.R;
import com.bill.videoproject.setting.PixelFormatType;
import com.bill.videoproject.setting.PlayerConfig;
import com.bill.videoproject.setting.PlayerType;
import com.bill.videoproject.setting.RenderType;
import com.bill.videoproject.setting.ScaleType;

public class VideoSettingActivity extends AppCompatActivity {

    private RadioGroup mPlayerTypeGroup;
    private RadioGroup mRenderTypeGroup;
    private RadioGroup mScaleTypeGroup;
    private RadioGroup mPixelFormatTypeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_setting);

        mPlayerTypeGroup = findViewById(R.id.player_type);
        mRenderTypeGroup = findViewById(R.id.render_type);
        mScaleTypeGroup = findViewById(R.id.scale_type);
        mPixelFormatTypeGroup = findViewById(R.id.pixel_format_type);

    }


    private void goVideoAct() {
        switch (mPlayerTypeGroup.getCheckedRadioButtonId()) {
            case R.id.ijk_player:
                PlayerConfig.getInstance().setPlayer(PlayerType.PV_PLAYER__IjkMediaPlayer);
                break;
            case R.id.media_player:
                PlayerConfig.getInstance().setPlayer(PlayerType.PV_PLAYER__AndroidMediaPlayer);
                break;
            case R.id.exo_player:
                PlayerConfig.getInstance().setPlayer(PlayerType.PV_PLAYER__IjkExoMediaPlayer);
                break;
        }
        switch (mRenderTypeGroup.getCheckedRadioButtonId()) {
            case R.id.surface_view:
                PlayerConfig.getInstance().setRender(RenderType.RENDER_SURFACE_VIEW);
                break;
            case R.id.texture_view:
                PlayerConfig.getInstance().setRender(RenderType.RENDER_TEXTURE_VIEW);
                break;
            case R.id.no_view:
                PlayerConfig.getInstance().setRender(RenderType.RENDER_NONE_VIEW);
                break;
        }
        switch (mScaleTypeGroup.getCheckedRadioButtonId()) {
            case R.id.fit_parent:
                PlayerConfig.getInstance().setScale(ScaleType.AR_ASPECT_FIT_PARENT);
                break;
            case R.id.fill_parent:
                PlayerConfig.getInstance().setScale(ScaleType.AR_ASPECT_FILL_PARENT);
                break;
            case R.id.wrap_content:
                PlayerConfig.getInstance().setScale(ScaleType.AR_ASPECT_WRAP_CONTENT);
                break;
            case R.id.match_parent:
                PlayerConfig.getInstance().setScale(ScaleType.AR_MATCH_PARENT);
                break;
            case R.id.fit_parent_16_9:
                PlayerConfig.getInstance().setScale(ScaleType.AR_16_9_FIT_PARENT);
                break;
            case R.id.wrap_content_4_3:
                PlayerConfig.getInstance().setScale(ScaleType.AR_4_3_FIT_PARENT);
                break;
        }
        switch (mPixelFormatTypeGroup.getCheckedRadioButtonId()) {
            case R.id.rgb_565:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.RGB_565);
                break;
            case R.id.rgb_888:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.RGB_888);
                break;
            case R.id.rgbx_8888:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.RGBX_8888);
                break;
            case R.id.yv12:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.YV12);
                break;
            case R.id.opengl_es2:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.OpenGL_ES2);
                break;
        }

        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }

    public void handleVideo(View view) {
        goVideoAct();
    }
}
