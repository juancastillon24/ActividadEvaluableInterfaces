import Ui.Main;
import model.DataService;
import model.DataServiceClass;

public class App {
    public static void main(String[] args) {
        DataService ds = new DataServiceClass();
        (new Main(ds)).start();

    }
}
