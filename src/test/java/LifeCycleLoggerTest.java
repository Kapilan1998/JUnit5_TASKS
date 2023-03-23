import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public interface LifeCycleLoggerTest {

    static final Logger LOG = Logger.getLogger(TestInstance.Lifecycle.class.getName());

    @BeforeAll
    default void beforeAll(){
        LOG.info("This method runs before all tests");
    }

    @AfterAll
    default void afterAll(){
        LOG.info("This method runs after all tests");
    }

    @BeforeEach
    default void beforeEach(TestInfo testInfo){
        LOG.info(() -> String.format("About to execute [%s]",testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEach(TestInfo testInfo){
        LOG.info(() -> String.format("Finished executing [%s]",testInfo.getDisplayName()));
    }
}
