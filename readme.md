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

###Can we delete Tagger class?