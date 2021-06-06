/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TETOSOFT.tilegame;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author ThinkPad
 */
public class Sounds {
    private Clip clip;


   public Sounds(String filepath){
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(filepath));
            clip = AudioSystem.getClip();
            clip.open(audio);

        } catch (Exception e){
            System.out.println("check "+filepath+"\n");
            e.printStackTrace();
        }
   }

    public Sounds() {
    }

    public  void playSound(){
        clip.setFramePosition(0);
        clip.start();

    }

    public  void loop(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public  void stopSound(){

        clip.stop();
        //clip.close();

    }
}