import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassAnalyzer {
    private Object instance;
    private Method[] methods;
    private Map<Method, Object[]> allAnnotatedMethodsWithParams;

    public ClassAnalyzer(Object instance) {
        this.instance = instance;
        methods = instance.getClass().getMethods();
    }

    public Map<Method,Object[]> getAllMethodsMarkedByAnnotationWithParams(Class annotationClass) throws InvocationTargetException, IllegalAccessException {
        allAnnotatedMethodsWithParams = new HashMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                Object[] methodParams = getParamsFromAnnotation(method, method.getAnnotation(annotationClass).toString());
                allAnnotatedMethodsWithParams.put(method, methodParams);
            }
        }
        return allAnnotatedMethodsWithParams;
    }

    private Object[] getParamsFromAnnotation(Method method, String annotationsParams) {
        String extractedAllParams = extractAllParamsFromLine(annotationsParams);
        String[] params = extractedAllParams.split(", ");
        Object[] paramsInt = separateEachParam(params);
        return paramsInt;
    }

    private String extractAllParamsFromLine(String line) {
        int openingParenthesisIndex = line.indexOf("(");
        int closingParenthesisIndex = line.indexOf(")");
        return line.substring(openingParenthesisIndex + 1, closingParenthesisIndex);
    }

    private Object[] separateEachParam(String[] allParams) {
        Object[] separatedParams = new Object[allParams.length];
        int i = 0;
        for (String element : allParams) {
            String[] temp = element.split("=");
            separatedParams[i] = Integer.valueOf(temp[1]);
            i++;
        }
        return separatedParams;
    }
}
