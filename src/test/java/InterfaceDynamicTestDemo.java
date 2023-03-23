import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public interface InterfaceDynamicTestDemo {

    @TestFactory
    default Stream<DynamicTest> dynamicTestForPalindromes(){
        return Stream.of("mom","madam","level","noon","eye")
                .map(inputText -> DynamicTest.dynamicTest(inputText,() -> assertTrue(isPalindrome(inputText))));
    }

    default boolean isPalindrome(String someText){
        return new StringBuffer(someText).reverse().toString().equals(someText);
    }
}
