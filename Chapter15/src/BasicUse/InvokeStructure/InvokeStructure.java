package BasicUse.InvokeStructure;

import java.lang.reflect.Field;

// 反射技术的基本应用3 --- 调用运行时类的指定结构

public class InvokeStructure {
    public static void main(String[] args)throws Exception {
        //1、获取Student的Class对象
        Class clazz = Class.forName("ClassObject.Person");
        //2、获取属性对象，例如：id属性
        Field idField = clazz.getDeclaredField("ID");
        //3、如果id是私有的等在当前类中不可访问access的，我们需要做如下操作
        idField.setAccessible(true);
        //4、创建实例对象，即，创建Person对象
        Object per = clazz.newInstance();
        //5、获取属性值
        /*
         * 以前：int 变量= Person对象.getId()
         * 现在：Object id属性对象.get(Person对象)
         */
        Object value = idField.get(per);
        System.out.println("id = "+ value);
        //6、设置属性值
        /*
         * 以前：Person对象.setId(值)
         * 现在：id属性对象.set(Person对象,值)
         */
        idField.set(per, 12345);
        value = idField.get(per);
        System.out.println("id = "+ value);
    }
}
