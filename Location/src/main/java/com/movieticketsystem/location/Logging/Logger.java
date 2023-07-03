import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Pointcut("within(com.movieticketsystem.location..*)")
    public void applicationPackagePointcut() {
        // Define a pointcut expression to target the package(s) where you want to apply logging
    }
    
    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void logAfterReturning(Object result) {
        logger.info("Returning: {}", result);
        // Modify the logging statement as per your requirements
    }
}
