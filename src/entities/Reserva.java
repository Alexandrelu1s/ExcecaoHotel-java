package entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Exception.ExcecaoDeReserva;

public class Reserva {
	private int numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(int numQuarto, Date checkIn, Date checkOut) {
		if(checkIn.after(checkOut)) {
			throw new ExcecaoDeReserva("Data de checkOut anterior a data de checkIn");
		}
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		if(checkIn.before(this.checkIn)) {
			throw new ExcecaoDeReserva("Nova data de checkIn anterior a antinga.");
		}
		if(checkOut.before(checkIn)) {
			throw new ExcecaoDeReserva("Nova data de checkOut anterior a nova data de checkIn.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return numQuarto + ", CheckIn: " + sdf.format(checkIn) + ", CheckOut: " + sdf.format(checkOut) + ", Duração: " + duracao() + " dias";
	}
}
