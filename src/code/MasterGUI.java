package code;

public class MasterGUI
   {
   public static void main(String[] args)
      {
      try
         {
         Interface mylayout = new Interface ("Interface");
         mylayout.setMainPainel();
         mylayout.setVisible(true);
         }
      catch (Exception exceptionValue)
         {
         printError(exceptionValue.getMessage());
         exceptionValue.printStackTrace();
         System.exit(1);
         }
      }

   private static void printError(String message)
      {
      System.out.println(Info.getShortVersion() + " has found an error and can't go on.\nThe error was: " + message);
      }

   }
