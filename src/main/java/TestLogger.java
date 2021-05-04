import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestLogger {
    public static void main(String[] args) {
        log.info("Info");
        log.warn("Warn");
        log.fatal("Fatal");
        log.error("Error");
        log.debug("Debug");
    }
}
