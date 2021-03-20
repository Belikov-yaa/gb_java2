import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassLaunchTests {
    public static void start(Class c) {
        List<Method> methodList = new ArrayList<>();
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                methodList.add(method);
            }
        }

        methodList.sort(Comparator.comparingInt((Method i) -> i.getAnnotation(Test.class).priority()).reversed());
        int isMethodFound = 0;
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (isMethodFound == 1) throw new RuntimeException("BeforeSuite must be one");
                methodList.add(0, method);
                isMethodFound++;
            }
        }
        isMethodFound = 0;
        for (Method method : methods) {
            if (method.getAnnotation(AfterSuite.class) != null) {
                if (isMethodFound == 1) throw new RuntimeException("AfterSuite must be one");
                methodList.add(method);
                isMethodFound++;
            }
        }

        for (Method method : methodList) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
