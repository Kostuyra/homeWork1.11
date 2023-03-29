import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		taskOne(scanner);
		taskTwo(scanner);
		taskThree(scanner);
		scanner.close();
	}

	public static boolean checkLeapYear(int year) {
		boolean check = false;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			check = true;
		}
		return check;
	}

	public static String checkOsAndYear(int os, int checkYear) {
		int currentYear = LocalDate.now().getYear();
		String message = "";
		if (os == 0) {
			if (checkYear >= currentYear) {
				message = "Установите обычную версию для iOS";
			} else {
				message = "Установите облегченную версию для iOS";
			}
		} else {
			if (checkYear >= currentYear) {
				message = "Установите обычную версию для Android";
			} else {
				message = "Установите облегченную версию для Android";
			}
		}
		return message;
	}
	public static int calculateDeliveryDateToClient(int distance){
		int deliveryDays = 1;
		if (distance > 20){
			deliveryDays ++;
		}
		if (distance > 60){
			deliveryDays ++;
		}
		if (distance > 100){
			deliveryDays ++;
		}
		return deliveryDays;
	}

	static void taskOne(Scanner scanner) {
		System.out.println("Задача 1");
		System.out.println("Введите год");
		int checkYear = scanner.nextInt();
		if (checkLeapYear(checkYear)) {
			System.out.println(checkYear + " год — високосный год");
		} else {
			System.out.println(checkYear + " год — невисокосный год");
		}
	}

	static void taskTwo(Scanner scanner) {
		System.out.println("Задача 2");
		System.out.println("Введите тип опрерационной системы: 0 — iOS, 1 — Android ");
		int checkSystem = scanner.nextInt();

		while (checkSystem < 0 || checkSystem > 1) {
			System.out.println("Введен неверный тип системы. Введите верный тип");
			checkSystem = scanner.nextInt();
		}

		System.out.println("Введите год выпуска");
		int clientDeviceYear = scanner.nextInt();
		System.out.println(checkOsAndYear(checkSystem, clientDeviceYear));
	}
	static void taskThree(Scanner scanner){
		System.out.println("Задача 3");
		System.out.println("Введите целочисленное расстояние до клиента в км");
		int  deliveryDistance = scanner.nextInt();
		int deliveryDays = calculateDeliveryDateToClient(deliveryDistance);

		if (deliveryDays < 4){
			System.out.printf("Доставка займёт %d суток", deliveryDays);
		} else {
			System.out.println("Доставки нет");
		}
	}
}