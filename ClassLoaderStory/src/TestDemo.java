import java.net.URL;
import java.net.URLClassLoader;

import com.roy.SalaryCaler;
import com.roy.SalaryClassLoader;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-01-09
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        Double salary = 2000.00;
        Double money;
        SalaryClassLoader salaryClassLoader =
                new SalaryClassLoader("E:\\workspace-eclipse2\\SalaryCaler\\bin\\");
        while (true) {
            money = calSalary(salary, salaryClassLoader);
            System.out.println("到手工资：" + money);
            Thread.sleep(1000);
        }
    }

    private static Double calSalary(Double salary,ClassLoader classloader) throws Exception {
       Class<?> clazz = classloader.loadClass("com.roy.SalaryCaler");
        if (null != clazz) {
            Object object = clazz.newInstance();
            return (Double) clazz.getMethod("cal", Double.class).invoke(object, salary);
        }
        return -1.00;
    }
}
