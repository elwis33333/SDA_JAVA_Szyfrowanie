package ProjectMaven.tool;

import ProjectMaven.ICipher;

public class NonCipher implements ICipher {
    @Override
    public void setBase(String base) {

    }

    @Override
    public void encode() {

    }

    @Override
    public void decode() {

    }

    @Override
    public String getEncode() {
        return "Not Supported";
    }

    @Override
    public String getDecode() {
        return "Not Supported";
    }
}
