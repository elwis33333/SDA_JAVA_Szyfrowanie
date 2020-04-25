package ProjectMaven;

public class AtBashCipher {
    private String base;
    private String encoded;
    private String decoded;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

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
            if(!Character.isLetter(letter)) continue;
            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower) {
                letter = Character.toLowerCase(letter);
            }
            final int position = alphabet.indexOf(letter);
            final char c = alphabet.charAt(getEncodedPossition(position));
            tempEncode.append(isLower?c:Character.toUpperCase(c));
        }
        encoded = tempEncode.toString();
    }

    int getEncodedPossition(int position) {
        return (position + 3) % 26;
    }

    public String getEncode() {
        return encoded;
    }

    public String getDecode() {
        return decoded;
    }

    public void decode() {
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            Character letter = base.charAt(i);
            if(!Character.isLetter(letter)) continue;
            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower) {
                letter = Character.toLowerCase(letter);
            }
            final int position = alphabet.indexOf(letter);
            final char c = alphabet.charAt(getDecodedPossition(position));
            tempEncode.append(isLower?c:Character.toUpperCase(c));
        }
        decoded = tempEncode.toString();
    }
    int getDecodedPossition(int position) {
        return (position +23) % 26;
    }


    //TODO
    /*
     * przyjmuje tekst do testowania
     * i zwaca zakodowaną wersję
     * przyjmuje zakodowany i zwraca odkodowany
     *
     */
}
