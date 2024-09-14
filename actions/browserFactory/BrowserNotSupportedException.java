package browserFactory;

public class BrowserNotSupportedException extends IllegalStateException{

    public BrowserNotSupportedException (String browser) {
        super(String.format("Browser %s is not supported", browser));
    }
}
