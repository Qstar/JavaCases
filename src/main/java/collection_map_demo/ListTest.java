package collection_map_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    private List<Course> coursesToSelect;

    private ListTest(){
        this.coursesToSelect = new ArrayList<>();
    }

    public static void main(String[] args){
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterator();
        lt.testForEach();
        lt.testModify();
        lt.testRemove();
    }

    //向coursesToSelect添加课程
    private void testAdd(){
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = coursesToSelect.get(0);
        System.out.println("添加课程: " + temp.id + ":" + temp.name);

        Course cr2 = new Course("2", "C语言");
        coursesToSelect.add(0, cr2);
        Course temp2 = coursesToSelect.get(0);
        System.out.println("添加课程: " + temp2.id + ":" + temp2.name);

        //数组下标越界异常
//        Course cr3 = new Course("3", "test");
//        coursesToSelect.add(4, cr3);

        Course[] course = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = coursesToSelect.get(2);
        Course temp4 = coursesToSelect.get(3);

        System.out.println("添加了两门课程: " + temp3.id + ":" +
                temp3.name + ";" + temp4.id + ":" + temp4.name);

        Course[] course2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
        coursesToSelect.addAll(2, Arrays.asList(course2));
        Course temp5 = coursesToSelect.get(2);
        Course temp6 = coursesToSelect.get(3);

        System.out.println("添加了两门课程: " + temp5.id + ":" +
                temp5.name + ";" + temp6.id + ":" + temp6.name);

    }

    private void testGet(){
        int size = coursesToSelect.size();
        System.out.println("有如下课程待选(" + size + "):");
        for (Course cr : coursesToSelect) {
            System.out.println("课程: " + cr.id + ":" + cr.name);
        }
    }

    private void testIterator(){
        for (Course cr : coursesToSelect) {
            System.out.println("课程: " + cr.id + ":" + cr.name);
        }
    }

    private void testForEach(){
        for (Object obj : coursesToSelect) {
            Course cr = (Course) obj;
            System.out.println("课程: " + cr.id + ":" + cr.name);
        }
    }

    private void testModify(){
        coursesToSelect.set(4, new Course("6", "毛概"));
        testForEach();
    }

    private void testRemove(){
        Course cr = coursesToSelect.get(4);
        System.out.println("我是课程: " + cr.id + ":" + cr.name + ",我即将被删除");
        coursesToSelect.remove(cr);
        System.out.println("成功删除课程");
        testForEach();
    }
}
