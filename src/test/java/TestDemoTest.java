import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TestDemoTest {

	private TestDemo testDemo;
	
	
	
	@BeforeEach
	void setUp() {
	testDemo = new TestDemo();		
}

	@ParameterizedTest
	@MethodSource("TestDemo#argumentsForAdditionTest")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,
			boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		// Given two numbers to Add
		
		if(expectException) {
		assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		else {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		// 
	}
static Stream<Arguments> argumentsForAdditionTest(){

	return Stream.of(
		arguments(2,4,6,false),
		arguments(-1,4,3,true),
		arguments(2,-14,-12,true),
		arguments(0,4,4,true),
		arguments(2,0,2,true)
		
		);
}
}
