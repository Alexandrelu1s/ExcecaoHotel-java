package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.ExcecaoDeReserva;
import entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		int num;
		Date checkIn;
		Date checkOut;

		
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Numero do quarto: ");
				num = sc.nextInt();

				System.out.print("CheckIn: ");
				sc.nextLine();
				checkIn = sdf.parse(sc.nextLine());

				System.out.print("CheckOut: ");
				checkOut = sdf.parse(sc.nextLine());

				Reserva r = new Reserva(num, checkIn, checkOut);

				System.out.println(r);

				System.out.println("Atualizaçao da reserva: ");
				System.out.print("CheckIn: ");
				checkIn = sdf.parse(sc.nextLine());

				System.out.print("CheckOut: ");
				checkOut = sdf.parse(sc.nextLine());
				
				r.updateDate(checkIn, checkOut);
				System.out.println(r);
				sc.close();

			} catch (ExcecaoDeReserva er) {
				System.out.println("Erro de entrada: " + er.getMessage());
				
			} catch (InputMismatchException er) {
				System.out.println("Erro de entrada: numero do quarto");
				
			}
			catch(ParseException er) {
				System.out.println("Data incorreta. Data correta (dd/MM/yyyy)");
			}
		

	}

}
