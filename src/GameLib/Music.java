package GameLib;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music {

    public Clip clip;

    public Music(File s){

        try {
        	
            AudioInputStream ais = AudioSystem.getAudioInputStream(s.getAbsoluteFile());
            

            AudioFormat baseFormat =ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED ,
                    baseFormat.getSampleRate() ,
                    16 ,
                    baseFormat.getChannels() ,
                    baseFormat.getChannels() *2 ,
                    baseFormat.getSampleRate() ,
                    false
            );

            AudioInputStream dias =
                    AudioSystem.getAudioInputStream(
                            decodeFormat , ais
                    );

            clip = AudioSystem.getClip();
            clip.open(dias);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void play(){
        if(clip == null)return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void loop(){
        if(clip == null)return;
        stop();
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        if(clip.isRunning())clip.stop();
    }


    public void close(){
        stop();
        clip.close();
    }

}