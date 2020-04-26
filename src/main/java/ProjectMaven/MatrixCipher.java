package ProjectMaven;

public class MatrixCipher implements ICipher{
    private String base;
    private String encoded;
    private String decoded;

    public MatrixCipher() {
        base = "";
        encoded = "";
        decoded = "";
    }

    public MatrixCipher(String toEncode) {
        base = toEncode;
        encoded = "";
        decoded = "";
    }

    public String getBase() {
        return base;
    }

    public void encode() {
        int matrixDimension = (int)Math.ceil(Math.sqrt(base.length()));
        char[][] matrix = new char[matrixDimension][matrixDimension];
        int z=0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(z<base.length()) {
                        Character letter = base.charAt(z);
                        matrix[j][i] = letter;
                        z++;
                    }
                    else{
                        matrix[j][i] = ' ';
                    }
                }
            }
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char c = matrix[i][j];
                tempEncode.append(c);
            }
        }
        String result = tempEncode.toString();
        encoded = result;
    }
    public void decode() {
        int matrixDimension = (int)Math.ceil(Math.sqrt(base.length()));
        char[][] matrix = new char[matrixDimension][matrixDimension];
        int z=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(z<base.length()) {
                    Character letter = base.charAt(z);
                    matrix[j][i] = letter;
                    z++;
                }
                else{
                    matrix[j][i] = ' ';
                }
            }
        }
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char c = matrix[i][j];
                tempEncode.append(c);
            }
        }
        String result = tempEncode.toString();
        decoded = result;
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
    //TODO
    /*
     * przyjmuje tekst do testowania
     * i zwaca zakodowaną wersję
     * przyjmuje zakodowany i zwraca odkodowany
     *
     */
}
