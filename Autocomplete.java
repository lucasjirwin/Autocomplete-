/* *****************************************************************************
 *  Name:    Ada Lovelace
 *  NetID:   alovelace
 *  Precept: P00
 *
 *  Partner Name:    Dorothy Johnson Vaughan
 *  Partner NetID:   djvaughan
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import java.util.Arrays;

public class Autocomplete {

    private final Term[] terms;


    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        int n = terms.length;
        this.terms = new Term[n];
        for (int i = 0; i < n; i++) {
            this.terms[i] = terms[i];
        }
        Arrays.sort(this.terms);

    }

    // Method to find the first and last index and return length of array/
    // number of items
    private int firstTerm(String prefix) {
        int length = prefix.length();
        Term pre = new Term(prefix, 1);
        int first = BinarySearchDeluxe.firstIndexOf(terms, pre,
                                                    Term.byPrefixOrder(length));
        return (first);
    }

    private int lastTerm(String prefix) {
        int length = prefix.length();
        Term pre = new Term(prefix, 1);
        int last = BinarySearchDeluxe.lastIndexOf(terms, pre,
                                                  Term.byPrefixOrder(length));
        return last;
    }

    // Returns all terms that start with the given prefix, in descending order
    // of weight.
    public Term[] allMatches(String prefix) {
        int first = firstTerm(prefix);
        int last = lastTerm(prefix);
        Term[] matches = new Term[last - first + 1];
        for (int i = 0; i < matches.length; i++) {
            matches[i] = terms[i + first];
        }
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;

    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        return lastTerm(prefix) - firstTerm(prefix) + 1;
    }

    public static void main(String[] args) {


    }
}
