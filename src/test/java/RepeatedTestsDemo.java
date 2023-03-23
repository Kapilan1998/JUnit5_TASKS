import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTestsDemo {

    private static final Logger logger =Logger.getLogger(RepeatedTestsDemo.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
        int curRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(String.format("Now about to execute repetition %d of %d for %s",curRepetition, totalRepetitions,methodName));
    }

    @RepeatedTest(2)
    void repeatedTest(){

    }

    @RepeatedTest(3)
    void repeatedTestWithRepititionInfo(RepetitionInfo repetitionInfo){
    assertEquals(3, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition)/{totalRepetitions}")
    @DisplayName("RepeatTest")
    void customDisplayName(TestInfo testInfo){
        assertEquals("RepeatTest 1/1", testInfo.getDisplayName());
    }

}
