package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.print("CheckIn date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CheckOut date: ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Inconsistency into dates");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter dates to update");
			System.out.print("CheckIn date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date: ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in Reservation: " + error + " in reservation: " + sdf.format(checkIn) + " , " + sdf.format(checkOut));
			} else {
				System.out.println("Reservation: " + reservation);

			}
		}

		sc.close();
	}
}
