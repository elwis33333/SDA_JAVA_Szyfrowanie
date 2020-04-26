package ProjectMaven;

public interface ICipher {
    void setBase(String base);
    void encode();
    void decode();
    String getEncode();
    String getDecode();


}
