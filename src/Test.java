
import org.apache.logging.log4j.*;

public class Test {
		
	public static Logger demologger = LogManager.getLogger(Test.class.getName());
	
	public static void main(String[] args) {
		
		System.out.println("Test");
		
		demologger.info("click sucess");
		demologger.error("DB connection failed");
		demologger.debug("I am Bug");
		demologger.fatal("I am Fatal :<");
	}

}
