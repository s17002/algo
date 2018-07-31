import java.util.Scanner;
class Main{


   static void swap(int[] a, int idx1, int idx2) {
      int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
   }

   static void selectionSort(int[] a, int n) {
      for (int i = 0; i < n - 1; i++) {
         int min = i;
         for (int j = i + 1; j < n; j++)
            if (a[j] < a[min])
               min = j;
         for (int m = 0; m < n; m++)
            System.out.print((m == i) ? "  * " : (m == min) ? "  + " : "    ");
         System.out.println();

         for (int m = 0; m < n; m++)
            System.out.printf("%3d ", a[m]);
         System.out.println("\n");
         swap(a, i, min);
      }
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("単純選択ソート");
      System.out.print("要素数：");
      int nx = stdIn.nextInt();
      int[] x = new int[nx];

      for (int i = 0; i < nx; i++) {
         System.out.print("x[" + i + "]：");
         x[i] = stdIn.nextInt();
      }

      selectionSort(x, nx);

      System.out.println("昇順にソートしました。");
      for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "]＝" + x[i]);
   }
}


