import java.util.HashMap;
import java.util.Map;

public class Main {

    static public String intToRoman(int num) {

        Map<Integer, Character> romanToIntMap = new HashMap<>();
        romanToIntMap.put(1, 'I');
        romanToIntMap.put(5, 'V');
        romanToIntMap.put(10, 'X');
        romanToIntMap.put(50, 'L');
        romanToIntMap.put(100, 'C');
        romanToIntMap.put(500, 'D');
        romanToIntMap.put(1000, 'M');

        int[] romanIterator = new int[]{1000, 500, 100, 50, 10, 5, 1};

        int length = (int) Math.log10(num) + 1;
        int powerOfTen = length - 1;
        StringBuilder romans = new StringBuilder();
        int flooredNum = (int) Math.pow(10, length - 1);
        num -= flooredNum;

        for (int i = length; i > 0; --i) {
            for (int j = 0; ; j++) {
                if (flooredNum - romanIterator[j] == 0) {
                    romans.append(romanToIntMap.get(romanIterator[j]));
                    break;

                } else if (flooredNum - romanIterator[j] == -Math.pow(10, i - 1)) {
                    romans.append(romanToIntMap.get((int) Math.pow(10, i - 1)));
                    romans.append(romanToIntMap.get(romanIterator[j]));
                    break;
                }

            }
            if (num == 0) {
                break;
            }
            powerOfTen--;
            flooredNum = (int) (num / (int) Math.pow(10, powerOfTen) * (int) Math.pow(10, powerOfTen));
            num -= flooredNum;
        }
        return romans.toString();

    }
}
