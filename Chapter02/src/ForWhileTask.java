public class ForWhileTask {
    public static void main(String[] args) {
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}

class ForWhileTask02 {
    public static void main(String[] args) {
        for (int i = 0; i < 24; i++){
            for (int j = 0; j < 60 ; j++) {
                System.out.println(i + "时" + j + "分");
            }
        }
    }
}
