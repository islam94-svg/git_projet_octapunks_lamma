package main;

public class Grid {
    private int rows;
    private int columns;
    private int[][] cells;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new int[rows][columns];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = 0; // Initialisation de chaque cellule avec une valeur de 0
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getCell(int row, int column) {
        return cells[row][column];
    }

    public void setCell(int row, int column, int value) {
        cells[row][column] = value;
    }
}