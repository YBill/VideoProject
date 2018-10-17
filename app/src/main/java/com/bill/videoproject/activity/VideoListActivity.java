package com.bill.videoproject.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import com.bill.videoproject.R;

public class VideoListActivity extends AppCompatActivity {

    private TextureView renderView;
    private Surface mSurface;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        renderView = findViewById(R.id.surface_view);
        renderView.setSurfaceTextureListener(listener);
        renderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoListActivity.this, VideoDetailActivity.class);
//                startActivityForResult(intent, 1);

                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        VideoListActivity.this, renderView, "view");
                ActivityCompat.startActivityForResult(VideoListActivity.this, intent, 1, activityOptions.toBundle());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PlayerUtil.getInstance().release();
    }

    private TextureView.SurfaceTextureListener listener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            mSurface = new Surface(surface);
            PlayerUtil.getInstance().play(mSurface);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            renderView.setSurfaceTextureListener(null);
            renderView = null;
            mSurface = null;
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            PlayerUtil.getInstance().play(mSurface);
        }

    }
}
