package tests;

import matrixUtil.Direction;
import matrixUtil.MatrixUtils;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {

    String[][] matrix= {{"1","0","1","0","0"},
                         {"1","0","0","0","1"}};
    MatrixUtils matrixUtils = new MatrixUtils(matrix);


    int numberOfExpectedBlocksOf1 = 3;
    int numberOfExpectedBlocksOf0 = 1;

    @org.junit.jupiter.api.Test
    void isWithInArrayBounds() {
        assertEquals(false, matrixUtils.isWithInArrayBounds(Direction.UP,0,0));
        assertEquals(true, matrixUtils.isWithInArrayBounds(Direction.RIGHT,0,0));
    }

    @org.junit.jupiter.api.Test
    void getNumberOfBlocks() {
        assertEquals(numberOfExpectedBlocksOf0, matrixUtils.getNumberOfBlocks("0"));
        assertEquals(numberOfExpectedBlocksOf1, matrixUtils.getNumberOfBlocks("1"));
    }
}