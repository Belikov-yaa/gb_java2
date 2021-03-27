import java.util.Arrays;

public class testingClass {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(trimArrayAfter4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7, 4})));

    }

    public static int[] trimArrayAfter4(int[] sourceArr) {

        boolean is4found = false;
        int indexLast4 = 0;

        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] == 4) {
                is4found = true;
                indexLast4 = i;
            }
        }


        if (!is4found) throw new RuntimeException();

        return Arrays.copyOfRange(sourceArr, indexLast4 + 1, sourceArr.length);

    }
}
