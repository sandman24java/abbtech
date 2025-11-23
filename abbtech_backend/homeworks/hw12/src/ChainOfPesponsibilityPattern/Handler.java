package ChainOfPesponsibilityPattern;

public interface Handler {
    void setNextHandler(Handler nextHandler); // установить след. обработчика в цепочке
    void handleRequest(Request request); // обработать запрос или передать дальше
}
