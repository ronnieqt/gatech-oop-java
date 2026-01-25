public class Park2D 
{
    public static void main(String[] args)
    {
        // double[][] array2d = new double[2][3];
        // array2d[0][0] = 80;
        // array2d[0][1] = 70;
        // array2d[0][2] = 75;
        // array2d[1][0] = 69;
        // array2d[1][1] = 72;
        // array2d[1][2] = 74;
        double[][] array2d = {{80, 70, 75}, {69, 72, 74}};
        final double MIN_TEMP = 75;
        final double MAX_TEMP = 90;
        // row-major traversal
        for (int row = 0; row < array2d.length; ++row) {
            for (int col = 0; col < array2d[row].length; ++col) {
                if ((array2d[row][col] >= MIN_TEMP) && (array2d[row][col] <= MAX_TEMP)) {
                    System.out.println("Go to the park.");
                }
            }
        }
        // column-major traversal
        if (array2d.length > 0) {
            for (int col = 0; col < array2d[0].length; col++) {
                for (int row = 0; row < array2d.length; row++) {
                    if ((array2d[row][col] >= MIN_TEMP) && (array2d[row][col] <= MAX_TEMP)) {
                        System.out.println("Go to the park.");
                    }
                }
            }
        }

        // Ragged Arrays
        // double[][] raggedArray2d = new double[2][];
        // raggedArray2d[0] = new double[3];
        // raggedArray2d[0][0] = 80;
        // raggedArray2d[0][1] = 70;
        // raggedArray2d[0][2] = 75;
        // raggedArray2d[1] = new double[4];
        // raggedArray2d[1][0] = 69;
        // raggedArray2d[1][1] = 72;
        // raggedArray2d[1][2] = 74;
        // raggedArray2d[1][3] = 90;
        double[][] raggedArray2d = { { 80, 70, 75 }, { 69, 72, 74, 90 } };
        System.out.println("Ragged array length 0: " + raggedArray2d[0].length);
        System.out.println("Ragged array length 1: " + raggedArray2d[1].length);
    }
}
