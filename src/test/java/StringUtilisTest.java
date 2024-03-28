import org.example.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilisTest {

    StringUtils stringUtils = new StringUtils();

    String input;

    @Test
    void testReverseString(){
        input = "AKU";
        Assertions.assertEquals("UKA",stringUtils.reverseString(input));
        System.out.println("Reverse String Normal Input");
    }
    @Test
    void testReverseStringNullInput(){
        input = null;
        Assertions.assertNull(stringUtils.reverseString(input));
        System.out.println("Reverse String Input Null");
    }
    @Test
    void testPalindrome(){
        input = "KATAK";
        Assertions.assertTrue(stringUtils.isPalindrome(input));
        System.out.println("Palindrom Input");
    }
    @Test
    void testNotPalindrome(){
        input = "BAJU";
        Assertions.assertFalse(stringUtils.isPalindrome(input));
        System.out.println("Not Palindrom Input");
    }
    @Test
    void testPalindromeNullInput(){
        input = null;
        Assertions.assertFalse(stringUtils.isPalindrome(input));
        System.out.println("Palindrom Null Input");
    }
    @Test
    void testCountVowels(){
        input = "Aku";
        Assertions.assertEquals(2,stringUtils.countVowels(input));
        System.out.println("Count Vowels Input Normal");
    }
    @Test
    void testCountVowelsNullInput(){
        input = null;
        Assertions.assertEquals(0,stringUtils.countVowels(input));
        System.out.println("Count Vowels Input Null");
    }
    @Test
    void testCountVowelsNoneVowels(){
        input = "ZZZ";
        Assertions.assertEquals(0,stringUtils.countVowels(input));
        System.out.println("Count Vowels None Vowels");
    }
}
