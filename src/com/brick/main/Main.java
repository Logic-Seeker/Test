package com.brick.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.brick.frame.LoginScreen;
import com.brick.helper.SplashScreen;

public class Main implements Runnable{
	 private final JFrame frame;
	    public Main(JFrame frm){
	        this.frame=frm;
	    }//constructor closed
	    public void run(){
	        frame.setVisible(true);
	    }//run method closed
	    public static void main(String args[]){
	        new SplashScreen(3000);
	        EventQueue.invokeLater(new Main(new LoginScreen()));
	    }//main method closed


}
