package JsonTest;

/**
 * @author Dhao
 * @date 2018/11/21 19:47
 */
public class Test111 {

    public static void main(String[] args) {

        double i=5;

        int j=0;

        for(;;){
            i=i*0.3;
            j++;
            if(i==0.1){
                System.out.println(j);
                System.out.println("分支1");

            }
        }

    }
}
