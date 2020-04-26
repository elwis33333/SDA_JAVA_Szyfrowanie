package ProjectMaven.tool;

import ProjectMaven.*;

public class CipherFactory {
    static ICipher getAlgorithm(String cipher){
        switch (cipher.toUpperCase()){
            case "CESAR": return new CesarCipher();
            case "ROT-13": return new Rot13Cipher();
            case "MATRIX": return new MatrixCipher();
            case "ATBASH": return new AtBashCipher();
            default: return new NonCipher();

        }
    }
}
