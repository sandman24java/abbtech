package AbstractFactoryPattern;

class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac Button");
    }
}