import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineTest {

    public static void main(String[] args) {

        System.out.println("Script Engine Testing");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

        if (engine == null) {
            System.out.println("Engine NOT available ❌");
        } else {
            System.out.println("Engine is Available");
        }
    }
}