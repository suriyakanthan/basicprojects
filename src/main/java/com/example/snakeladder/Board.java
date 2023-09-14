package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinates;


    public Board()
    {
        positionCoordinates = new ArrayList<>();
        populatePositionCoordinates();
    }
    private void populatePositionCoordinates(){
     positionCoordinates.add(new Pair<>(0,0));
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                int xCord = 0;
                if(i%2==0)
                {
                    xCord=j*SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                }
                else {
                    xCord = SnakeLadder.tileSize * SnakeLadder.height - (j * SnakeLadder.tileSize) - SnakeLadder.tileSize / 2;
                }
                int yCord= SnakeLadder.tileSize* SnakeLadder.height-(i*SnakeLadder.tileSize)-SnakeLadder.tileSize/2;
                positionCoordinates.add(new Pair<>(xCord,yCord));

            }

        }

    }

    int getXCoordinate(int position)
    {
        if(position>=1 && position<=100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }

    int getYCoordinate(int position)
    {
        if(position>=1 && position<=100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }
    public static void main(String[] args){
        Board board = new Board();
        for (int i = 0; i < board.positionCoordinates.size(); i++) {
            System.out.println(i+"$ x:"+board.positionCoordinates.get(i).getKey()+"y:"+board.positionCoordinates.get(i).getValue());

        }
    }
}
