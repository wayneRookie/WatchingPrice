package com.hades.ope;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


public class PlayMusic {

	// ���ŷ���
	public void play() throws FileNotFoundException, JavaLayerException {
		Player player;
		//�������ļ�,�˴���ӱ���·����mp3�����ļ�
		String name = "";
		File music = new File(name);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
		player = new Player(buffer);
		player.play();
	}
}
