package pl.piomin.services.caller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callme")
public class CallmeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CallmeController.class);
	
	@Autowired
	BuildProperties buildProperties;
	
	@GetMapping("/ping")
	public String ping(@RequestHeader(name = "x-version", required = false) String version) {
		LOGGER.info("Ping: name={}, version={}, header={}", buildProperties.getName(), buildProperties.getVersion(), version);
		return buildProperties.getName() + ":" + buildProperties.getVersion() + " with version " + version; 
	}
	
}
