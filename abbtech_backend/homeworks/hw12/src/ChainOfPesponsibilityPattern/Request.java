package ChainOfPesponsibilityPattern;

public class Request {
    private int difficulty_of_issue;

    public Request(int difficulty_of_issue) {
        this.difficulty_of_issue = difficulty_of_issue;
    }
    public int getDifficulty_of_issue() {
        return difficulty_of_issue;
    }
}