package ProjectMaven;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CiphersList {
    CESAR("Cesar"),
    ROT13("ROT-13"),
    ATBSH("AtBash"),
    MATRIX("Matrix"),
    SHA256("SHA256"),
    VIGENERE("Vigenere");

    private String cipherName;

    CiphersList(String cipherName){
        this.cipherName=cipherName;
    }
    public static String[] getCiphersList(){
        String[] list = Arrays.stream(CiphersList.values())
                .map(c -> c.cipherName).sorted().toArray(String[]::new);
        return list;
    }
    public static CiphersList getCipher(String cipher){
        cipher = cipher.replaceAll("[^a-zA-Z0-9_]*","").toUpperCase();
        return CiphersList.valueOf(cipher);
    }
}
