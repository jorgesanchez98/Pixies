package audio;

import java.util.HashMap;

import javax.sound.sampled.Clip;

public class AudioPlayer {
	// Instance variables
	private static AudioPlayer instance;
	private HashMap<K, V> audios;
	private float musicVol;
	private float effectVol;
	private String currentMusic;
	
	//---------------------- CONSTRUCTOR -----------------------------
	private AudioPlayer() {
		musicVol = 1.0f;
		effectVol = 1.0f;
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
	
	private Clip getSoundClip(String s) {
		
	}
	
	private void setVolume(Clip c, float f) {
		
	}
}
