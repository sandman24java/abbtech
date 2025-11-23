package ChainOfPesponsibilityPattern;

public class Supervisor implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getDifficulty_of_issue() == 3) {
            System.out.println("Supervisor handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);   // но next = null → сюда не зайдём
        } else {
            System.out.println("No one could handle the request.");
        }

    }
}