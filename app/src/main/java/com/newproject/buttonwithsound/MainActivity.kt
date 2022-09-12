package com.newproject.buttonwithsound

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null
    lateinit var playPauseButton:ImageView
    lateinit var btn1:TextView
    lateinit var btn2:TextView
    lateinit var btn3:TextView
    lateinit var btn4:TextView
    lateinit var btn5:TextView
    lateinit var btn6:TextView
    private var playing:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         btn1 = findViewById(R.id.btn1);
         btn2 = findViewById(R.id.btn2);
         btn3 = findViewById(R.id.btn3);
         btn4 = findViewById(R.id.btn4);
         btn5 = findViewById(R.id.btn5);
         btn6 = findViewById(R.id.btn6);
         playPauseButton = findViewById(R.id.playPauseButton);



        btn1.setOnClickListener(View.OnClickListener {
                startMusic(1)

        })

         btn2.setOnClickListener(View.OnClickListener {

                 startMusic(2)



        })

         btn3.setOnClickListener(View.OnClickListener {

                 startMusic(3)


        })

         btn4.setOnClickListener(View.OnClickListener {
                 startMusic(4)


        })

         btn5.setOnClickListener(View.OnClickListener {

                 startMusic(5)


        })


         btn6.setOnClickListener(View.OnClickListener {

                 startMusic(6)


        })



    }

    private fun startMusic(songNo: Int) {
        if (playing){
            mMediaPlayer!!.reset();
            if (songNo == 1){
                mMediaPlayer = MediaPlayer.create(this, R.raw.note1_c)
            }else if (songNo == 2){
                mMediaPlayer = MediaPlayer.create(this, R.raw.note2_d)
            }else if (songNo == 3){
                mMediaPlayer = MediaPlayer.create(this, R.raw.note3_e)
            }else if (songNo == 4){
                mMediaPlayer = MediaPlayer.create(this, R.raw.note4_f)
            }else if (songNo == 5){
                mMediaPlayer = MediaPlayer.create(this, R.raw.note5_g)
            }else if (songNo == 6){
                mMediaPlayer = MediaPlayer.create(this, R.raw.note6_a)
            }
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            mMediaPlayer!!.setOnCompletionListener(OnCompletionListener { mp ->
                try {
                    stopSound()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            })

           // playPauseButton.visibility = View.VISIBLE
            playing = true
        }else{
            if (mMediaPlayer == null){
                if (songNo == 1){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.note1_c)
                }else if (songNo == 2){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.note2_d)
                }else if (songNo == 3){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.note3_e)
                }else if (songNo == 4){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.note4_f)
                }else if (songNo == 5){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.note5_g)
                }else if (songNo == 6){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.note6_a)
                }
                mMediaPlayer!!.isLooping = false
                mMediaPlayer!!.start()
                mMediaPlayer!!.setOnCompletionListener(OnCompletionListener { mp ->
                    try {
                       stopSound()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                })

                playing = true

            }
        }


    }

    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
      //  playPauseButton.visibility = View.GONE
    }

    //  Stops playback
   private fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null

            playing = false
        }
    }

    // Destroys the MediaPlayer instance when the app is closed

    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            playPauseButton.visibility = View.GONE
            mMediaPlayer = null
        }
    }
}



