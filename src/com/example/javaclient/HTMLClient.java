package com.example.javaclient;

import java.io.IOException;
import java.net.UnknownHostException;

import com.example.rockpaperscissorslizardspock.Game;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class HTMLClient extends Client {
	Game game;
	public HTMLClient(int port, String ip, String playerName,Game g) throws UnknownHostException, IOException{
		super(port,ip,playerName);
		this.game=g;
	}
	protected void okToMove() {
		// TODO: call JS function in WebView to enable selecting a move/start timer/etc
		//okToMove=true;
	}
	protected void displayWinner(Integer winner) {
		// TODO: call JS function in WebView to update h1 tag with winner
		//System.out.println(playerNames[winner]+" won!");
		game.runCommand("displayWinner("+winner+")");
	}
	@JavascriptInterface
	public void sendMove(String move){
		super.sendMove(move);
	}
	protected void displayPlayerNames() {
		// TODO: call JS function in WebView to rewrite table with correct number of players and their names.
		
		// concatenate names: setPlayers(['player1','player2',...])
		String cmd="setPlayers([";
		for(int i=0; i<playerNames.length; i++){
			String name=playerNames[i];
			cmd+="'"+name+"',";
		}
		
		// chop trailing comma and close command
		cmd=cmd.substring(0, cmd.length()-1)+"])";
		game.runCommand(cmd);
	}
	protected void displayScores(){
		for(int i=0; i<scores.length; i++){
			game.runCommand("setScoreByPlayerID("+i+","+scores[i]+")");
		}
	}
	protected void displayPlayerMoves(String[] moves) {
		// TODO: call JS function in WebView to display each player's moves
		// concatenate names: setPlayers(['player1','player2',...])
		String cmd="setPlayerMoves([";
		for(int i=0; i<moves.length; i++){
			String move=moves[i];
			cmd+="'"+move+"',";
		}
		
		// chop trailing comma and close command
		cmd=cmd.substring(0, cmd.length()-1)+"])";
		game.runCommand(cmd);
	}
}
