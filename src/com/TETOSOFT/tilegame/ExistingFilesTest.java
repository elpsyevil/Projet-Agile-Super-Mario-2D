package com.TETOSOFT.tilegame;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ExistingFilesTest {

    @Test
    public void fileExistsTest(){
        File imageFile = new File("D:/ENSIAS/2A/TEST/Projet-Agile-Super-Mario-2D/images/A.png");
        File soundFile = new File("D:/ENSIAS/2A/TEST/Projet-Agile-Super-Mario-2D/Sounds/coin.wav");
        assertTrue("Le fichier n'existe pas",imageFile.exists());
        assertTrue("Le fichier n'existe pas",soundFile.exists());
    }
}