package maven_demo;

public class ZeroException extends Exception {
    @Override
    public String getMessage() {
        return "Oups, c'est 0";
    }
}
