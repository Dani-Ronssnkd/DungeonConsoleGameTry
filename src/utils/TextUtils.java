package utils;

public class TextUtils {
    public static final String doubleEndl = "\n\n";
    public static final int delayNormalText = 75;
    public static final int delayWait = 300;

    public static void printSlowly(String text, int delay){
        for (char character : text.toCharArray()){
            System.out.print(character);
            System.out.flush();
            try {
                Thread.sleep(delay);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void printSlowlyYellow(String text,int delay){
        for (char character : text.toCharArray()){
            System.out.print("\033[33m"+character+"\033[0m");
            System.out.flush();
            try {
                Thread.sleep(delay);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
