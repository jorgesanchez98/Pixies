

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
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

	public void playMusic(String audioName) {
		Clip clip = getSoundClip(audioName);
		clip.setFramePosition(0);
		setVolume(clip, musicVol);
		clip.start();
		if (currentMusic != null) {
			stopMusic();
		}
		currentMusic = audioName;
	}
	
	public void stopMusic() {
		if (currentMusic != null) {
			Clip clip = audios.get(currentMusic);
			clip.stop();
			currentMusic = null;
		}
	}
	
	public void playEffectSound(String audioName) {
		Clip clip = getSoundClip(audioName);
		clip.setFramePosition(0);
		setVolume(clip, effectVol);
		clip.start();
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
			String route = "music/" + clipName + ".wav";
			System.out.println("File Name is: " + route);
			audioStream = AudioSystem.getAudioInputStream(getClass().getResource(route));
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
	
	private void setVolume(Clip clip, float volume) {
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = range*volume + gainControl.getMinimum();
		gainControl.setValue(gain);
	}
}