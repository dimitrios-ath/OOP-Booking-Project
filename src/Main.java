public class Main {
    /**
     * Creates new MainUI object and calls optionHandlerGUI()
     */
    public static void main(String[] args) {
        MainUI ui = new MainUI();
        ui.setMainUI(ui);
        ui.optionHandlerGUI();
    }
}
