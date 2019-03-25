// 4.将一个字符串中的空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
// 思路：从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类

public class Ex4 {
    public static String replaceSpace(StringBuffer str) { // 把原有的StringBuffer中字符串复制到一个新的空的StringBuilder中，一边遍历赋值一边操作
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            // 按索引寻找字符串，若匹配到了空格，则添加（连接）字符串到StringBuilder sb中
            if (String.valueOf(str.charAt(i)).equals(" ")) { // String.valueOf()返回的是字符串
                sb.append("20%");       //charAt() 方法用于返回指定索引i处的字符，0 <= i <= length() - 1。
            } else {
                sb.append(str.charAt(i));
            }
        }
//        return String.valueOf(sb);
        return sb.toString();
    }

    public static void main(String[] args){
        StringBuffer str = new StringBuffer("We are happy");
        String str_after = replaceSpace(str);
        System.out.println(str_after);
    }
}

// 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
// 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
// StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
// 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。