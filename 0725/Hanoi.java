
import java.util.Scanner;

class Hanoi {

   static String[] name = {"Ａ軸", "Ｂ軸", "Ｃ軸"};

   static void move(int no, int x, int y) {
      if (no > 1)
         move(no - 1, x, 6 - x - y);

      System.out.println("円盤[" + no + "]を" + name[x - 1] + "から" + name[y - 1] + "へ移動");

      if (no > 1)
         move(no - 1, 6 - x - y, y);
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("ハノイの塔");
      System.out.print("円盤の枚数：");
      int n = stdIn.nextInt();

      move(n, 1, 3);
   }
}


