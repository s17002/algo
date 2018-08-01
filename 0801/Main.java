import java.util.Scanner;

class Main {

   static void insertionSort(int[] a, int n) {
      for (int i = 2; i < n; i++) {
         int tmp = a[0] = a[i];
         int j = i;
         for ( ; a[j - 1] > tmp; j--)
            a[j] = a[j - 1];
         if (j > 0) a[j] = tmp;
      }
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("単純挿入ソート");
      System.out.print("要素数：");
      int nx = stdIn.nextInt();
      int[] x = new int[nx + 1];

      for (int i = 1; i <= nx; i++) {
         System.out.print("x[" + i + "]：");
         x[i] = stdIn.nextInt();
      }

      insertionSort(x, nx + 1);

      System.out.println("昇順にソートしました。");
      for (int i = 1; i <= nx; i++)
         System.out.println("x[" + i + "]＝" + x[i]);
   }
}
