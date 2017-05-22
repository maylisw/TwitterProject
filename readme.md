###Steps
1. URL -> HTML
2. HTML -> Plain text
3. ~~Plain text -> Tokenized Strings~~
4. ~~Toknized strings -> Sorted String[]~~
5. ~~Sorted String[] -> ArrayList<Word(#, string)>~~
6. ArrayList<Word(#, string)> -> ArrayList<Word> by part of speech
7. ArrayList<Word> by part of speech -> 2D array of Strings by part of speech
8. 2D + templetes -> Text of tweet
9. Text of tweet -> Image and tweet using twitter API?

######Chosen
 - Calls MadLibs in constructor to create the 2D array
 - MadLibs will generate random template based on whether news is good or bad
 - method createText will plug words into the MadLibs tweet to return a string

######Madlibs
-picks random tweet then returns an array/ array list:

{"Nobody should be allowed to", "verb", "the", "noun", "! Wrong wrong wrong!"}
For MadLibs, we can assign a double range for each template in the constructor (does it need to take in anything?)and access the get from Chosen for d to get which one.

###Can we delete Tagger class? -Yes, it's not needed anymore

#####Chosen Details/Step 7
 - Comes after POSArrayLists pos = p.tagging --> gets Array List of Array Lists of categorised Word objects
 - Chosen object = takes in pos --> has private instance variables double d and 2D array a
 - Constructs 2D array of size by accessing indices for sizes filled w/ Word objects --> each row is an Array List sorted by size L to S
 - Method to access which Math.random() 0<= x < 1 double and assigned MadLibs template w/ words needed.
 - Creates/returns 2D array of # of words needed --> assign to a
 - Double gotten assign to d
 - 2 get methods accessing a and d
 
 I think step 7 is done and it's not terribly complicated.
 
 #####Step 2
 - Takes the HTML String and turn to plain text
 - The plain text is one long string --> seems to have a bunch of HTML formatting code in the middle
 - Need to get rid of all the random bits because it might throw off the tokenizer and tagger
 
 #####Issues
 - There's a lot of issues in TextTOSortedArray
 - And the POSArrayLists have a slight issue.
 - Simplify the URL reader area.
 