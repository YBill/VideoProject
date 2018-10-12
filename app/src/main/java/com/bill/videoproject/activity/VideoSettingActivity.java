package com.bill.videoproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.bill.videoproject.R;
import com.bill.videoproject.setting.PlayerConfig;
import com.bill.videoproject.setting.PlayerType;

public class VideoSettingActivity extends AppCompatActivity {

    private RadioGroup mPlayerTypeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_setting);

        mPlayerTypeGroup = findViewById(R.id.player_type);

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

        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }

    public void handleVideo(View view) {
        goVideoAct();
    }
}
