package ru.solodkov.javacore;

public class App
{
    public static void main( String[] args )
    {
        int check = 0;
        String[][] matrix = new String[4][4];

        matrix[0][0] = "10";
        matrix[0][1] = "12";
        matrix[0][2] = "33";
        matrix[0][3] = "13";
        matrix[1][0] = "21";
        matrix[1][1] = "15";
        matrix[1][2] = "27";
        matrix[1][3] = "16";
        matrix[2][0] = "22";
        matrix[2][1] = "23";
        matrix[2][2] = "37";
        matrix[2][3] = "34";
        matrix[3][0] = "24";
        matrix[3][1] = "17";
        matrix[3][2] = "27";
        matrix[3][3] = "37";

        try {
            check = checkMatrix(matrix);
        } catch (MyArraySizeExeption e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println(check);
    }

    public static int checkMatrix(String[][] matrix){
        int check = 0;
        if(matrix.length != 4) throw new MyArraySizeExeption();
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != 4) throw new MyArraySizeExeption();
            for(int j = 0; j < matrix[0].length; j++) {
                try {
                    check += Integer.parseInt(matrix[i][j]);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return check;
    }
}
