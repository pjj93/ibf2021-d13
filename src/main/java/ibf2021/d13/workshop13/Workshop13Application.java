package ibf2021.d13.workshop13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13Application {
	private static final Logger logger = LoggerFactory.getLogger(Workshop13Application.class);
	public static void main(String[] args) {
		//SpringApplication app = new SpringApplication(Workshop13Application.class);
		SpringApplication.run(Workshop13Application.class, args);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List<String> dirName = null;
		if (!appArgs.containsOption("dataDir")) {
			System.err.println("the option --dataDir is not specified!");
			System.exit(1);
		}
		else if (args.length != 2) {
			System.err.println("incorrect number of arguments specified!");
			System.exit(1);
		}
		else {
			dirName = appArgs.getNonOptionArgs();
			logger.info("filepath is " + dirName.get(0));
		} 

		Path path = Paths.get(dirName.get(0));
		if (!Files.exists(path)) {
			logger.info(path + " does not exist!");
			try { 
				Files.createDirectories(path);
				logger.info("Directory created!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.info(path + " exists!");
		}
	}
}