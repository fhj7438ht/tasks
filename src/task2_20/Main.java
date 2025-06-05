package task2_20;
import java.util.*;

public class Main {
    private static final byte LIST_LENGTH = 15;
    public static void main(String[] args) {
        ArrayList<Byte> list = new ArrayList<>(LIST_LENGTH);
        for (int i = 0; i < LIST_LENGTH; i++)
            list.add((byte) (Math.random() * LIST_LENGTH + 1));
        System.out.println(Arrays.toString(list.toArray()));

        Map<Byte, Byte> frequencies = new HashMap<>();
        for(Byte value : list){
            Byte currentValue = frequencies.get(value);
            if (currentValue != null)
                frequencies.replace(value, (byte) (currentValue + 1));
            else
                frequencies.put(value, (byte) 1);
        }

        for(Map.Entry<Byte, Byte> entry: frequencies.entrySet())
            if(entry.getValue() != 1)
                System.out.println("Число '" + entry.getKey() + "' встречается " + entry.getValue() + " раза");
    }
}
