package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer { // class that will implement the provided interface

   
    public Collection<Integer> collect(String input) { // collect method that takes string input and return collections of integers

        List<Integer> numbers = new ArrayList<>(); // empty list that will store integers

        for (String s : input.split(",")) {  //use comma to split the inputs and loop through each value
            numbers.add(Integer.parseInt(s.trim())); // add number into the list, convert to integer, and remove spaces
        }

        return numbers; // return complete list
    }

  
    public String summarizeCollection(Collection<Integer> input) { // method that summarizes numbers into ranges and return a string

        List<Integer> numbers = new ArrayList<>(input); // change collection to a list, and give access to indexes

        String result = ""; // empty string that will store final answer

        for (int i = 0; i < numbers.size(); i++) { // loop through all numbers in the list

            int start = numbers.get(i); //stores the current number as the start of the range

            while (i < numbers.size() - 1 && numbers.get(i + 1) == numbers.get(i) + 1) { // checks the following number if it is sequential 
                i++; // moves to the next sequential number
            }

            int end = numbers.get(i); // saves last number in range

            if (start == end) { // checks  if there is only one number
                result += start; //adds single number to result
            } 
              else  // adds the range
            {
                result += start + "-" + end;
            }

            if (i < numbers.size() - 1) { // add commas between integers
                result += ", ";
            }
        }

        return result;  // returns summarized results
    }



    public static void main(String[] args) {

    	NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
    	
    	
    	System.out.println("(1) Provided Example ");// testing example that was provided    
    	String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
    	System.out.println("Sample Input: " + input);

    	String output = summarizer.summarizeCollection(summarizer.collect(input)); // convert input o numbers and summarize range
    	System.out.println("Output: " + output); // print the final result
        
    	
    	System.out.println("\n");//print new line
    	System.out.println("(2) Full Range ");      	
    	String input2 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14";// testing the full range from number 1 to 14  
    	System.out.println("Sample Input 2: " + input2);
    	
    	String output2 = summarizer.summarizeCollection(summarizer.collect(input2));// convert input o numbers and summarize range
    	System.out.println("Output: " + output2);// print the final result
    	
        
    	System.out.println("\n");//print new line
    	System.out.println("(3) Unsorted list of numbers ");       	
    	String input3 = "1,15,3,20,5,6,7,8,30,31,9,18,19,20";// testing unsorted list of numbers
    	System.out.println("Sample Input 3: " + input3);
    	
    	String output3 = summarizer.summarizeCollection(summarizer.collect(input3));// convert input o numbers and summarize range
        System.out.println("Output: " + output3);// print the final result
    	
        
    	System.out.println("\n");//print new line
    	System.out.println("(4) No Range ");       	
    	String input4 = "2,4,6,8,10,12,14,16,18,20,22,24,26,28";// testing list of numbers that are all separated
    	System.out.println("Sample Input 3: " + input4);
    	
    	String output4 = summarizer.summarizeCollection(summarizer.collect(input4));// convert input o numbers and summarize range
        System.out.println("Output: " + output4);// print the final result
    	
    }
    
}
