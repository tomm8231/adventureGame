package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlayMusic {

  public void playMusic (String filepath) {
    try
    {
      File musicPath = new File(filepath);

      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
      } else {
        System.out.println("Music error");
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
