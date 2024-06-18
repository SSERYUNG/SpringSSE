package com.sse.app.weather;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	@Autowired
	private WeatherDAO weatherDAO;

	public List<WeatherDTO> getList() throws Exception {
		ArrayList<WeatherDTO> wd = weatherDAO.getList();
		return wd;

	}

	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;
		}

		return weatherDTO;

	}

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {
		weatherDAO.add(weatherDTO);
	}

	// delete
	public void delete(WeatherDTO weatherDTO) throws Exception {
		weatherDAO.delete(weatherDTO);
	}

	public void update(WeatherDTO weatherDTO) throws Exception {
		weatherDAO.update(weatherDTO);
	}
}
