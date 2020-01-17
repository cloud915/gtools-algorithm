package com.gtools.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class SortUtil {

    public static void swap(int[] nums, int i, int j) {
        //nums[j] = nums[i] + nums[j];
        //nums[i] = nums[j] - nums[i];
        //nums[j] = nums[j] - nums[i];


        nums[i]=nums[i]+nums[j];
        nums[j]=nums[i]-nums[j];
        nums[i]=nums[i]-nums[j];
    }

    public static void swap1(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int[] randomArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static Integer[] randomBoxedArray(int length) {
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static int[] randomArray(int length, int top) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(top);
        }
        return arr;
    }

    public static int[] randomArray(int length, int base, int top) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = base + random.nextInt(top - base);
        }
        return arr;
    }

    public static Integer[] randomBoxedArray(int length, int base, int top) {
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = base + random.nextInt(top - base);
        }
        return arr;
    }

    public static int orderedType(Object arr) {
        Class<?> clazz = arr.getClass();
        if (!clazz.isArray()) throw new IllegalArgumentException("参数不是数组");

        int length = Array.getLength(arr);

        int type = 0;//全部一样，看是否能保持
        for (int i = 0; i < length - 1; i++) {
            Object arri = Array.get(arr, i);
            Object arri1 = Array.get(arr, i + 1);
            int compare = compare(arri, arri1);
            if (type == -1) {
                if (compare > 0) {
                    return -2;//无序
                }
            } else if (type == 0) {
                if (compare < 0) {
                    type = -1;//可能正序，看是否能保持
                } else if (compare > 0) {
                    type = 1; //可能倒序，看是否能保持
                }
            } else {//type=1
                if (compare < 0) {
                    return -2;//无序
                }
            }
        }
        return type;
    }

    @SuppressWarnings("unchecked")
    private static int compare(Object o1, Object o2) {
        if (o1 == null) {
            if (o2 == null) return 0;
            if (o2 instanceof Comparable) {
                return -1;
            } else {
                throw new IllegalArgumentException("数组元素没有实现Comparable");
            }
        } else if (o1 instanceof Comparable) {
            if (o2 == null) return 1;
            if (o2 instanceof Comparable) {
                return ((Comparable) o1).compareTo(o2);
            } else {
                throw new IllegalArgumentException("数组元素没有实现Comparable");
            }
        } else {
            throw new IllegalArgumentException("数组元素没有实现Comparable");
        }
    }

    public static <T extends Comparable<T>> boolean isAscend(T[] arr) {
        int t = orderedType(arr);
        return t == -1 || t == 0;
    }

    public static boolean isAscend(int[] arr) {
        int t = orderedType(arr);
        return t == -1 || t == 0;
    }

    public static boolean isDescend(int[] arr) {
        int t = orderedType(arr);
        return t == 0 || t == 1;
    }

    public static boolean isUnordered(int[] arr) {
        int t = orderedType(arr);
        return t == -2;
    }

    public static boolean isOrdered(int[] arr) {
        int t = orderedType(arr);
        return t != -2;
    }

    public static boolean isHomogeneou(int[] arr) {
        int t = orderedType(arr);
        return t == 0;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static String sysInLine() {
        synchronized (scanner) {
            return scanner.nextLine();
        }
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (T e : arr) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T min(T[] arr) {
        T min = arr[0];
        for (T e : arr) {
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;
    }
}
