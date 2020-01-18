import java.lang.*;
import matrixUtil.MatrixUtils;

class BlocksFinder {
    public static void main(String args[]) {
        Object[][] matrix= {{1,0,1,0,0},
                            {1,0,0,0,1}};

        MatrixUtils matrixUtils = new MatrixUtils(matrix);
        int numberOfBlocks = matrixUtils.getNumberOfBlocks(0);
        System.out.println(numberOfBlocks);
    }
}



