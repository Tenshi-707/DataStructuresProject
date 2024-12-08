package dataStructuresProject;

import java.util.Scanner;
public class ClassManager {
	
	private static int classSize;
	static Scanner input = new Scanner(System.in);
    private static String[] students_names;
    private static int[] students_grades;
	
	public static void main(String[] args) {
		boolean logged_in = true;
		
		// first time logging in message
		System.out.println("Welcome to Data structures & Algorithms class manager!");
		//system log in method
		welcomeMessage();
		
		while (logged_in) {
			int actionSelector = input.nextInt();
			switch(actionSelector) {
				
			 case 1: newClass(); break;
		   	 case 2: existingClass(); break;
			 case 3: logged_in = classLeave(); break;
			}
			if (logged_in) {
				welcomeMessage();
			}
		}
	}
	private static void welcomeMessage() {
		System.out.println("What would you like to do?");
		System.out.println("1- Create a new class");
		System.out.println("2- see existing class");
		System.out.println("3- log out");
		System.out.println("Enter a number from 1 to 3 to select an action");
	}
	
	private static void newClass() {
		System.out.println("Please enter the size of the class");
		classSize = input.nextInt();
		if (classSize <= 0) {
			System.out.println("Invalid class size");
			classSize = input.nextInt();
		}
		students_names = new String[classSize];
		students_grades = new int[classSize];
		System.out.println("Please enter the student names and grades");
		for (int i = 0; i < classSize; i++) {
		    students_names[i] = input.next();
			students_grades[i] = input.nextInt();
		}
		
		System.out.println("What would you like to do?");
		System.out.println("1- sort from lowest to highest");
		System.out.println("2- sort from highest to lowest");
		System.out.println("3- search for a grade");
		System.out.println("4- back");
		
		boolean done = false;
		while(!done) {
			int class_action = input.nextInt();
			switch (class_action) {
			case 1: insertionSort(students_names, students_grades); break;
			case 2: selectionSort(students_names, students_grades); break;
			case 3: System.out.println("Enter the targeted grade");  int target = input.nextInt(); binarySearch(students_names, students_grades, target); break;
			case 4: done = true; break;
			
			default:
				System.out.println("no operations selected");
			}
		}
		
	}
	
	private static void existingClass() {
		classSize = 10;
		students_names = new String[] {"Mark", "Emily", "Julia", "John", "Donald", "Ali", "Ben", "Jane", "Lina", "Khalid"};
		students_grades = new int[] {2, 9, 1, 6, 4, 7, 3, 5, 10, 8};
		for (int i = 0; i < classSize; i++) {
			System.out.println(i+1 + "_ " + students_names[i] + "  " + students_grades[i]);
		}
		
		System.out.println("What would you like to do?");
		System.out.println("1- sort from lowest to highest");
		System.out.println("2- sort from highest to lowest");
		System.out.println("3- search for a grade");
		System.out.println("4- back");
		
		boolean done = false;
		while(!done) {
			int class_action = input.nextInt();
			switch (class_action) {
			case 1: insertionSort(students_names, students_grades); break;
			case 2: selectionSort(students_names, students_grades); break;
			case 3: System.out.println("Enter the targeted grade");  int target = input.nextInt(); binarySearch(students_names, students_grades, target); break;
			case 4: done = true; break;
			
			default:
				System.out.println("no operations selected");
			}
		}
		
	}
	
	
	private static void insertionSort(String[] names, int[] grades) {
		// temp value for swapping
		int gtemp;
		String ntemp;
		
		for (int i = 1; i < grades.length; i++) {
			int j = i;
			gtemp = grades[i];
			ntemp = names[j];
			while (j > 0 && gtemp < grades[j - 1]) {
				grades[j] = grades[j - 1];
				names[j] = names[j - 1];
				j--;
			}
			grades[j] = gtemp;
			names[j] = ntemp;
		}
		for (int i = 0; i < grades.length; i++) {
			System.out.println(i+1 + "_ " + names[i] + "  " + grades[i]);
		}
	}
	
	private static void selectionSort(String[] names, int[] grades) {
		// temp fpr swapping max for maximum value
        int gtemp, gmax;
		String ntemp;
		for (int i = grades.length - 1; i >= 0; i--) {
			gmax = i;
			for (int j = i - 1; j >= 0; j--) {
				if (grades[j] < grades[gmax]) {
					gmax = j;
				}
			}
			gtemp = grades[gmax]; //swapping
			ntemp = names[gmax];
			grades[gmax] = grades[i];
			names[gmax] = names[i];
			grades[i] = gtemp;
			names[i] = ntemp;
			
		}
		for (int i = 0; i < grades.length; i ++) {
			System.out.println(i+1 + "_ " + names[i] + "  " + grades[i]);
		}

	}
	
	private static void bubbleSort(String[] names, int[] grades) {
		int gtemp;
		String ntemp;
		
		for (int i = 0; i < grades.length; i++) {
			for (int j = i + 1; j < grades.length; j++) {
				if (grades[j] < grades[i]) {
					gtemp = grades[i];
					ntemp = names[i];
					grades[i] = grades[j];
					names[i] = names[j];
					grades[j] = gtemp;
					names[j] = ntemp;
				}
			}
		}
	}
	
	private static int binarySearch(String[] names, int[] grades, int key) {
		
		bubbleSort(names, grades);
		
		int lowIndex = 0;
		int highIndex = grades.length - 1;
		
		while (lowIndex <= highIndex) {
			int mid = (lowIndex + highIndex) / 2;
			int midValue = grades[mid];
			if (key == midValue) {
				System.out.println("The grade " + key + " belongs to: " + names[mid]);
				return mid;
			}
			if (key < midValue) {
				highIndex = mid - 1;
			}
			else {
				lowIndex = mid + 1;
			}
			
		}
		System.out.println("The grade does not exist");
		return -1;
	}
	
	private static boolean classLeave() {
		System.out.println("You have successfully logged out");
		System.out.println("Thank you for using class manager!");
		return false;
	}

}
