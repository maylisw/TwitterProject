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

choosen call madlibs then instance var = 2D array
creatText plug wwords into random tweet returns a string

step 6 is pretty much complete (and I think it does the tagger class's job but it has some incompactibility errors with Stanford.nlp.ling)