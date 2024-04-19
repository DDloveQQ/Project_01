package TimeApi;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeApiLearn {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.lang.System 和 java.util.Date
    @Test
    public void test1(){
        Date d = new Date();
        System.out.println(d);  // 输出当前精确日期(已重写toString方法)
    }
    @Test
    public void test2(){
        long time = System.currentTimeMillis();
        System.out.println(time);//1559806982971
    //当前系统时间距离1970-1-1 0:0:0 0毫秒的时间差，毫秒为单位
    }
    @Test
    public void test3(){
        Date d = new Date();
        long time = d.getTime();
        System.out.println(time);  // 1712823138233
    }
    @Test
    public void test4(){
        long time = 1559807047979L;
        Date d = new Date(time);  // 将1559807047979L对应的毫秒值转换成当前精确时间
        System.out.println(d);
    }
    @Test
    public void test5(){
        long time = Long.MAX_VALUE;
        Date d = new Date(time);
        System.out.println(d);  // 64位数所能表示的最长时间: Sun Aug 17 15:12:55 CST 292278994
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.text.SimpleDateFormat
    //格式化
    @Test
    public void test6(){
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒 E Z");
        //把Date日期转成字符串，按照指定的格式转
                String str = sf.format(d);
        System.out.println(str);
    }
    //解析
    @Test
    public void test7() throws ParseException {
        String str = "2022年06月06日 16时03分14秒 545毫秒 星期四 +0800";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒 E Z");
                Date d = sf.parse(str);
        System.out.println(d);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.util.Calendar(日历)
    @Test
    public void test8() {
        Calendar c = Calendar.getInstance();  // Calendar 类是一个抽象类, 使用Calendar.getInstance() 方法来获取类的实例
        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" +
                minute);
    }

    @Test
    public void test9() {
        TimeZone t = TimeZone.getTimeZone("America/Los_Angeles");  // 设置时区
        Calendar c = Calendar.getInstance(t);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" +
                minute);
    }

    @Test
    public void test0() {
        Calendar calendar = Calendar.getInstance();
        // 从一个 Calendar 对象中获取 Date 对象
        Date date = calendar.getTime();
        // 使用给定的 Date 设置此 Calendar 的时间
        date = new Date(234234235235L);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println("当前时间日设置为8后,时间是:" + calendar.getTime());
        calendar.add(Calendar.HOUR, 2);
        System.out.println("当前时间加2小时后,时间是:" + calendar.getTime());
        calendar.add(Calendar.MONTH, -2);
        System.out.println("当前日期减2个月后,时间是:" + calendar.getTime());
    }

}
