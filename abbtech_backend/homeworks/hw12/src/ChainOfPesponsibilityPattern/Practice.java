package ChainOfPesponsibilityPattern;

public class Practice {
    public static void main(String[] args) {
        // Создаём обработчиков (звенья цепи)
        Handler level1 = new Level1Operator();
        Handler level2 = new Level2Operator();
        Handler supervisor = new Supervisor();
        level1.setNextHandler(level2);
        level2.setNextHandler(supervisor);
        Request easy = new Request(1);   // должен обработать Level1
        Request medium = new Request(2); // должен обработать Level2
        Request hard = new Request(3);   // должен обработать Supervisor
        Request impossible = new Request(10); // никто не сможет обработать
        System.out.println("=== Easy request (1) ===");
        level1.handleRequest(easy);

        System.out.println("\n=== Medium request (2) ===");
        level1.handleRequest(medium);

        System.out.println("\n=== Hard request (3) ===");
        level1.handleRequest(hard);

        System.out.println("\n=== Too hard request (10) ===");
        level1.handleRequest(impossible);
    }
}
