package ProjectMaven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCipherTest {

    @Test
    public void emptyArgConstructorReturnEmptyString() {
        final MatrixCipher cipher = new MatrixCipher();
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecode());
    }
    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"AlgorytmyiStrukturyDanych:AyStalttungmrryoyuycrikDh", "AlgorytmyiStrukturyDanych   x:Atryh lmuD  gyka  oitn  rSuyx ytrc"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getEncodeStringWhenGivenParamInput2(String entry, String result) {
        final MatrixCipher cipher = new MatrixCipher(entry);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(result, encode);
    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : iput {0} gives result {1}")
    @CsvSource(value = {"AyStalttungmrryoyuycrikDh:AlgorytmyiStrukturyDanych"}, delimiter = ':')
    //domyślnie jest ',' miedzy słowami ale wolno to zastapic delimiterem
    public void getDecodeStringWhenGivenParamInput2(String entry, String result) {
        final MatrixCipher cipher = new MatrixCipher(entry);
        cipher.decode();
        String decoded = cipher.getDecode();
        assertEquals(result, decoded);
    }

}