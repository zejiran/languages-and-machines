
a3b3.gold  :  recognizes strings of the form AxB, A in {a,b}*, B in {a,b}*,  #a(A)%3 = #b(B)%3

a3b3_v2.gold  :  recognizes strings of the form AxB, A in {a,b}*, B in {a,b}*,  #a(A)%3 = #b(B)%3

evenAs.gold :  recognizes strings w, w  in {a,b}* such that  #a(w) % 2 = 0

HasCat_GOLD.gold: recognizes strings w, w  in {a,c,t}* such that  cat is a substring of w

my8count.gold:  recognizes strings w, w in {0,1}, composed of the concatenation of strings of length 8. 
				Where the 8th symbol is the parity of the previous 7.

PartsOf.gold: recognizes strings of the form W$V where W ∈ ('a'‥ 'g')*,V ∈ ('a'‥ 'g')* and 
				no characters in W appear in V
				
Example.gold: Strings of {a,b,c}*; Even number of a’s; c cannot appear in positions that are multiples of 3.
				No two consecutive b’s


Utilities:  contains functions for testing automata
