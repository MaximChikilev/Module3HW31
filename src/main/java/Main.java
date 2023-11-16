import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MySimpleClass msc = new MySimpleClass();
        ClassAnalyzer classAnalyzer = new ClassAnalyzer(msc);
        try {
            Map<Method,Object[]> allMethodsMarkedByAnnotationWithParams = classAnalyzer.getAllMethodsMarkedByAnnotationWithParams(MySimpleAnnotation.class);
            for (Method method:allMethodsMarkedByAnnotationWithParams.keySet()){
                int firstParam = (int)allMethodsMarkedByAnnotationWithParams.get(method)[0];
                int secondParam = (int)allMethodsMarkedByAnnotationWithParams.get(method)[1];
                method.invoke(msc,firstParam,secondParam);
            }
        } catch (InvocationTargetException e) {

        } catch (IllegalAccessException e) {

        }
    }

}
