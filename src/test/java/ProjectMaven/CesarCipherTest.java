package ProjectMaven;

import ProjectMaven.CesarCipher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Szyfr Cezara - testy")
class CesarCipherTest {
    public static final String SAMPLE_BASE = "abc";
    public static final String SAMPLE_ENCODE = "def";
    public static final String SAMPLE_BASE2 = "xyz";
    public static final String SAMPLE_ENCODE2 = "abc";

    @DisplayName("When no arg construct then empty encode string and empty decode string")
    @Test
    public void cesarCipherIsCreated() {
        final CesarCipher cipher = new CesarCipher();
        assertNotNull(cipher);
    }

    @Test
    public void emptyArgConstructorReturnEmptyString() {
        final CesarCipher cipher = new CesarCipher();
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecode());
    }
/*
    @Test
    public void passedParamToConstructorReturnParamString() {
        final CesarCipher cipher = new CesarCipher(SAMPLE_BASE);
        assertEquals(SAMPLE_BASE, cipher.getBase());
    }

    @Test
    public void getEncodeStringWhenGivenParamInput() {
        final CesarCipher cipher = new CesarCipher(SAMPLE_BASE);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(SAMPLE_ENCODE, encode);
    }

    @Test
    public void getEncodeStringWhenGivenParamInputFromEndOFAlphabet() {
        final CesarCipher cipher = new CesarCipher(SAMPLE_BASE2);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(SAMPLE_ENCODE2, encode);
    }*/
@DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"abc:def", "xyz:abc", "ABC:DEF", "A B C:DEF"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getEncodeStringWhenGivenParamInput2(String entry, String result) {
        final CesarCipher cipher = new CesarCipher(entry);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(result, encode);
    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"def:abc", "abc:xyz", "DEF:ABC", "A B C:XYZ"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getDecodeStringWhenGivenParamInput2(String entry, String result) {
        final CesarCipher cipher = new CesarCipher(entry);
        cipher.decode();
        String decoded = cipher.getDecode();
        assertEquals(result, decoded);
    }
}