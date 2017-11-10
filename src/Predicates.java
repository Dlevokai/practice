import java.util.function.Predicate;

public class Predicates {
    public Predicate<Integer> somePredicate(){
        return i -> i>5;
    }

    public static void main(String[] args){
        Integer someNum = 10;

        Predicate<Integer> pred = i -> i>5;
        Predicate<Integer> pred2 = i -> i>5;
        if(pred.and(pred2).test(10)){
          System.out.println("hi")  ;
        }
    }
}
