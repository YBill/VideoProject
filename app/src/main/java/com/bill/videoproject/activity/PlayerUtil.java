package com.bill.videoproject.activity;

import android.media.AudioManager;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayerUtil {

    private static class SingletonHolder {
        private final static PlayerUtil instance = new PlayerUtil();
    }

    public static PlayerUtil getInstance() {
        return SingletonHolder.instance;
    }

    private PlayerUtil() {

    }

    private IjkMediaPlayer mPlayer;

    public void play(SurfaceHolder holder) {
        if (mPlayer == null) {
            mPlayer = new IjkMediaPlayer();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mPlayer.setDataSource("https://rmrbtest-image.peopleapp.com/upload/video/201809/1537349021125fcfb438615c1b.mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
            mPlayer.prepareAsync();
        }
        mPlayer.setDisplay(holder);
    }

    public void play(Surface holder) {
        if (mPlayer == null) {
            mPlayer = new IjkMediaPlayer();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mPlayer.setDataSource("https://rmrbtest-image.peopleapp.com/upload/video/201809/1537349021125fcfb438615c1b.mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
            mPlayer.prepareAsync();
        }
        mPlayer.setSurface(holder);
    }

    public void release() {
        Log.e("Bill", "mPlayer:" + mPlayer);
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        IjkMediaPlayer.native_profileEnd();
    }

}
