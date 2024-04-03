package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.NumberGreaterRangeMaxException;
import telran.exceptions.NumberLessRangeMinException;
import telran.exceptions.RangeExceptions;

class RangeExceptionsTests {

	@Test
	void factoryMethodTest() {
		assertThrowsExactly(IllegalArgumentException.class, () -> RangeExceptions.getRangeExceptions(30, 3));
		assertThrowsExactly(IllegalArgumentException.class, () -> RangeExceptions.getRangeExceptions(30, 30));
		assertNotNull(RangeExceptions.getRangeExceptions(3, 30));
	}
	
	@Test
	void checkNumberTest() throws NumberGreaterRangeMaxException, NumberLessRangeMinException {
		RangeExceptions range = RangeExceptions.getRangeExceptions(3, 30);
		assertThrowsExactly(NumberGreaterRangeMaxException.class, () -> range.checkNumber(40));
		assertThrowsExactly(NumberLessRangeMinException.class, () -> range.checkNumber(2));
		range.checkNumber(5);
	}

}
