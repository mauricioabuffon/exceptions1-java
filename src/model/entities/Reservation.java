package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
		super();
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Inconsistency into dates checkOut checkIn");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut)  {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error - reservation dates need to be after actual");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Inconsistency into dates checkOut checkIn");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String toString() {
		return "Room " + roomNumber + ", checkIn: " + sdf.format(checkIn) + " checkOut: " + sdf.format(checkOut) + ", "
				+ duration() + " nights";
	}

}
