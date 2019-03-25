import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestBinary {
    public static void Transfer(Integer input){
        Integer.toBinaryString(input);
        List<String> list = new LinkedList<String>();
        for(int i = 0; i<32; i++)
            list.get(input);
        Collections.reverse(list);

    }
}
