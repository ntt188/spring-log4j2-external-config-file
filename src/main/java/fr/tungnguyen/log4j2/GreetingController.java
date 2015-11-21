package fr.tungnguyen.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController implements InitializingBean{

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private static final Logger logger = LogManager.getLogger(GreetingController.class);
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.debug(String.format(template, name));
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("acb");
	}
}
