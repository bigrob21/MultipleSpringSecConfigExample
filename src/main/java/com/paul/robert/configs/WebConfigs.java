package com.paul.robert.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
	@ComponentScan("com.paul.robert.web.controllers")
})
public class WebConfigs {

}
