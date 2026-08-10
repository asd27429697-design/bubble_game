package MyTest.ch02;

public class JumpTest {

    public void jump(Player player) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                player.setUp(true);

                while (player.isUp()) {

                    player.setY(player.getY() - 2);

                    player.setLocation(
                            player.getX(),
                            player.getY()
                    );

                    if (player.getY() < 400) {
                        player.setUp(false);
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (player.getY() < 535) {

                    player.setY(player.getY() + 2);

                    player.setLocation(
                            player.getX(),
                            player.getY()
                    );

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}