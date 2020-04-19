package ProjectMaven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Szyfr ROT13 - testy")
class Rot13CipherTest {
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        final Rot13Cipher cipher = new Rot13Cipher();
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecode());
    }
    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"abc:nop", "xyz:klm", "ABC:NOP", "A B C:NOP", "A b C:NoP"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getEncodeStringWhenGivenParamInput2(String entry, String result) {
        final Rot13Cipher cipher = new Rot13Cipher(entry);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(result, encode);
    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"nop:abc", "klm:xyz", "NOP:ABC", "N O P:ABC", "N o P:AbC"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getDecodeStringWhenGivenParamInput2(String entry, String result) {
        final Rot13Cipher cipher = new Rot13Cipher(entry);
        cipher.decode();
        String decoded = cipher.getDecode();
        assertEquals(result, decoded);
    }



}