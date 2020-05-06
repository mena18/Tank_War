package test;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


class test{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        /*
        
        //Start In player class
        HashMap<String , AudioPlayer> sfx;
        sfx = new HashMap<String, AudioPlayer>();
        sfx.put("playerjump", new AudioPlayer("/SFX/playerjump.mp3"));
        sfx.put("explode", new AudioPlayer("/SFX/explode.mp3"));
        //Start In player class

        // start Where there is explosion
        sfx.get("explode").play();

         */
    	 
    	
    	
    	String soundName = "res/audio/playerjump.wav";    
    	try {
    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
	    	clip.open(audioInputStream);
	    	clip.start();
	    	Thread.sleep(1000);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	System.out.println("hello world");
    	/*
        AudioPlayer bgmusic;
        bgmusic = new AudioPlayer("audio/around_the_world-atc.wav");
        bgmusic.play();
        /Desktop/Tank Game/Tank War/res/audio
        */
    }
}