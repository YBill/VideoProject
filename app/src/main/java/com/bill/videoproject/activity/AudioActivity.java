package com.bill.videoproject.activity;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.bill.videoproject.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class AudioActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask timerTask;
    private IjkMediaPlayer ijkMediaPlayer;

    private int playStatus = 0;

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (ijkMediaPlayer == null) {
                    return;
                }
                int cp = seekBar.getProgress();
                double p = cp * ijkMediaPlayer.getDuration() / 100.0;
                ijkMediaPlayer.seekTo((long) p);
                Log.d("Bill", cp + "|" + p);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeTimer();
        release();
    }

    public void handleStart(View view) {
        if (playStatus == 2) {
            start();
        } else if (playStatus == 0) {
            createPlayer();
        }
    }

    public void handlePause(View view) {
        if (playStatus == 1) {
            pause();
        }
    }

    public void handleStop(View view) {
        if (playStatus != 0) {
            release();
            seekBar.setProgress(0);
        }
    }

    private void start() {
        playStatus = 1;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.start();
        }
    }

    private void pause() {
        playStatus = 2;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.pause();
        }
    }

    private void stop() {
        playStatus = 0;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
            ijkMediaPlayer.reset();
        }
    }

    private void release() {
        stop();
        playStatus = 0;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
            ijkMediaPlayer = null;
        }
    }

    private void createPlayer() {
        try {
            ijkMediaPlayer = new IjkMediaPlayer();
//        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on-prepared", 0);
            ijkMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            ijkMediaPlayer.setDataSource("https://rmrbtest-image.peopleapp.com/upload/voice/201809/dee9aad0dcc97520f59d9960074077ad.mp3");
            ijkMediaPlayer.setDataSource("https://read-test.oss-cn-beijing.aliyuncs.com/c4121578-5246-4187-b585-4c1bd3a83dfe.wav");
            ijkMediaPlayer.prepareAsync();
            startTimer();
            playStatus = 1;
            ijkMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(IMediaPlayer mp) {
                    Log.i("Bill", "complete");
                    closeTimer();
                    release();
                    seekBar.setProgress(0);
                }
            });
            ijkMediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(IMediaPlayer mp, int what, int extra) {
                    Log.i("Bill", "error");
                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startTimer() {
        closeTimer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (ijkMediaPlayer == null) {
                    return;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        seekBar.setMax(100);
                        float progress = 0;
                        try {
                            progress = ijkMediaPlayer.getCurrentPosition() * 1.f / ijkMediaPlayer.getDuration();
                        } catch (ArithmeticException e) {
                            e.printStackTrace();
                        }
                        Log.e("Bill", ijkMediaPlayer.getDuration() + "|" + ijkMediaPlayer.getCurrentPosition() + "|" + progress);
                        seekBar.setProgress((int) (progress * 100));
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    private void closeTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }


}
