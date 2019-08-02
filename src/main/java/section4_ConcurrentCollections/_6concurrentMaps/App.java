package section4_ConcurrentCollections._6concurrentMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstWorker implements Runnable {

  private ConcurrentMap<String, Integer> map;

  public FirstWorker(ConcurrentMap<String, Integer> map) {
    this.map = map;
  }

  @Override
  public void run() {
    try {
      map.put("B", 1);
      map.put("H", 2);
      Thread.sleep(1000);
      map.put("F", 3);
      map.put("A", 4);
      Thread.sleep(1000);
      map.put("E", 5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class SecondWorker implements Runnable {

  private ConcurrentMap<String, Integer> map;

  public SecondWorker(ConcurrentMap<String, Integer> map) {
    this.map = map;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(5000);
      System.out.println(map.get("A"));
      Thread.sleep(1000);
      System.out.println(map.get("E"));
      System.out.println(map.get("F"));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
public class App {

  public static void main(String[] args) {
    ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

    new Thread(new FirstWorker(map)).start();
    new Thread(new SecondWorker(map)).start();

    List<String> list = new ArrayList<>();
    List<String> list2 = Collections.synchronizedList(list);
  }
}
