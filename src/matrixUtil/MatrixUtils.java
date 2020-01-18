package matrixUtil;


/**
 * Matrix Utils
 * Contains Useful Matrix Functions
 * By Umesh Giri
 */
public class MatrixUtils<T> {
    private final Integer numberOfRows;
    private final  Integer numberOfCols;
    private boolean[][] visited;
    private final T[][] matrix;

    public MatrixUtils(T[][] matrix) {
        this.matrix = matrix;
        numberOfRows = matrix.length;
        numberOfCols = matrix[0].length;
    }

    /**
     * @param direction
     * @param row
     * @param col
     * @return return true if there's element in given direction
     */
    public boolean isWithInArrayBounds(Direction direction, int row, int col) {
        boolean result = false;
        switch (direction) {
            case UP:
                if (row - 1 > -1 && row - 1 <= numberOfRows - 1)
                    result = true;
                break;
            case DOWN:
                if (row + 1 < numberOfRows)
                    result = true;
                break;
            case RIGHT:
                if (col + 1 < numberOfCols)
                    result = true;
                break;
            case LEFT:
                if (col - 1 > -1 && col - 1 <= numberOfCols - 1)
                    result = true;
                break;
        }
        return result;
    }

    public void makeAllNeighbouringCellVisitedRecursively(int row, int col, T blockContent) {
        if (isWithInArrayBounds(Direction.UP, row, col) && !visited[row - 1][col] && matrix[row - 1][col].equals(blockContent)) {
            visited[row - 1][col] = true;
            makeAllNeighbouringCellVisitedRecursively(row - 1, col, blockContent);
        }
        if (isWithInArrayBounds(Direction.DOWN, row, col) && !visited[row + 1][col] && matrix[row + 1][col].equals(blockContent)) {
            visited[row + 1][col] = true;
            makeAllNeighbouringCellVisitedRecursively(row + 1, col, blockContent);
        }
        if (isWithInArrayBounds(Direction.RIGHT, row, col) && !visited[row][col + 1] && matrix[row][col + 1].equals(blockContent)) {
            visited[row][col + 1] = true;
            makeAllNeighbouringCellVisitedRecursively(row, col + 1, blockContent);

        }
        if (isWithInArrayBounds(Direction.LEFT, row, col) && !visited[row][col - 1] && matrix[row][col - 1].equals(blockContent)) {
            visited[row][col - 1] = true;
            makeAllNeighbouringCellVisitedRecursively(row, col - 1, blockContent);
        }
    }

    public boolean isAnyNeighbouringCellVisited(int row, int col) {
        if (isWithInArrayBounds(Direction.UP, row, col) && visited[row - 1][col])
            return true;
        else if (isWithInArrayBounds(Direction.DOWN, row, col) && visited[row + 1][col])
            return true;
        else if (isWithInArrayBounds(Direction.RIGHT, row, col) && visited[row][col + 1])
            return true;
        else if (isWithInArrayBounds(Direction.LEFT, row, col) && visited[row][col - 1])
            return true;
        else
            return false;
    }

    public int getNumberOfBlocks(T blockContent) {
        int numberOfBlocks = 0;
        visited = new boolean[numberOfRows][numberOfCols];

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                if (!visited[row][col] && matrix[row][col].equals(blockContent)) {
                    numberOfBlocks++;
                    visited[row][col] = true;
                    makeAllNeighbouringCellVisitedRecursively(row, col, blockContent);
                }
            }
        }
        return numberOfBlocks;
    }
}
