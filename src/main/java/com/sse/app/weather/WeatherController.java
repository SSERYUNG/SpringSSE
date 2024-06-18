package com.sse.app.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/list")
	public String getList(HttpServletRequest request) throws Exception {

		List<WeatherDTO> dto = weatherService.getList();
		request.setAttribute("list", dto);
		return "weather/list";
	}

	@RequestMapping("/weather/detail")
	public String getDetail(HttpServletRequest request) {
		String num = request.getParameter("num");
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(num));
		weatherDTO = weatherService.getDetail(weatherDTO);
		request.setAttribute("dto", weatherDTO);
		return "weather/detail";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) throws Exception {
		WeatherDTO weatherDTO = new WeatherDTO();
		String city = request.getParameter("city");
		double gion = Double.parseDouble(request.getParameter("gion"));
		int huminity = Integer.parseInt(request.getParameter("huminity"));
		String status = request.getParameter("status");

		weatherDTO.setCity(city);
		weatherDTO.setGion(gion);
		weatherDTO.setHuminity(huminity);
		weatherDTO.setStatus(status);
		weatherService.add(weatherDTO);
		return "redirect:./list";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.GET)
	public String add2(HttpServletRequest request) {
		return "weather/add";
	}

	@RequestMapping(value = "/weather/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) throws Exception {
		Long num = Long.parseLong(request.getParameter("num"));
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(num);

		weatherService.delete(weatherDTO);
		return "redirect:./list";
	}

	@RequestMapping(value = "/weather/delete", method = RequestMethod.GET)
	public String delete2(HttpServletRequest request) {
		return "redirect:./list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) throws Exception {
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
		String city = request.getParameter("city");
		double gion = Double.parseDouble(request.getParameter("gion"));
		int huminity = Integer.parseInt(request.getParameter("huminity"));
		String status = request.getParameter("status");

		weatherDTO.setCity(city);
		weatherDTO.setGion(gion);
		weatherDTO.setHuminity(huminity);
		weatherDTO.setStatus(status);

		weatherService.update(weatherDTO);
		return "redirect:./list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.GET)
	public String update2(HttpServletRequest request) {
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
		weatherDTO = weatherService.getDetail(weatherDTO);
		request.setAttribute("dto", weatherDTO);
		return "weather/update";
	}

}
