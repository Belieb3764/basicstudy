package hellojpa;


public class ValueMain {

    public static void main(String[] args) {

        Integer a = new Integer(10);
        Integer b = a;


        // 이것을 통해서 a값인 10이 복사되어 들어가는것을 확인할 수 있고
        // 출력은 a = 10, b = 20이 되어서 출력됨
//        int a =  10;
//        int b = a;
//
//        a = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
