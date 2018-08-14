import java.util.Scanner;

class Main {

   static void fSort(int[] a, int n, int max) {
      int[] f = new int[max + 1];
      int[] b = new int[n];

      System.out.println("Step 1：度数分布表の作成");
      for (int i = 0; i < n; i++) {
         for (int k = 0; k <= max; k++)
            System.out.printf("%3d", f[k]);
         System.out.println();
         f[a[i]]++;
      }
      for (int k = 0; k <= max; k++)
         System.out.printf("%3d", f[k]);
      System.out.println();

      System.out.println("Step 2：累積度数分布表の作成");
      for (int i = 1; i <= max; i++) {
         for (int k = 0; k <= max; k++)
            System.out.printf("%3d", f[k]);
         System.out.println();
         f[i] += f[i - 1];
      }
      for (int k = 0; k <= max; k++)
         System.out.printf("%3d", f[k]);
      System.out.println();


      System.out.println("Step 3：ソート");
      for (int i = n - 1; i >= 0; i--) {
         for (int k = 0; k < n; k++)
            System.out.printf("%3d", b[k]);
         System.out.println();
         b[--f[a[i]]] = a[i];
      }
      for (int k = 0; k < n; k++)
         System.out.printf("%3d", b[k]);
      System.out.println();

      for (int i = 0;   i < n;i++) a[i] = b[i];
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("度数ソート");
      System.out.print("要素数：");
      int nx = stdIn.nextInt();
      int[] x = new int[nx];

      for (int i = 0; i < nx; i++) {
         do {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
         } while (x[i] < 0);
      }

      int max = x[0];
      for (int i = 1; i < nx; i++)
         if (x[i] > max) max = x[i];

      fSort(x, nx, max);

      System.out.println("昇順にソートしました。");
      for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "]＝" + x[i]);
   }
}
