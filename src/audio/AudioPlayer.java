package audio;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	// Instance variables
	private static AudioPlayer instance;
	private HashMap<String, Clip> audios;
	private float musicVol;
	private float effectVol;
	private String currentMusic;
	
	//---------------------- CONSTRUCTOR -----------------------------
	private AudioPlayer() {
		musicVol = 1.0f;
		effectVol = 1.0f;
		
		audios = new HashMap<String, Clip>();
	}
	
	//-------------------- METHODS ------------------------------------
	public static AudioPlayer get() {
		if (instance == null) instance = new AudioPlayer();
		return instance;
	}

	public void playBackMusic(String s) {
		
	}
	
	public void stopBackMusic() {
		
	}
	
	public void playEffectSound(String s) {
		
	}

	public float getMusicVol() {
		return musicVol;
	}

	public float getEffectVol() {
		return effectVol;
	}

	public void setMusicVol(float musicVol) {
		if (musicVol >= 0 && musicVol <= 1) this.musicVol = musicVol;
	}

	public void setEffectVol(float effectVol) {
		if (effectVol >= 0 && effectVol <= 1) this.effectVol = effectVol;
	}
	
	private Clip getSoundClip(String clipName) {
		if (audios.get(clipName) != null) {
			return audios.get(clipName);
		}
		
		Clip clip = null;
		AudioInputStream audioStream = null;
		
		try {
			audioStream = AudioSystem.getAudioInputStream(getClass().getResource("./" + clipName + ".wav"));
		} catch (UnsupportedAudioFileException UAFE) {
			UAFE.printStackTrace();
		} catch (IOException IOE) {
			IOE.printStackTrace();
		}
		
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException LUE) {
			LUE.printStackTrace();
		}
		
		try {
			clip.open(audioStream);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		
		audios.put(currentMusic, clip);
		return clip;
	}
	
	private void setVolume(Clip c, float f) {
		
	}
}
