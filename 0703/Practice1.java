import java.util.Scanner;

public class Practice1 {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n;

    System.out.println("正方形を表示します。");

    do {
      System.out.println("段数は;");
      n = stdIn.nextInt();
    } while (n <= 0);

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++)
        System.out.print('*');
      System.out.println();
    }
  }
}
