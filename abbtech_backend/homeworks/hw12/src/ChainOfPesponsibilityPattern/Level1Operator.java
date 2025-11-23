package ChainOfPesponsibilityPattern;

public class Level1Operator implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getDifficulty_of_issue()==1) {
            System.out.println("Level 1 operator handled it");
        }
        else if (request !=null){
            System.out.println("Level 1 operator can't handle, forwarding to next...");
            nextHandler.handleRequest(request);
        }
        else {
            System.out.println("No one could handle it ");
        }

    }


}
