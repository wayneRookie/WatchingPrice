package com.hades.ope;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.hades.cla.Market;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NowPrice {

	public String getPrice() throws Exception {

		/*
		 * 因为火币的网站被国内墙了，所以需要科学上网才可以访问并得到这个数据
		 * 下面这6行是用来设置代理通道的，使用的前提是你的win中安装了shadowsock
		 * 并开启了代理
		 * */
		String proxyHost = "127.0.0.1";
		String proxyPort = "1080";
		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", proxyPort);
		System.setProperty("https.proxyHost", proxyHost);
		System.setProperty("https.proxyPort", proxyPort);

		// 网址路径
		String urlStr = "https://www.hbg.com/-/x/general/index/constituent_symbol/detail?r=uz8vrnh5kqp";

		// 链接URL
		URL url = new URL(urlStr);
		// 返回结果集
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		//模拟浏览器，否则会被火币禁止访问
		httpcon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		InputStreamReader input = new InputStreamReader(httpcon.getInputStream(), "utf-8");
		BufferedReader br = new BufferedReader(input);
		StringBuffer document = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) { // 读取每行数据
			document.append(line);
			document.append("\r\n");
		}
		input.close();
		JSONObject json = JSONObject.fromObject(document.toString());
		JSONObject obj = (JSONObject) json.get("data");
		JSONArray arr = (JSONArray) obj.get("symbols");
		//将JSONArray转换为list集合
		List<Market> list = JSONArray.toList(arr, Market.class);
		System.out.println("当前比特币价格为:" + list.get(0).getClose());
		return list.get(0).getClose();
	}

}
