import java.util.Scanner;

class QuickSortEx1B {

   //--- 配列の要素a[idx1]とa[idx2]を交換 ---//
   static void swap(int[] a, int idx1, int idx2) {
      int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
   }

   //--- クイックソート（非再帰版）---//
   static void quickSort(int[] a, int left, int right) {
      IntStack lstack = new IntStack(right - left + 1);
      IntStack rstack = new IntStack(right - left + 1);

      lstack.push(left);
      rstack.push(right);

      while (lstack.isEmpty() != true) {
         int pl = left  = lstack.pop();      // 左カーソル
         int pr = right = rstack.pop();      // 右カーソル
         int x = a[(left + right) / 2];      // 枢軸は中央の要素

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
         if (left < pr) {
            lstack.push(left);
            rstack.push(pr);
         }
         if (pl < right) {
            lstack.push(pl);
            rstack.push(right);
         }
      }
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

      quickSort(x, 0, nx - 1);         // 配列xをクイックソート

      System.out.println("昇順にソートしました。");
      for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "] = " + x[i]);
   }
}
