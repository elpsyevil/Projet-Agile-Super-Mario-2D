package com.TETOSOFT.tilegame;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class SoundTest {
    
    @Test
    public void soundTest(){
        Sounds music=new Sounds("D:/ENSIAS/2A/TEST/Projet-Agile-Super-Mario-2D/Sounds/music.wav");
        music.playSound();
        assertTrue("Not playing",music.isRunning());
    }
}