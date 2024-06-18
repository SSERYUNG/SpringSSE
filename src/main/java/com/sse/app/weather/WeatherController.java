package com.sse.app.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {

	@RequestMapping("/weather/list")
	public String getList() {

		return "weather/list";
	}

}
