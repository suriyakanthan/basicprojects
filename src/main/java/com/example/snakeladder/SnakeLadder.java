package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize=40, width=10, height=10;

    public static final int buttonLine = height*tileSize + 50, infoLine= buttonLine-30;

    private static Dice dice=new Dice();

    private Player playerOne, playerTwo;

    private Pane createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+100);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile =new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }

        }
        Image img = new Image("C:\\Users\\ADMIN\\SnakeLadder\\src\\main\\istockphoto-531466314-612x612.png");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);

        Button playerOneButton = new Button("Player One");
        Button playerTwoButton = new Button("Player Two");
        Button startButton = new Button("Start");

        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(20);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(300);
        startButton.setTranslateY(buttonLine);
        startButton.setTranslateX(160);

        Label playerOneLabel= new Label("Your Turn P1");
        Label playerTwoLabel= new Label("Your TurnP2");
        Label diceLabel= new Label("Start The Game");

        playerOneLabel.setTranslateY(infoLine);
        playerOneLabel.setTranslateX(20);
        playerTwoLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(300);
        diceLabel.setTranslateY(infoLine);
        diceLabel.setTranslateX(160);

       playerOne = new Player(tileSize, Color.BLACK,"Amit");
       playerTwo = new Player(tileSize-5,Color.WHITE,"Sumit");

        root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,playerOneLabel,playerTwoLabel,diceLabel,playerOne.getCoin(),playerTwo.getCoin());

        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}