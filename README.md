Autocomplete.java implements autocomplete for a given set of n terms (where terms are strings and associated non-negative weights) using 
Term.java and BinarySearchDeluxe.java. That is, given a prefix, the autocomplete class finds all queries that begin with the prefix and returns them in reverse order of weight. 

Term.java  represents an autocomplete term of a query string and associated weight. Supports comparing terms using three different comparators:
lexicographic order, descending order by weight, and lexicographic order with just the first r characters. 

BinarySearchDeluxe.java efficiently searches a sorted array containing more than one keys equal to the target key and supports returning either
the first of last index of the target key. 



