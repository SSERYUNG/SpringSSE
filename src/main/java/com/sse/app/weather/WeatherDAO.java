package com.sse.app.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAO {

	public ArrayList<WeatherDTO> getList() throws Exception {
		File file = new File("C:\\study", "weather.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<WeatherDTO> wd = new ArrayList<WeatherDTO>();
		while (true) {
			String s = br.readLine(); // 한줄씩 읽자
			if (s == null || s.length() < 4) {
				break;
			}
			String info = s;
			info = info.replace(",", "-");
			StringTokenizer st = new StringTokenizer(info, "-");
			String[] infos = info.split("-");

			WeatherDTO dtos = new WeatherDTO();
			dtos.setNum(Long.parseLong(infos[0].trim()));
			dtos.setCity(infos[1].trim());
			dtos.setGion(Double.parseDouble(infos[2].trim()));
			dtos.setStatus(infos[3].trim());
			dtos.setHuminity(Integer.parseInt(infos[4].trim()));
			wd.add(dtos);
		}

		br.close();
		fr.close();
		return wd;
	}
	// detail 한개를 가지고 옴

	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		ArrayList<WeatherDTO> ar = this.getList();
		WeatherDTO result = null;
		for (WeatherDTO wd : ar) {
			if (wd.getNum() == weatherDTO.getNum()) {
				result = wd;
				break;
			}
		}
		return result;
	}

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {
		// 도시명 기온 상태 습도\n
		StringBuffer stringBuffer = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		stringBuffer.append(ca.getTimeInMillis());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getCity());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getGion());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getStatus());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getHuminity());
		System.out.println(stringBuffer.toString());
		File file = new File("C:/study\\weather.txt");
		FileWriter fw = new FileWriter(file, true);
		//
//			while (true) {
//				if (stringBuffer.equals(null)) {
//					System.out.println("종료합니다");
//					break;
//				} else {
		fw.write(stringBuffer.toString() + "\r\n");
		fw.flush();
		fw.close();

	}

	// delete
	public void delete(WeatherDTO weatherDTO) throws Exception {
		// list를 불러와서 지우려고 하는 num과 일치하는 것을 list에서 삭제하는 방법
		// list를 파일에 다시 저장
		File file = new File("C:/study\\weather.txt");
		ArrayList<WeatherDTO> ar = this.getList();
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(ar.size());
		FileWriter fw = new FileWriter(file, false);
		for (WeatherDTO wd : ar) {
			if (wd.getNum() == weatherDTO.getNum()) {

				continue;
			}
			stringBuffer.append(wd.getNum());
			stringBuffer.append("-");
			stringBuffer.append(wd.getCity());
			stringBuffer.append("-");
			stringBuffer.append(wd.getGion());
			stringBuffer.append("-");
			stringBuffer.append(wd.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(wd.getHuminity());
			fw.write(stringBuffer.toString() + "\r\n");
			fw.flush();

		}
		fw.close();
	}

	// update
	public void update(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getList();
		// add(index, object);
		// set(index,object);
		for (int i = 0; i < ar.size(); i++) {
			if (weatherDTO.getNum() == ar.get(i).getNum()) {
				ar.set(i, weatherDTO);
			}

		}
		File file = new File("C:/study\\weather.txt");
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(ar.size());
		FileWriter fw = new FileWriter(file, false);
		for (WeatherDTO wd : ar) {
			stringBuffer.append(wd.getNum());
			stringBuffer.append("-");
			stringBuffer.append(wd.getCity());
			stringBuffer.append("-");
			stringBuffer.append(wd.getGion());
			stringBuffer.append("-");
			stringBuffer.append(wd.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(wd.getHuminity());
			fw.write(stringBuffer.toString() + "\r\n");
			fw.flush();

		}
		fw.close();
	}
}
