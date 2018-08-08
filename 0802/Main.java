
import java.util.Scanner;

class Main {

   static void insertionSort(int[] a, int n) {
      for (int i = 1; i < n; i++) {
         for (int m = 0; m < n; m++)
            System.out.print((m == i) ? "  * " : "    ");
         System.out.println();
         for (int m = 0; m < n; m++)
            System.out.printf("%3d ", a[m]);
         System.out.println();

         int j;
         int tmp = a[i];
         for (j = i; j > 0 && a[j - 1] > tmp; j--)
            a[j] = a[j - 1];
         a[j] = tmp;
         System.out.printf("a[%d]の%dをa[%d]の位置に挿入しました。\n\n", i, tmp, j);

      }
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("単純挿入ソート");
      System.out.print("要素数：");
      int nx = stdIn.nextInt();
      int[] x = new int[nx];

      for (int i = 0; i < nx; i++) {
         System.out.print("x[" + i + "]：");
         x[i] = stdIn.nextInt();
      }

      insertionSort(x, nx);

      System.out.println("昇順にソートしました。");
      for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "]＝" + x[i]);
   }
}
