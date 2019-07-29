package section2_MultithreadingTheory;

public class App {

  private static int counter = 0;

  public static synchronized void increment() {
    ++counter;
  }

  public static void process() {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        for(int i = 0; i < 100; i++) {
          increment();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        for(int i = 0; i < 100; i++) {
          increment();
        }
      }
    });

    t1.start();
    t2.start();
  }
}
