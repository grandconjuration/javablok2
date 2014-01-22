/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;

/**
 *
 * @author jelle
 */
public class Music {
    private static MediaPlayer mediaPlayer;
    
    public static void playMusic(String fileName) {
        String bip = "file:///C:/Users/jelle/Documents/GitHub/javablok2/SpaceInvaders/assets/music/"+fileName;
        Media hit = new Media(bip);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(INDEFINITE);
        mediaPlayer.play();
    }
    
    public static void playTheme() {
        playMusic("theme.mp3");
    }
}
