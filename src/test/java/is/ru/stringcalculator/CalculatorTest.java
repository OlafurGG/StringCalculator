package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewlineAsDelimiters(){
    	assertEquals(6, Calculator.add("1,2\n3"));
    	assertEquals(6, Calculator.add("1\n2,3"));
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    @Test
    public void testDelimiterFromStdInput(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    	assertEquals(6, Calculator.add("//\n\n1\n2\n3"));
    	assertEquals(6, Calculator.add("//.\n1.2\n3"));
    }

    @Test
    public void testInputNegativeNumbers() {
    	try {
    		Calculator.add("2,-3,-4");
    	}
    	catch(IllegalArgumentException e) {
    		assertEquals(e.getMessage(), "Negatives not allowed: [-3, -4]");
    	}    	
    }

    @Test
    public void ignoreLargeNumbers() {
    	assertEquals(6, Calculator.add("1,2,3,1001,2000"));
    	assertEquals(1999, Calculator.add("999,1000,1001"));
    }

    @Test
    public void testDelimitersOfAnyLenght() {
    	assertEquals(6, Calculator.add("//[***]\n1**2***3"));
    	//assertEquals(6, Calculator.add("//[***]\n1,2**3"));
    }

}