package ProjectMaven;

public class AtBashCipher implements ICipher{
    private String base;
    private String encoded;
    private String decoded;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz"; //26
    private String alphabet2 = "0123456789";//10

    public AtBashCipher() {
        base = "";
        encoded = "";
        decoded = "";
    }

    public AtBashCipher(String toEncode) {
        base = toEncode;
        encoded = "";
        decoded = "";
    }

    public String getBase() {
        return base;
    }

    public void encode() {
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            Character letter = base.charAt(i);
            if(!Character.isLetter(letter) && !Character.isDigit(letter)) continue;
            if (Character.isLetter(letter)) {
                final boolean isLower = Character.isLowerCase(letter);
                if (!isLower) {
                    letter = Character.toLowerCase(letter);
                }
                final int position = alphabet.indexOf(letter);
                final char c = alphabet.charAt(getEncodedPossition(position));
                tempEncode.append(isLower ? c : Character.toUpperCase(c));
            }
            else if (Character.isDigit(letter)){
                final int position = alphabet2.indexOf(letter);
                final char c = alphabet2.charAt(getEncodedPossition2(position));
                tempEncode.append(c);
            }
        }
        encoded = tempEncode.toString();
    }

    private int getEncodedPossition2(int position) {
        return 9-position;
    }

    int getEncodedPossition(int position) {
        return 25-position;
    }

    public String getEncode() {
        return encoded;
    }

    public String getDecode() {
        return decoded;
    }
    public void setBase(String base) {
        this.base = base;
    }

    public void decode() {
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            Character letter = base.charAt(i);
            if(!Character.isLetter(letter) && !Character.isDigit(letter)) continue;
            if (Character.isLetter(letter)) {
                final boolean isLower = Character.isLowerCase(letter);
                if (!isLower) {
                    letter = Character.toLowerCase(letter);
                }
                final int position = alphabet.indexOf(letter);
                final char c = alphabet.charAt(getEncodedPossition(position));
                tempEncode.append(isLower ? c : Character.toUpperCase(c));
            }
            else if (Character.isDigit(letter)){
                final int position = alphabet2.indexOf(letter);
                final char c = alphabet2.charAt(getEncodedPossition2(position));
                tempEncode.append(c);
            }
        }
        decoded = tempEncode.toString();
    }



    //TODO
    /*
     * przyjmuje tekst do testowania
     * i zwaca zakodowaną wersję
     * przyjmuje zakodowany i zwraca odkodowany
     *
     */
}
