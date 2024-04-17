Tic Tac Toe Game

This is a simple implementation of the classic Tic Tac Toe game in Java. The game is played in the console and allows two players to take turns placing their marks ('X' or 'O') on a 3x3 grid. The first player to get three of their marks in a row, column, or diagonal wins the game.

Features
Player vs. Player gameplay.
Simple console-based interface.
Win detection to determine the winner.
Full board detection to declare a draw.

Prerequisites
Java Development Kit (JDK) installed on your system.
How to Run
Clone the repository to your local machine:


git clone https://github.com/yourusername/tic-tac-toe.git
Navigate to the project directory:


cd tic-tac-toe
Compile the Java files:

Copy code
javac TicTacToe.java
Run the compiled program:

Copy code
java TicTacToe
Follow the on-screen instructions to play the game.

Game Instructions
Players take turns placing their marks ('X' or 'O') on the board.
Input the row and column numbers to make a move (e.g., "row[1-3] col[1-3]").
The first player to get three of their marks in a row, column, or diagonal wins.
If all spaces are filled and no player has won, the game is declared a draw.
Example Gameplay
markdown
Copy code
Welcome to Tic Tac Toe!

-------------
| - | - | - | 
-------------
| - | - | - | 
-------------
| - | - | - | 
-------------
Player X, enter your move (row[1-3] col[1-3]):
1 1
-------------
| X | - | - | 
-------------
| - | - | - | 
-------------
| - | - | - | 
-------------
...
License
This project is licensed under the MIT License - see the LICENSE file for details.