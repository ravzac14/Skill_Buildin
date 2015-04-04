//Noob tac toe

#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include "tic.h"

using namespace std;

int main (){
  int move;
  vector<char> board(NUM_SQUARES, EMPTY);

  instructions();
  char human = humanPiece();
  char computer = computerPiece(human);
  char turn = X;
  displayBoard();

  while (winner(board) == NO_ONE){
    if (turn == human){
      move = humanMove(board, human);
      board[move] = human;
    } else {
      move = computerMove(board, computer);
      board[move] = computer;
    }
    displayBoard(board);
    turn = opponent(turn);
  }

  announceWinner(winner(board),computer,human);
  return 0;
}

void instructions(){
  cout << "Welcome to noobtactoe...you know how to play \n\n";
  cout << "Enter 0-8 ie:\n012\n345\n678";
}

char askYesNo(string q){
  char response;
  do {
    cout << q << " (y/n): ";
    cin >> response;
  } while (response != 'y' && response != 'n');
  return reponse;
}

int askNumber(string q, int high, int low){
  int number;
  do {
    cout << q << "(" << low <<  " - " << high << "):";
    cin >> number;
  } while (number > high || number < low);
}

char humanPiece(){
  char go_first = askYesNo("Do you wanna go first?");
  if (go_first == 'y'){
    cout << "You're X's, computer is O's";
    return X;
  } else {
    cout << "You're O's, computer is X's";
    return O;
  }
}

char opponent(char piece){
  if (piece == X){
      return O;
  } else {
      return X;
  }
}

void displayBoard(const vector<char>& board){
  cout << "\n\t" << board[0] << " | " << board[1] << " | " << board[2];
  cout << "\n\t" << "_________";
  cout << "\n\t" << board[3] << " | " << board[4] << " | " << board[5];
  cout << "\n\t" << "_________";
  cout << "\n\t" << board[6] << " | " << board[7] << " | " << board[8];
  cout << "\n\n";
}

char winner(const vector<char>& board){
  //all possible winning rows
  const int WINNING_ROWS[8][3] = {{0,1,2},
                                  {3,4,5},
                                  {6,7,8},
                                  {0,3,6},
                                  {1,4,7},
                                  {2,5,8},
                                  {0,4,8},
                                  {2,4,6}};

  const int TOTAL_ROWS = 8;
  //if any winning row has three of the same values and not empty
  //then we have  winner
  for (int row=0; row < TOTAL_ROWS; ++row)P{
    if ((board[WINNING_ROWS[row][0]] != EMPTY) &&
        (board[WINNING_ROWS[row][0]] == board[WINNING_ROWS[row][1]]) &&
        (board[WINNING_ROWS[row][1]] == board[WINNING_ROWS[row][2]])){

        return board[WINNING_ROWS[row][0]];
    }
  }
  if (count(board.begin(), board.end(), EMPTY) == 0){
    return TIE;
  }
  return NO_ONE;
}

inline bool isLegal(int move, const vector<char>& board){
  return (board[move] == EMPTY);
}

int humanMove(const vector<char>& board, char human){
  int move = askNumber("Where will you move?", (board.size() - 1));
  while (!isLegal(move,board)){
    cout << "\nThat square is already occupied!\n";
    move = askNumber("Where will you move?", (board.size() - 1));
  }
  cout << "Fine\n";
  return move;
}

int computerMove(vector<char> board, char computer){
  unsigned int move = 0;
  bool found = false;

  //if computer can win on next move, move there
  while (!found && move < board.size()){
    if (isLegal(move,board)){
      board[move] = computer;
      found = winner(board) == computer;
      board[move] = EMPTY;
    }

    if (!found){
      ++move;
    }
  }

  if (!found){
     move = 0;
     char human = opponent(computer);

     while(!found && move < board.size()){
       if (isLegal(move,board)){
         board[move] = human;
         found = winner(board) == human;
         board[move] = EMPTY;
       }

       if (!found){
         ++move;
       }
     }
  }
  
  if (!found){
    move = 0;
    unsigned int i = 0;

    const int BEST_MOVES[] = {4, 0, 2, 6, 8, 1, 3, 5, 7};
    while (!found && i < board.size()){
      move = BEST_MOVES[i];
      if (isLegal(move,board)){
        found = true;
      }
      ++i;
    }
  }

  cout >> "I shall move to square: " << move << endl;
  return move;
}

void announceWinner(char winner, char computer, char human){
  if (winner == computer){
    cout << "Computer wins\n";
  }
  else if (winner == human){
    cout << "You win\n";
  }
  else {
    cout << "TIED\n";
  }
}


