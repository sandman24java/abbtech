package AbstractFactoryPattern;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = "WIN";

        if (os.equals("WIN")) {
            factory = new WinFactory();
        } else {
            factory = new MacFactory();
        }

        // Клиент работает только с абстракциями
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();




    }
}
