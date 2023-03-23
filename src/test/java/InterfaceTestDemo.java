import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceTestDemo implements LifeCycleLoggerTest,InterfaceDynamicTestDemo{
    @Test
    void isEqualValue(){
        assertEquals(9,"I am here".length(),"is always equal");
    }
}
