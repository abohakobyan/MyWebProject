import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class Logging extends Authentication {
	
	protected final static Logger LOGGER = Logger.getLogger(Logger.class.getName());

	public static void logInitiation() throws IOException {
		LogManager.getLogManager().reset();
		LOGGER.setLevel(Level.ALL);
		
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);
		LOGGER.addHandler(ch);
		
		try {
		FileHandler fh = new FileHandler("myLogger.log", true);
		fh.setLevel(Level.INFO);
		LOGGER.addHandler(fh);
		}	catch (java.io.IOException e) {
			LOGGER.log(Level.SEVERE, "File logger not working.", e);
		}
	}
	public static void logStr(String l) {
		LOGGER.log(Level.INFO, l);
	}
}
