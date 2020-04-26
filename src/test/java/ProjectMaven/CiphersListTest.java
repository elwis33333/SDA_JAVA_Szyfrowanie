package ProjectMaven;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CiphersListTest {

    @Test
    void getCiphersList() {
        //given
        String cipherRequest = "ROT-13";
        CiphersList expectedCipher = CiphersList.ROT13;
        //when
        final CiphersList result = CiphersList.getCipher(cipherRequest);
        //then
        assertThat(result,is(equalTo(expectedCipher))); //hamcrest syntax
        assertEquals(expectedCipher, result);//junit syntax -to samo robią

    }
}