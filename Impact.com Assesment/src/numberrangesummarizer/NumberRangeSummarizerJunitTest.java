package numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberRangeSummarizerJunitTest {

    NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void testProvidedExample() {

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";  //variable to store test data

        String result = summarizer.summarizeCollection(summarizer.collect(input)); //convert string to numbers, and take list and group sequential numbers to ranges, and store the summarized output

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result); // check if expected output matches the actual output
    }

    @Test
    void testFullRange() {

        String input ="1,2,3,4,5,6,7,8,9,10,11,12,13,14"; //variable to store test data

        String result = summarizer.summarizeCollection( summarizer.collect(input));//convert string to numbers, and take list and group sequential numbers to ranges, and store the summarized output

        assertEquals("1-14",result);// check if expected output matches the actual output
    }

    @Test
    void testUnsortedNumbers() {

        String input ="1,15,3,20,5,6,7,8,30,31,9,18,19,20";//variable to store test data

        String result = summarizer.summarizeCollection(summarizer.collect(input));//convert string to numbers, and take list and group sequential numbers to ranges, and store the summarized output

        assertEquals("1, 3, 5-9, 15, 18-20, 20, 30-31", result);// check if expected output matches the actual output
    }

    @Test
    void testNoRange() {

        String input ="2,4,6,8,10,12,14,16,18,20,22,24,26,28"; //variable to store test data

        String result = summarizer.summarizeCollection(summarizer.collect(input));//convert string to numbers, and take list and group sequential numbers to ranges, and store the summarized output

        assertEquals("2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28", result);// check if expected output matches the actual output
    }
}