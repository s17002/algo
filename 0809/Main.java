
import java.util.Arrays;
import java.util.Comparator;

class Main{

   static class PhyscData {
      String name;
      int    height;
      double vision;

      public PhyscData(String name, int height, double vision) {
         this.name = name;  this.height = height;  this.vision = vision;
      }

      public String toString() {
         return name + " " + height + " " + vision;
      }

      static final Comparator<PhyscData> VISION_RORDER =
                                 new VisionROrderComparator();

      private static class VisionROrderComparator
                              implements Comparator<PhyscData> {
         public int compare(PhyscData d1, PhyscData d2) {
            return (d1.vision < d2.vision) ?  1 :
                   (d1.vision > d2.vision) ? -1 : 0;
         }
      }
   }

   public static void main(String[] args) {
      PhyscData[] x = {
            new PhyscData("赤坂忠雄", 162, 0.3),
            new PhyscData("加藤富明", 173, 0.7),
            new PhyscData("斉藤正二", 175, 2.0),
            new PhyscData("武田信也", 171, 1.5),
            new PhyscData("長浜良一", 168, 0.4),
            new PhyscData("浜田哲明", 174, 1.2),
            new PhyscData("松富明雄", 169, 0.8),
         };

      Arrays.sort(x,
                  PhyscData.VISION_RORDER
                 );

      System.out.println("■ 身体検査一覧表 ■");
      System.out.println(" 氏名      身長 視力");
      System.out.println("--------------------");
      for (int i = 0; i < x.length; i++)
         System.out.printf("%-8s%3d%5.1f\n",
                   x[i].name, x[i].height, x[i].vision);
   }
}
