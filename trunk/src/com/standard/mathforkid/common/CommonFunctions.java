package com.standard.mathforkid.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.media.MediaPlayer;

import com.standard.mathforkid.R;

public class CommonFunctions {
	public static int getBackground(Context context) {
		String[] backgrounds = context.getResources().getStringArray(
				R.array.background_list);
		int position = randomNumber(backgrounds.length, 0);
		int backgroundImage = context.getResources().getIdentifier(
				backgrounds[position], "drawable", context.getPackageName());
		return backgroundImage;
	}

	public static int randomNumber(int maxNumber, int minNumber) {
		Random random = new Random();
		int result = random.nextInt(maxNumber - minNumber) + minNumber;
		return result;
	}

	public static void shuffleArray(int[] a) {
		int n = a.length;
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(a, i, change);
		}
	}

	private static void swap(int[] a, int i, int change) {
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}

	public static int[] createListPosition() {
		int[] listPosition = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		shuffleArray(listPosition);
		return listPosition;
	}

	public static int getNumberItem(int max, int min, String operation) {
		int firstNumber;
		int secondNumber; 
		if(operation.equals(":") || operation.equals("-")){
			firstNumber = CommonFunctions.randomNumber(max, min + 1);
			secondNumber = CommonFunctions.randomNumber(firstNumber, min);
		}
		else{
			firstNumber = CommonFunctions.randomNumber(max, min);
			secondNumber= CommonFunctions.randomNumber(max, min);
		}
		int result = 0;
		switch (operation) {
		case "+":
			result = firstNumber + secondNumber;
			break;
		case "-":
			result = firstNumber - secondNumber;
			break;
		case "*":
			result = firstNumber * secondNumber;
			break;
		default:
			result = firstNumber / secondNumber;
			break;
		}
		return result;
	}

	public static int getNumberItem(int max, int min){
		int firstNumber = CommonFunctions.randomNumber(max, min);
		int secondNumber = CommonFunctions.randomNumber(max, min);
		int result = firstNumber + secondNumber;
		return result;
	}
	
	public static List<String> listNumber(int level, String operation) {
		int max, min = 1;
		switch (level) {
		case 1:
			max = 7;
			min = 1;
			break;
		case 2:
			max = 10;
			min = 1;
			break;
		case 3:
			max = 20;
			min = 1;
			break;
		case 4:
			max = 30;
			min = 1;
			break;
		case 5:
			max = 40;
			min = 1;
			break;
		case 6:
			max = 50;
			min = 1;
			break;
		default:
			max = 8;
			min = 1;
			break;
		}
		ArrayList<String> listNumber = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			listNumber.add(String.valueOf(getNumberItem(max, min)));
		}
		return listNumber;
	}
	public static int random(int min, int max){
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}
	
	public static int randomEx(int min, int max, int numberEx) {
		Random rand = new Random();
		int random =  rand.nextInt(max - min) + min;
		while(random == numberEx){
			random = rand.nextInt(max - min) + min;
		}
		return random;
	}

	public static int randomEx(int min, int max, ArrayList<Integer> array) {
		Random rand = new Random();
		int random =  rand.nextInt(max - min) + min;
		while(array.contains(random)){
			random = rand.nextInt(max - min) + min;
		}
		return random;
	}
	
	public static int randomInArray(ArrayList<Integer> array, ArrayList<Integer> arrayExeption) {
		array.remove(arrayExeption);
		Random rand = new Random();
		int random =  rand.nextInt(array.size() - 0) + 0;
		while(arrayExeption.contains(random)){
			random =  rand.nextInt(array.size() - 0) + 0;
		}
		return random;
	}
	
	public static void playSound(Context context,String nameResource){
		try {
			if(Constants.mediaPlayer!=null)
			{
				Constants.mediaPlayer.reset();
			}
			Constants.mediaPlayer = MediaPlayer.create(context, context.getResources().getIdentifier(nameResource, "raw", context.getPackageName()));
			Constants.mediaPlayer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
