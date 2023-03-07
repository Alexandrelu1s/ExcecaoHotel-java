package Exception;

public class ExcecaoDeReserva extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ExcecaoDeReserva(String msg) {
		super(msg);
	}
}
