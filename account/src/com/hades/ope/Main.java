package com.hades.ope;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javazoom.jl.player.Player;

public class Main {

	public static void main(String[] args) throws NumberFormatException, Exception {

		System.out.println("输入你的交易价格:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		str = br.readLine();
		double givePrice = Double.valueOf(str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Boolean result = false;
		int count = 0;
		while (!result) {
			try {

				count++;
				CalculateRate cl = new CalculateRate();
				double rate = cl.rate(givePrice);
				System.out.println(sdf.format(new Date()) + "当前利率：" + rate);
				if (rate > 0) {
					PlayMusic pm = new PlayMusic();
					pm.play();
					break;
				}

				if (count == 6307200) {
					result = true;
					break;
				}
				Thread.sleep(1* 1000); // 设置暂停的时间 1秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
