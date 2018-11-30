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
		 * ��Ϊ��ҵ���վ������ǽ�ˣ�������Ҫ��ѧ�����ſ��Է��ʲ��õ��������
		 * ������6�����������ô���ͨ���ģ�ʹ�õ�ǰ�������win�а�װ��shadowsock
		 * �������˴���
		 * */
		String proxyHost = "127.0.0.1";
		String proxyPort = "1080";
		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", proxyPort);
		System.setProperty("https.proxyHost", proxyHost);
		System.setProperty("https.proxyPort", proxyPort);

		// ��ַ·��
		String urlStr = "https://www.hbg.com/-/x/general/index/constituent_symbol/detail?r=uz8vrnh5kqp";

		// ����URL
		URL url = new URL(urlStr);
		// ���ؽ����
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		//ģ�������������ᱻ��ҽ�ֹ����
		httpcon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		InputStreamReader input = new InputStreamReader(httpcon.getInputStream(), "utf-8");
		BufferedReader br = new BufferedReader(input);
		StringBuffer document = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) { // ��ȡÿ������
			document.append(line);
			document.append("\r\n");
		}
		input.close();
		JSONObject json = JSONObject.fromObject(document.toString());
		JSONObject obj = (JSONObject) json.get("data");
		JSONArray arr = (JSONArray) obj.get("symbols");
		//��JSONArrayת��Ϊlist����
		List<Market> list = JSONArray.toList(arr, Market.class);
		System.out.println("��ǰ���رҼ۸�Ϊ:" + list.get(0).getClose());
		return list.get(0).getClose();
	}

}
