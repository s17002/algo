import java.util.Scanner;

class ShellSort2 {

   static int shellSort(int[] a, int n) {
      int count = 0;
      int h;
      for (h = 1; h < n / 9; h = h * 3 + 1)
         ;

      for ( ; h > 0; h /= 3)
         for (int i = h; i < n; i++) {
            int j;
            int tmp = a[i];
            for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
               a[j + h] = a[j];
               count++;
            }
            a[j + h] = tmp;
            count++;
         }
      return count;
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("シェルソート");
      System.out.print("要素数：");
      int nx = stdIn.nextInt();
      int[] x = new int[nx];

      for (int i = 0; i < nx; i++) {
         System.out.print("x[" + i + "]：");
         x[i] = stdIn.nextInt();
      }

      int count = shellSort(x, nx);

      System.out.println("昇順にソートしました。");
      for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "]＝" + x[i]);
      System.out.println("要素の移動回数は" + count + "回でした。");
   }
}


