package com.hades.ope;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


public class PlayMusic {

	// 播放方法
	public void play() throws FileNotFoundException, JavaLayerException {
		Player player;
		//打开音乐文件,此处添加本地路径的mp3音乐文件
		String name = "";
		File music = new File(name);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
		player = new Player(buffer);
		player.play();
	}
}
