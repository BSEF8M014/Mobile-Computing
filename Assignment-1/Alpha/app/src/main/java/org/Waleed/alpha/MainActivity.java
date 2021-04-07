package org.Waleed.alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void NextPage(View view){
        Intent intent=new Intent(this,NavActivity.class);
        startActivity(intent);
    }
    public void Play_Pause(View view){
        if(mp.isPlaying())
            mp.pause();
        else {
            mp = MediaPlayer.create(this, R.raw.dua);
            mp.start();
        }
    }

}