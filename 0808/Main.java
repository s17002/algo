import java.util.Scanner;

class Main {

   static void swap(int[] a, int idx1, int idx2) {
      int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
   }

   static void quickSort(int[] a, int left, int right) {
      int pl = left;
      int pr = right;
      int x = a[(pl + pr) / 2];

      do {
         while (a[pl] < x) pl++;
         while (a[pr] > x) pr--;
         if (pl <= pr)
            swap(a, pl++, pr--);
      } while (pl <= pr);

      if (pr - left < right - pl) {
         int temp;
         temp = left;  left  = pl; pl = temp;
         temp = right; right = pr; pr = temp;
      }
      if (left < pr)  quickSort(a, left, pr);
      if (pl < right) quickSort(a, pl, right);
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.println("クイックソート");
      System.out.print("要素数：");
      int nx = stdIn.nextInt();
      int[] x = new int[nx];

      for (int i = 0; i < nx; i++) {
         System.out.print("x[" + i + "]：");
         x[i] = stdIn.nextInt();
      }

      quickSort(x, 0, nx - 1);

      System.out.println("昇順にソートしました。");
      for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "]＝" + x[i]);
   }
}


