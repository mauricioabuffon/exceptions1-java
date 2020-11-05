package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.print("CheckIn date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date: ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter dates to update");
			System.out.print("CheckIn date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date: ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Run time erro: " + e.getMessage());
		}
		sc.close();
	}
}
