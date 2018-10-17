package com.bill.videoproject.activity;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;

import com.bill.videoproject.R;

public class VideoDetailActivity extends AppCompatActivity {

//    private SurfaceView renderView;
    private TextureView textureView;
    private Surface mSurface;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
//        renderView = findViewById(R.id.surface_view);
//        renderView.getHolder().addCallback(callback);

        textureView = findViewById(R.id.surface_view);
        textureView.setSurfaceTextureListener(listener);

        ViewCompat.setTransitionName(textureView, "view");
    }

    @Override
    public void finish() {
        setResult(RESULT_OK);
        super.finish();
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
            textureView.setSurfaceTextureListener(null);
            textureView = null;
            mSurface = null;
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    private SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
//            PlayerUtil.getInstance().play(renderView.getHolder());
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
        }
    };

}
