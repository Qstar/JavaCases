package Audio;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MP3Player {

    private String filename;

    private MP3Player(String filename){
        this.filename = filename;
        System.out.println(filename);
    }

    public static void main(String[] args){
        MP3Player mp3 = new MP3Player("/Users/Qstar/spring/helloJava/src/Audio/Maroon 5 - Sugar.mp3");
        mp3.play();

    }

    private void play(){
        try {
            BufferedInputStream buffer = new BufferedInputStream(
                    new FileInputStream(filename));
            Player player = new Player(buffer);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}