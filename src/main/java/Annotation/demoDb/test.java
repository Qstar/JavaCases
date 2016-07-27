package Annotation.demoDb;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test {
    public static void main(String[] args){
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("lucy");
        f2.setAge(18);

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,zh@163.com,77777@qq.com");

        Filter f4 = new Filter();
        f4.setEmail("liu@sina.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);
        String sql4 = query(f4);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
        System.out.println(sql4);

        Filter2 filter2 = new Filter2();
        filter2.setAmount(10);
        filter2.setName("技术部");
        System.out.println(query(filter2));
    }

    private static String query(Object f){
        StringBuilder sb = new StringBuilder();

        //获取到class
        Class c = f.getClass();
        //获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        //遍历所有字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            //处理每个字段对应的sql
            //拿到字段名
            boolean fExist = field.isAnnotationPresent(Column.class);
            if (!fExist) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            //拿到字段的值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //拼装sql
            if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }
            sb.append(" and ").append(fieldName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in(");
                    for (String v : values) {
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
