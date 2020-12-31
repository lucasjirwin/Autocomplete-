

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

    private final String query;
    private final long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0)
            throw new IllegalArgumentException("Invalid argument");
        this.query = query;
        this.weight = weight;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseOrder();
    }

    private static class ReverseOrder implements Comparator<Term> {
        public int compare(Term a, Term b) {
            if (a.weight > b.weight) return -1;
            if (a.weight < b.weight) return 1;
            return 0;
        }
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0)
            throw new IllegalArgumentException("Invalid Argument");
        return new PrefixOrder(r);
    }

    private static class PrefixOrder implements Comparator<Term> {

        private final int r;

        public PrefixOrder(int r) {
            this.r = r;
        }

        public int compare(Term a, Term b) {


            for (int i = 0; i < r; i++) {
                if (a.query.length() == i && b.query.length() == i) return 0;
                if (a.query.length() == i) return -1;
                if (b.query.length() == i) return 1;
                if (a.query.charAt(i) < b.query.charAt(i)) return -1;
                if (a.query.charAt(i) > b.query.charAt(i)) return 1;
            }

            return 0;
        }
    }

    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return (weight + "  " + query);
    }

    public static void main(String[] args) {
        Term test = new Term("apple", 100);
        Term test2 = new Term("oranges", 200);
        int result = test2.compareTo(test);
        StdOut.println(result);
        Term[] list = new Term[2];
        list[0] = test;
        list[1] = test2;
        Arrays.sort(list, byReverseWeightOrder());
        StdOut.println(list[0] + " " + list[1]);
        Term dog = new Term("dog", 10);
        Term dogcatcher = new Term("dogcatcher", 30);
        Term[] prefixes = new Term[2];
        prefixes[1] = dog;
        prefixes[0] = dogcatcher;
        Arrays.sort(prefixes, byPrefixOrder(4));
        StdOut.println(prefixes[0] + " " + prefixes[1]);

    }
}
