package ProjectMaven;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CiphersList {
    CESAR("Cesar"),
    Rot13("ROT-13"),
    ATBSH("AtBash"),
    MATRIX("Matrix");

    private String cipherName;

    CiphersList(String cipherName){
        this.cipherName=cipherName;
    }
    public String[] getCiphersList(){
        String[] list = new String[0];
        Arrays.stream(CiphersList.values())
                .map(c->c.cipherName)
                .collect(Collectors.toList())
                .toArray(list);
        return list;
    }
}
