package com.gis.reproductormusica1;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause;
    MediaPlayer mp;
    int pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Button btn_play;

    public void play( View view)
        {
            if (mp == null) {
            mp= MediaPlayer.create(this,R.raw.liztheme);
            mp.start();
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();}
            else if (!mp.isPlaying()) {
                mp.seekTo(pause);
                mp.start();
                pause = mp.getCurrentPosition();
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
            }
        }


        public void pause(View view)
        { if (mp!=null) {
            mp.pause();
            pause= mp.getCurrentPosition();
            Toast.makeText(this, "Pause", Toast.LENGTH_LONG).show();
            }
        }


        public void stop(View view)
        {
            mp.stop();
            mp=null;
            Toast.makeText(this,"Stop",Toast.LENGTH_LONG).show();
        }

}
