package BasicUse.ReadAnnotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

///////////////////////////////////////////////////////////////////
/////////////////////////  1. 声明自定义注解  ////////////////////////
///////////////////////////////////////////////////////////////////

// 声明自定义注解Table
@Inherited  // 是否被继承
@Target(ElementType.TYPE)  // 使用位置
@Retention(RetentionPolicy.RUNTIME)  // 生命周期(自定义注解只能使用反射的代码读取,所以生命周期必须是RUNTIME)
@interface Table {
    String value();
}

// 声明自定义注解Column
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    String columnName();
    String columnType();
}

///////////////////////////////////////////////////////////////////
////////////////////////  2. 使用自定义注解  /////////////////////////
///////////////////////////////////////////////////////////////////

@Table("t_stu")  // 括号内为String value
class Student {
    @Column(columnName = "sid",columnType = "int")
    private int id;
    @Column(columnName = "sname",columnType = "varchar(20)")
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

///////////////////////////////////////////////////////////////////
//////////////////////  3. 读取和处理自定义注解  //////////////////////
///////////////////////////////////////////////////////////////////

public class ReadAnnotation {
    public static void main(String[] args) {
        Class studentClass = Student.class;
        Table tableAnnotation = (Table) studentClass.getAnnotation(Table.class);
        String tableName = "";
        if (tableAnnotation != null) {
            tableName = tableAnnotation.value();
        }
        Field[] declaredFields = studentClass.getDeclaredFields();
        String[] columns = new String[declaredFields.length];
        int index = 0;
        for (Field declaredField : declaredFields) {
            Column column = declaredField.getAnnotation(Column.class);
            if (column != null) {
                columns[index++] = column.columnName();
            }
        }
        String sql = "select ";
        for (int i = 0; i < index; i++) {
            sql += columns[i];
            if (i < index - 1) {
                sql += ",";
            }
        }
        sql += " from " + tableName;
        System.out.println("sql = " + sql);
    }
}

