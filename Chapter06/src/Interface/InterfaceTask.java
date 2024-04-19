package Interface;

public class InterfaceTask {
}

////////////////////////////////////////////////////////////
// 排除错误 1
interface A_2 {
    int x = 0;
}
class B_2 {
    int x = 1;
}
class C_2 extends B_2 implements A_2 {
    public void pX() {
        System.out.println(A_2.x);
    }
    public static void main(String[] args) {
        new C_2().pX();
    }
}

////////////////////////////////////////////////////////////
// 排除错误 2

interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name;
    }
    public Ball(String name) {
        this.name = name;
    }
    public void play() {
        Ball ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}
class BallTest {
    public static void main(String[] args) {
        Ball ball = new Ball("yoyo");
        ball.play();
    }
}