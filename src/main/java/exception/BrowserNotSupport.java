package exception;

public class BrowserNotSupport extends IllegalStateException{

	private static final long serialVersionUID = 1L;
	
	public BrowserNotSupport(String browserName) {
		super(String.format("Browser with name: %s is invalid", browserName));
	}
}
