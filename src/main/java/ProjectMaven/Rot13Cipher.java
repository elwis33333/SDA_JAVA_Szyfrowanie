package ProjectMaven;

public class Rot13Cipher extends CesarCipher implements ICipher{
    public Rot13Cipher() {
       super();
    }

    public Rot13Cipher(String toEncode) {
        super(toEncode);
    }
    @Override
    int getEncodedPossition(int position) {
        return (position + 13) % 26;
    }

    @Override
    int getDecodedPossition(int position) {
        return (position + 13) % 26;
    }
}
