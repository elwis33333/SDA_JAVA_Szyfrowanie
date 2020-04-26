package ProjectMaven.tool;

import ProjectMaven.*;

public class CipherFactory {
    static ICipher getAlgorithm(String cipher){
        CiphersList algorithm =CiphersList.getCipher(cipher);
        switch (algorithm){
            case CESAR: return new CesarCipher();
            case ROT13: return new Rot13Cipher();
            case MATRIX: return new MatrixCipher();
            case ATBSH: return new AtBashCipher();
            case SHA256:;
            case VIGENERE:;
            default: return new NonCipher();

        }
    }
}
