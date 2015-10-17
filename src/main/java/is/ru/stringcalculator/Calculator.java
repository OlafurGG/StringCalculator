package is.ru.stringcalculator;

public class Calculator {
	static String delimiter = "";
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		
		if(text.startsWith("//") && text.charAt(3) == '\n'){
			delimiter = String.valueOf(text.charAt(2));
			text = text.substring(4, text.length());
		}
		String[] nums = splitNumbers(text);
		isNegative(nums);
		
		
		if(text.contains("\n") || text.contains(",") || 
			text.contains(delimiter)){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[" + delimiter + ",\n]");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
    
    public static String[] isNegative(String[] numbers) throws IllegalArgumentException {
    	boolean[] negs = new boolean[numbers.length];   	
    	int numberOfNegatives = 0;
    	
    	for (int i = 0; i < numbers.length; i++) {
    		if (toInt(numbers[i]) < 0) {
    			negs[i] = true;
    		}
    	}
    	
    	for (boolean b : negs) {
    		if (b == true)
    			numberOfNegatives++;
    	}
    	
    	String[] negatives = new String[numberOfNegatives];
    	int i = 0;
    	
    	for (String s : numbers) {
    		if (toInt(s) < 0) {
    			negatives[i++] = s;
    		}
    	}
    	
    	if (negatives.length == 0) {
    		//System.out.println("No negatives");
    	}
    	else {
    		String str = "[";
    		
    		for (int j = 0; j < negatives.length; j++) {
    			if (j == negatives.length - 1) {
    				str += negatives[j] + "]";
    			}
    			else {
    				str += negatives[j] + ", ";
    			}
    		}
    		throw new IllegalArgumentException("Negatives not allowed: " + str);
    	}
    	//throw new IllegalArgumentException();
    	//System.out.println();
    	return numbers;
    }

    public static void main(String args[]) {
    	Calculator.add("3,6,8,-2");
    }

}