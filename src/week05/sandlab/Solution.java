//package week05.sandlab;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {

  // Add constants for particle types here.
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;

  public static final String[] NAMES = {"Empty", "Metal", "Sand", "Water"};

  // Do not add any more fields as part of Lab 5.
  private int[][] grid;
  private SandDisplayInterface display;
  private RandomGenerator random;

  /**
   * Constructor.
   *
   * @param display The display to use for this run
   * @param random The random number generator to use to pick random points
   */
  public Solution(SandDisplayInterface display, RandomGenerator random) {
    this.display = display;
    this.random = random;
    this.grid = new int[this.display.getNumRows()][this.display.getNumColumns()];
  }

  /**
   * Called when the user clicks on a location.
   *
   * @param row
   * @param col
   * @param tool
   */
  private void locationClicked(int row, int col, int tool) {
    this.grid[row][col] = tool;
  }

  /** Copies each element of grid into the display. */
  public void updateDisplay() {
    // TODO: Populate this method in step 4 and beyond.
    Color metalColor = new Color(128, 128, 128);
    Color emptySquareColor = new Color(0,0,0);
    Color yellowColor = new Color(255, 211, 0);
    Color waterColor = new Color(175, 220, 236);
    for (int row = 0; row < grid.length ; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == 0) {
          display.setColor(row, column, emptySquareColor);
        } else if (grid[row][column] == 1) {
          display.setColor(row, column, metalColor);
        } else if (grid[row][column] == 2){
          display.setColor(row,column,yellowColor);
        } else if (grid[row][column] == 3){
          display.setColor(row,column, waterColor);
        }
      }
    }
  }

  /** Called repeatedly. Causes one random particle to maybe do something. */
  public void step() {
    Point randomPoint = random.getRandomPoint();

    // Check that the random point is from row 0 -> last row -1
    // Checking that the random point is a column on the grid

    if ( randomPoint.row < grid.length && randomPoint.column < grid[0].length) {
      // check if it's sand and the point below is empty
      if (grid[randomPoint.row][randomPoint.column] == 2 && randomPoint.row < grid.length -1 && grid[randomPoint.row+1][randomPoint.column] == 0) {
        grid[randomPoint.row][randomPoint.column] = 0;
        grid[randomPoint.row + 1][randomPoint.column] = 2;
      }
      // check if it's sand and the point below is water
      else if (grid[randomPoint.row][randomPoint.column] == 2 && randomPoint.row < grid.length -1 && grid[randomPoint.row+1][randomPoint.column] == 3) {
        grid[randomPoint.row][randomPoint.column] = 3;
        grid[randomPoint.row + 1][randomPoint.column] = 2;
      }
      // check if it's water
      else if (grid[randomPoint.row][randomPoint.column] == 3) {
        int randomDirection = random.getRandomDirection();

        // if the direction is 0 and point below is empty (0) fall like sand - switch positions
        if (randomDirection == 0 && randomPoint.row < grid.length -1 && grid[randomPoint.row+1][randomPoint.column] == 0 ) {
          grid[randomPoint.row][randomPoint.column] =0;
          grid[randomPoint.row + 1][randomPoint.column] = 3;
        }
        // if the direction is 1 and the point to the right is empty, the water particle moves to the right
        else if (randomDirection == 1 && randomPoint.column < grid[0].length -1 && grid[randomPoint.row][randomPoint.column + 1] == 0) {
          grid[randomPoint.row][randomPoint.column] =0;
          grid[randomPoint.row][randomPoint.column +1] = 3;
        }
        // if the direction is 2 and the point to the left is empty, the water particle moves to the left
        else if (randomDirection == 2 && randomPoint.column > 0 && grid[randomPoint.row][randomPoint.column - 1] == 0) {
          grid[randomPoint.row][randomPoint.column] =0;
          grid[randomPoint.row][randomPoint.column -1] = 3;
        }

      }
    }
  }

  /********************************************************************/
  /********************************************************************/
  /**
   * DO NOT MODIFY
   *
   * <p>The rest of this file is UI and testing infrastructure. Do not modify as part of pre-GDA Lab
   * 5.
   */
  /********************************************************************/
  /********************************************************************/

  private static class Point {
    private int row;
    private int column;

    public Point(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }
  }

  /**
   * Special random number generating class to help get consistent results for testing.
   *
   * <p>Please use getRandomPoint to get an arbitrary point on the grid to evaluate.
   *
   * <p>When dealing with water, please use getRandomDirection.
   */
  public static class RandomGenerator {
    private static Random randomNumberGeneratorForPoints;
    private static Random randomNumberGeneratorForDirections;
    private int numRows;
    private int numCols;

    public RandomGenerator(int seed, int numRows, int numCols) {
      randomNumberGeneratorForPoints = new Random(seed);
      randomNumberGeneratorForDirections = new Random(seed);
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public RandomGenerator(int numRows, int numCols) {
      randomNumberGeneratorForPoints = new Random();
      randomNumberGeneratorForDirections = new Random();
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public Point getRandomPoint() {
      return new Point(
          randomNumberGeneratorForPoints.nextInt(numRows),
          randomNumberGeneratorForPoints.nextInt(numCols));
    }

    /**
     * Method that returns a random direction.
     *
     * @return an int indicating the direction of movement: 0: Indicating the water should attempt
     *     to move down 1: Indicating the water should attempt to move right 2: Indicating the water
     *     should attempt to move left
     */
    public int getRandomDirection() {
      return randomNumberGeneratorForDirections.nextInt(3);
    }
  }

  public static void main(String[] args) {
    // Test mode, read the input, run the simulation and print the result
    Scanner in = new Scanner(System.in);
    int numRows = in.nextInt();
    int numCols = in.nextInt();
    int iterations = in.nextInt();
    Solution lab =
        new Solution(new NullDisplay(numRows, numCols), new RandomGenerator(0, numRows, numCols));
    lab.readGridValues(in);
    lab.runNTimes(iterations);
    lab.printGrid();
  }

  /**
   * Read a grid set up from the input scanner.
   *
   * @param in
   */
  private void readGridValues(Scanner in) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = in.nextInt();
      }
    }
  }

  /** Output the current status of the grid for testing purposes. */
  private void printGrid() {
    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }
  }

  /** Runner that advances the display a determinate number of times. */
  private void runNTimes(int times) {
    for (int i = 0; i < times; i++) {
      runOneTime();
    }
  }

  /** Runner that controls the window until it is closed. */
  public void run() {
    while (true) {
      runOneTime();
    }
  }

  /**
   * Runs one iteration of the display. Note that one iteration may call step repeatedly depending
   * on the speed of the UI.
   */
  private void runOneTime() {
    for (int i = 0; i < display.getSpeed(); i++) {
      step();
    }
    updateDisplay();
    display.repaint();
    display.pause(1); // Wait for redrawing and for mouse
    int[] mouseLoc = display.getMouseLocation();
    if (mouseLoc != null) { // Test if mouse clicked
      locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }

  /**
   * An implementation of the SandDisplayInterface that doesn't display anything. Used for testing.
   */
  static class NullDisplay implements SandDisplayInterface {
    private int numRows;
    private int numCols;

    public NullDisplay(int numRows, int numCols) {
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public void pause(int milliseconds) {}

    public int getNumRows() {
      return numRows;
    }

    public int getNumColumns() {
      return numCols;
    }

    public int[] getMouseLocation() {
      return null;
    }

    public int getTool() {
      return 0;
    }

    public void setColor(int row, int col, Color color) {}

    public int getSpeed() {
      return 1;
    }

    public void repaint() {}
  }

  /** Interface for the UI of the SandLab. */
  public interface SandDisplayInterface {
    public void repaint();

    public void pause(int milliseconds);

    public int[] getMouseLocation();

    public int getNumRows();

    public int getNumColumns();

    public void setColor(int row, int col, Color color);

    public int getSpeed();

    public int getTool();
  }
}
