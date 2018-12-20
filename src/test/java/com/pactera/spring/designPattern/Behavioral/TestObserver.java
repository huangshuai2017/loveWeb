package com.pactera.spring.designPattern.Behavioral;

import java.util.Observable;
import java.util.Observer;

public class TestObserver {

	public static void main(String[] args) {
		Observable os  = new MyObservable();
		os.addObserver(new MyObserver());
		os.addObserver(new MyObserver());
		os.addObserver(new MyObserver());
		os.addObserver(new MyObserver());
		os.addObserver(new MyObserver());
		System.out.println(os.hasChanged());
		
		os.notifyObservers();
	}

}
class MyObservable extends Observable{
	
}
class MyObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("iii");
		System.out.println(arg);
	}
	
}