public class Main {
    public static void main(String[] args) {
        String[][] numbers = {
                {"13", "4", "-7", "19"},
                {"25", "-10", "32", "-21"},
                {"31", "9", "-2", "0,0"},
                {"-43", "18", "27", "8"}
        };
        try {
            System.out.println(sumArray4x4(numbers));
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
        } catch (MyArraySizeException e) {
            System.err.println("Неверный размер массива");
        }

    }

    public static int sumArray4x4(String[][] inArray) {
        int sum = 0;
        if (inArray.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < inArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(inArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка формата данных в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends RuntimeException {

}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String s) {
        super(s);
    }
}