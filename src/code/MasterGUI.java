package code;

/**
 * Responsavel pela execução da função main, que inicializa todo o programa
 */
public class MasterGUI {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            MainWindow program = new MainWindow(Info.getLongVersion());
            program.go();
        } catch (Exception exceptionValue) {
            printError(exceptionValue.getMessage());
            exceptionValue.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param message
     */
    private static void printError(String message) {
        System.out.println(Info.getShortVersion() + " has found an error and can't go on.\nThe error was: " + message);
    }

}
