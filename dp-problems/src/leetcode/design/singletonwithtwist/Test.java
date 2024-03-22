package leetcode.design.singletonwithtwist;

public class Test {

    public static void main(String[] args) {
        SingleTon singleTon = null;
        int i = 1;
        while (i++ <= 10) {
            singleTon = SingleTon.getInstance();
        }

    }
}
