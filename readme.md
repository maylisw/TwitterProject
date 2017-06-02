###Steps
1. ~~URL -> HTML~~
2. ~~HTML -> Plain text~~
3. ~~Plain text -> Tokenized Strings~~
4. ~~Toknized strings -> Sorted String[]~~
5. ~~Sorted String[] -> ArrayList<Word(#, string)>~~
6. ~~ArrayList<Word(#, string)> -> ArrayList<Word> by part of speech~~
7. ~~ArrayList<Word> by part of speech -> 2D array of Strings by part of speech~~
8. ~~2D + templetes -> Text of tweet~~
9. Text of tweet -> Image and tweet using twitter API?

 #####Issues
 - Debug tagging (maylis)
 - Get image (j-labels)(maylis)
 - twitter API (maylis)
 - Create new tweets and more detail?
 
 #####Positive and Negative
 - Positive: Breitbart, Fox News
 - Negative: LA Times, CNN, Huffington Post, Tiger, Daily Californian (Berkeley)
 - Neutral: NPR, BBC, NYT, Wall Street Journal
 
#####Order of Classes and Methods
 - UserInput --> getString, getLine, getDouble, getInt, getBoolean
 - URLReader --> readerReturn (String HTMLCode)
 - HTMLToPlainText (not needed?) --> replace (String plainText)
 - TextTOSortedArray --> tokenize (return String[])
 - SortedTOWordObjectArrayList --> listed (ArrayList<Word>), print (String, testing only)
 - PartOfSpeech --> tagging (return POSArrayList)
 - PositiveNegative --> whichTemplate (boolean); main categorisation in constructor
 - POSArrayLists --> constructor only w/ ArrayList of 12 ArrayLists of Word objects (word, times found)
 - Chosen --> fill (String[][]), getTemplate (double; # of template), choosing tweet in constructor
 - MadLibs --> getTweet (String tweet), main filling of tweet in constructor
 - JLabel/JFrame OR ToTwitter --> bleh