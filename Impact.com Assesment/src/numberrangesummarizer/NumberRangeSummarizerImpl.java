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



    
}
