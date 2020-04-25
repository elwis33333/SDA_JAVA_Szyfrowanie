package ProjectMaven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AtBashCipherTest {

    @Test
    public void emptyArgConstructorReturnEmptyString() {
        final AtBashCipher cipher = new AtBashCipher();
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecode());
    }
    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"abc:zyx", "ZYX:ABC", "0123:9876", "1 2 3:876","a  A  0:zZ9"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getEncodeStringWhenGivenParamInput2(String entry, String result) {
        final AtBashCipher cipher = new AtBashCipher(entry);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(result, encode);
    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"abc:zyx", "ZYX:ABC", "0123:9876", "1 2 3:876"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getDecodeStringWhenGivenParamInput2(String entry, String result) {
        final AtBashCipher cipher = new AtBashCipher(entry);
        cipher.decode();
        String decoded = cipher.getDecode();
        assertEquals(result, decoded);
    }

}