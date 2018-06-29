package my.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {


    /**
     * главный метод читает аргумент парсит из него первое целое число и создаёт рандомный массив несортированных
     * элементов
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] inputAr;

        int arLength;
        System.out.println("Введите размер тестового массива для сортировки слиянием:\n");
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in))) {
            arLength = Integer.parseInt(bReader.readLine());
            inputAr = new int[arLength];

            for (int i = 0; i < inputAr.length; i++) {
                inputAr[i] = (int) ((Math.random() + 1) * 150);
            }
            System.out.println("Created array is  :");
            printStraitMyIntArray(inputAr);

            System.out.println("\nAnd now we'll get merge sorting this array:");
            printStraitMyIntArray(splitReturning(inputAr));

        } catch (Exception ignored) {
        }
    }

    /**
     * Берём целый массив
     *
     * @param inputAr если его длина == 1=> возвращаем его обратно если нет => делим его на две части целочисленным
     *                делением и создаём левый(наименьший при нечётном количестве элементов входящего массива) массив и
     *                правый наибольший массив, к которым применяем рекурсвиным вызовом splitReturning(); в методе
     *                sortAndMerge(); ,
     *                <p>
     *                который склеивает оба массива сортируя их при вставке элементов обоих массивов в свой
     *                результирующий выходящий массив.
     *                <p>
     *                Дальше этот результирующий массив возвращается в вышестоящую функцию sortAndMerge();
     *                <p>
     *                И сливается с соседним результирующим массивом другой части самого первого массива.
     * @return
     */
    private static int[] splitReturning(int[] inputAr) {
        int[] resultAr;
        if (inputAr.length < 2) {
            resultAr = inputAr;
        } else {
            int middleLowerLengthParentArPointer = inputAr.length / 2;
            int varyParentPointer = 0;

            int[] leftSubAr = new int[middleLowerLengthParentArPointer];
            int[] rigthSubAr = new int[inputAr.length - middleLowerLengthParentArPointer];
// заполняем правый и левый массивы элементами из входящего масива
            for (int i = 0; i < leftSubAr.length; i++, varyParentPointer++) {
                leftSubAr[i] = inputAr[varyParentPointer];

            }

            for (int j = 0; j < rigthSubAr.length; j++, varyParentPointer++) {
                rigthSubAr[j] = inputAr[varyParentPointer];
            }
// вызываем рекурсивно split на правом и левом массивах помещая их в merge
            resultAr = sortAndMerge(splitReturning(leftSubAr), splitReturning(rigthSubAr));
        }
        return resultAr;
    }

    /**
     * берет два массива
     *
     * @param leftAr  - первый(левый) массив из
     *                <p>
     *                aplitReturn
     *                </p>
     *                с наименьшей длиной
     * @param rigthAr - второй (правый) массив из
     *                <p>
     *                splitReturn();
     *                </p>
     *                с наибольшей длиной сливает их в один, сортируя вставки и возвращает
     * @return результирующий отсортированный массив resultAr
     */
    public static int[] sortAndMerge(int[] leftAr, int[] rigthAr) {
        int[] resultAr = new int[leftAr.length + rigthAr.length];
        int resultPointer = 0;
        int i = 0, j = 0;

        // цикл пока указатель возвращаемого массива не достигнет размера = сумме двух
        // размеров входящих массивов

        while (resultPointer < resultAr.length) {

            // если указатель левого массива ещё не достиг длины своего массива
            if (i < leftAr.length) {
                // проверяем что и указатель правого массива не достиг длины своего массивва
                if (j < rigthAr.length) {

                    // проверяем какой элемент меньше из левого и правого массивов , который меньше
                    // идёт первым в результирующий массив
                    if (leftAr[i] < rigthAr[j]) {
                        resultAr[resultPointer] = leftAr[i];
                        // если очередной элемент левого массива меньше очередного элемента из правого
                        // массива помещаем элемент в результирующий массив
                        // увеличиваем указатель результирующего и указатель левого массива элемент
                        // которого поместили в результирующий
                        i++;
                        resultPointer++;
                    } else {

                        // если элемент правого оказался меньше => помещаем его в результирующий,
                        // увеличивая указатель правого и результирующего
                        resultAr[resultPointer] = rigthAr[j];
                        j++;
                        resultPointer++;
                    }
                } else if (i < leftAr.length) {

                    // если правый массив кончился проверяем что левый ещё не закончился и добавляем
                    // очередной элемент из отсортированного
                    // левого массива в следующее вакантное место результирующего
                    resultAr[resultPointer] = leftAr[i];

                    // увеличивая указатель левого и результирующий соответственно
                    i++;
                    resultPointer++;
                }

                // если закончился левый массив
            } else if (j < rigthAr.length) {
                // проверяем что правый ещё не закончился и вставляем в очередное вакантное
                // место результирующего из очередного элемента правого отсортированного массива
                resultAr[resultPointer] = rigthAr[j];

                // увеличиваем указатели правого и результирующего
                j++;
                resultPointer++;
            }
        }
        // после того как заполнен результирующий массив while разрывается и возвращает
        // отсортированный массив
        return resultAr;

    }

    /**
     * печатает элементы массива в прямом порядке
     *
     * @param inputAr
     */
    public static void printStraitMyIntArray(int[] inputAr) {
        for (int i = 0; i < inputAr.length; i++) {
            System.out.print(" __ " + inputAr[i]);
        }

    }

}
