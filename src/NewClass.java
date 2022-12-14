import java.util.LinkedList;

public class NewClass {
   public int[] twoSums(int[] nuumbers,int target){
         int[] result = new int[2];
         for(int i=0;i<nuumbers.length;i++){
              for(int j=i+1;j<nuumbers.length;j++){
                if(nuumbers[i]+nuumbers[j]==target){
                     result[0]=i;
                     result[1]=j;
                     return result;
                }
              }
         }
         return new int[] {result[0],result[1]};
   }

    public static void main(String[] args) {
//        NewClass n = new NewClass();
//        int[] numbers = {2,7,11,15};
//        int target = 9;
//        int[] result = n.twoSums(numbers,target);
//        System.out.println(result[0]+" "+result[1]);
        LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.remove(2);
        System.out.println(ll);
    }
}
