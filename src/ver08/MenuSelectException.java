package ver08;

public class MenuSelectException extends Exception{
	public MenuSelectException() {
		super("1~5사이의 정수만 입력가능합니다.");
	}
}