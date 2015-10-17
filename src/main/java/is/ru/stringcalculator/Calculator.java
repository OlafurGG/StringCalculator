package is.ru.stringcalculator;

public class Calculator {
	static String delimiter = "";
	public static int add(String text){
		

		if(text.startsWith("//") && text.charAt(3) == '\n'){
			delimiter = String.valueOf(text.charAt(2));
			text = text.substring(4, text.length());
		}

		if(text.equals("")){
			return 0;
		}		
		else if(text.contains("\n") || text.contains(",") || 
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



}