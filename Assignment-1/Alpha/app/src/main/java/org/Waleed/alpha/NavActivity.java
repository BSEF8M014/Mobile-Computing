package org.Waleed.alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NavActivity extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        mp=MediaPlayer.create(this,R.raw.dua);
        mp.start();
    }
    public void close(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void sound_1(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s1);
        view.animate().rotationX(360).setDuration(2000);
        mp.start();
    }
    public void sound_2(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s2);
        view.animate().rotationX(360).setDuration(2000);
        mp.start();
    }
    public void sound_3(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s3);
        view.animate().rotationX(360).setDuration(2000);
        mp.start();
    }
    public void sound_4(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s4);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_5(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s5);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_6(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s6);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_7(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s7);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_8(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s8);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_9(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s9);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_10(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s10);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_11(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s11);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_12(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s12);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_13(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s13);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_14(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s14);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_15(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s15);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }
    public void sound_16(View view)
    {
        if(mp.isPlaying())
            mp.pause();
        mp=MediaPlayer.create(this,R.raw.s16);
        mp.start();
        view.animate().rotationX(360).setDuration(2000);
    }

}