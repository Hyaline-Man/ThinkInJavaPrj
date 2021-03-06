package com.zh.chapter2.chapter23;

/**
 * 快速排序
 * 平均需要:2NlnN次比较，2NlnN * 1/6的交换(交换很少，比归并排序快是因为交换次数少)
 * 最坏: N^2/2次比较
 *
 * 需要注意数组切分，如果切分不平衡，会导致最坏情况, 将数组打乱会降低此种概率
 *
 * @author zh
 * 2018年9月18日
 */
public class Quick {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j); // 第二个循环，j肯定比v小
		return j;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}
