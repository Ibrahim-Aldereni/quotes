/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    /////////////////////////////////////////// LAB 08 ///////////////////////////////////////////
    // empty file test
    @Test void testGetOneQuote() {
        String path = "E:\\Coding\\LTUC Course\\401\\quotes\\resources\\empty.json";
        String out = "json is empty";

        assertEquals(out,MyMethods.getOneQuote(path),"test get quotes from json file");
    }

    // happy path test
    @Test void testGetOneQuote2() {
        String path = "E:\\Coding\\LTUC Course\\401\\quotes\\resources\\test.json";
        String out = "Ask no questions, and you'll be told no lies";

        assertEquals(out,MyMethods.getOneQuote(path),"test get quotes from json file");
    }

    //////////////////////////////////////////// lab 09 //////////////////////////////////////
}
