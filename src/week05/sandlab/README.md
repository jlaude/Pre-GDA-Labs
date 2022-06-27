# Falling Sand Project

For this week's lab, you will implement a physical simulation of particle movement. You will use your mouse to draw particles of different types onto a grid and the particles will behave according to their type.

Through this lab, you will practice skills that have been covered in all the videos that you've watch as well as exploring some skills that were not explicitly covered in the videos including:

Debugging a Java program
Using a random number generator (though most of the code has been written for you)
Using Java's windowing toolkit's Color class
## Step 0: Setting up your workstation
This is the first lab in pre-GDA to include a GUI. In order to be able to experience the corresponding graphics, you need to do your development on a workstation that allows the running of user-implemented programs. Unfortunately, Google-supplied non-Linux laptops do not allow this functionality. This leaves us with two ways to run this program:

A Linux workstation, if you already have one
A virtual machine called Cloudtop
If you do not have a Linux workstation, please follow the instructions on this Techstop article to both request a Cloudtop instance and set up Chrome Remote Desktop on it. The default settings for CPU and memory are fine for our purposes.

Once your instance is created, access it by going to go/crd and clicking on the name of the instance you created (most likely <your username>.c.googlers.com).

You will also need to install an editor to program in. If you already have a favorite editor or IDE, you are welcome to use it. Otherwise, we recommend installing and using VSCode (http://go/vscode/install#glinux) as it is like the IDE you will use in GDA, called Cider. After you install VSCode, you will also need to install the Java debugger. You can do so from within VSCode launching Quick Open (Ctrl+P), pasting the following command, and pressing enter:

ext install vscjava.vscode-java-debug
## Step 1: Getting the starter code running
For the first time, we are giving you some significant starter code to build on for this lab. From your workstation or Cloudtop instance, download the starter code zip file (the easiest way to do this is to open this page in a Chrome session that's running on your workstation rather than your laptop and then click the link above).

Expand it in the directory of your choice, then use the Terminal program to cd into your working directory and compile the starter code by running:

javac SandDisplay.java
You can then run it with the command:

java SandDisplay
This should give your first look at the UI of the app:

The starter UI

The window is composed of:

a grid that is currently blank but that will display the particles that you define
some buttons to select the particle you want to create (current just Empty and Metal)
a slide to adjust the speed of our simulation
You can take a look at the starter code that implements this functionality but don't spend too much time on it, these instructions will guide you to the code you need to edit.

This program is made up of two files:

Solution.java	You will need to modify this file	Handles the mechanics for this particle simulator.
SandDisplay.java	You will not need to modify this file	Handles creating the window with its various widgets and receiving mouse input.
Note that each file contains a main method. The one in SandDisplay runs the simulation with a GUI, the one in Solution.java is text-only and used for testing.

Your work will be in Solution.java which is made up of three sections:

Code you will modify;
The Solution class itself including various methods
Code you will use but not modify
A Point class to represent the coordinate of a point in the grid
The RandomGenerator class to help you add randomness to your simulation
Code that is there for setup and testing and that you will not modify:
The main method that launches the program. It's quite complicated as it supports two modes: when run with no parameters, it creates the GUI that you saw above; when run with an input stream, it runs the simulation without GUI. The GUI-less mode is just used for testing in CodeJam.
The NullDisplay class which simulates the display for testing purposes
Let's focus on the code that you will be working with directly. The Solution class has three members variables:

  private int[][] grid;
  private SandDisplayInterface display;
  private RandomGenerator random;
The grid stores integers representing the type of the particle present in each location, the display used to visually represent the grid and random which will allow you to pick random locations in the grid.

Solution also has some constants used to map integers to particle type that they represent:

  public static final int EMPTY = 0;
  public static final int METAL = 1;
You will add new constants as you define new particle types.

## Step 2: Constructor
The constructor for Solution sets the display and random members to the values that were passed in. The display object has getNumRows and getNumColumns methods. Use those methods to initialize the grid to the same size as the display.

You can make sure that the project compiles and runs but there will be no visible change in the program.

## Step 3: locationClicked
The locationClicked method is called by the starter code whenever the user clicks in the grid. When this happens, store the specified tool value (which is just on particle types constant) in the corresponding location in the grid.

Again, you may compile and run but no visible change will result.

## Step 4: updateDisplay
The updateDisplay method is called at regular intervals by the starter code to update the display with the values stored in the grid. Implement this method so that, whenever it's called, it uses SandDisplay's setColor method to set the right color for every square in the grid. The setColor method looks like this:

void setColor(int row, int col, Color color)
You will need to specify a color for each particle. The Color class is defined as part of java.awt (AbstractWindowToolkit) which is already imported in this file. You can instantiate a Color object by invoking its constructor with some values for red, green and blue.

You should use the color black (0, 0, 0 in RGB) for empty squares and some tone of gray to represent metal.

You can now compile and run and should have a very simple paint program that allows you to paint gray squares on a black background and erase those squares (with the Empty tool).

UI with some metal particles

## Step 5: To see a world in a grain of sand
You can now make the simulation a bit more interesting by adding a new particle type: sand. Sand should be represented by the integer 2 so make sure to define a new constant for it. Also define a new string for it in the NAMES constant which is used to populate the buttons in the UI.

Finally, add some code to updateDisplay to represent sand particles in yellow.

## Step 6: Move it, move it!
To go beyond a painting application, we want the particles to move! Metal particles should always stay where they are but sand particles should fall until they hit a metal particle or the bottom of the grid. To implement this, you need to populate the step function.

Whenever step is called, you should pick a random position within the grid (by calling the getRandomPoint method from the RandomGenerator object). If that position contains sand and the space below is empty, move the sand down by one row.

Note: Do not use a for loop here! The looping is implemented in the run method. A single invocation of step should just attempt to move one particle in one square. The starter code will call step frequently, so that it will appear as if all particles are moving simultaneously.

step is only responsible for updating the grid. You do not need to call updateDisplay or setColor from step.

UI with some metal and sand particles

## Step 7: Make it rain!
Time to add another particle type: water. Go through all the same steps you went through with sand but paint those particles blue.

The behavior of water is a bit different than sand. In the step method, implement the following behavior: when the randomly selected cell contains water, use RandomGenerator to getRandomDirection. If the direction is 0, water falls like sand (unless it would hit sand or metal) but if the direction is 1, the water particle moves to the right (if possible) and if the direction is 2, the water particle moves to the left (if possible).

This means that water will (with time) flow off a horizontal surface of metal or sand.

Test this behavior out in the UI. Make sure that water flows (more or less) realistically.

Before continuing, take a look at your step method and see if you can organize your code to minimize duplication.

UI with some metal and water particles

## Step 8: Where sand and water flowed together
There's one more behavior that you will need to implement to make your simulation a bit more realistic: what happens when sand and water collide?

Water should not flow through sand so a water particle trying to move (horizontally or vertically) through sand should be blocked.

But sand, having a higher density than water, should not float. So you will need to revisit the step method: update your implementation so that if a sand particle is in the selected cell and the space below it is occupied by water, the water and sand particles swap positions.

Test one last time to ensure that water still behaves as expected and that the sand sinks to the bottom of a pool of water.

Take one more look at your step method to see if there are further opportunities to reduce code duplication.


Your work for this lab will be to extend the Falling Sands project that you completed for last week's lab.

WARNING: Unlike previous weeks, you are expected to complete this lab before our live session on Friday. The live session will be an opportunity for you to demo the work that you have done.

You should not have to change SandDisplay.java in order to complete this lab but you are welcome to if you feel up to the challenge.

# Project
  
Your project should implement at least three new features:

* At least one additional material type. Use your imagination but examples might include:
  Wood particles that float on water (but get buried in sand)
  Ice that floats on water but turns into water over time
  Helium balloons that float up

* At least two advanced modeling features. Again, let your imagination guide you but you could imagine:
  Multi-pixel objects that move as a unit (e.g. logs of wood, iceberg)
  Unstable stacks: it doesn't look right for sand to form columns as it does in the basic project. Try forcing those columns to sag as real sand would.
  Allow water to seep sideways through sand
  Allow water to flow under metal objects to avoid this unrealistic situation
  Make solid but moveable particles (like sand) slip if they're on an angled metal surface.
  Implement color variations within a material: not all sand grains are the same tone of yellow. Add support for random color variation in the sand that you pour. Ensure that a grain's color stays the same once it is poured.

