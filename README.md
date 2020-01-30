# crypto
Encrypting and decrypting text
Part 1 - Normalize Text
The first thing we will do is normalize our input message so that it’s easier to work with.
The call normalizeText("This is some \"really\" great. (Text)!?")
should return
“THISISSOMEREALLYGREATTEXT”
Part 2 - Caesar Cipher
The program caesarify takes two parameters. The first argument is a string you want to encrypt, and the second is an integer that contains the shift value or "key". The function should return a string, which is the input string encrypted with the Caesar cypher using the shift value passed in its second argument.
Part 3 - Codegroups
The program groupify which takes two parameters. The first parameter is the string that you want to break into groups. The second argument is the number of letters per group. The function will return a string. So groupify(“HITHERE”, 2) would return “HI TH ER Ex”.
Part 4 - Putting it all together
The program encryptString takes three parameters: a string to be encrypted, an integer shift value, and a code group size. The method should return a string which is its cyphertext equivalent.
Part 5 - Hacker Problem - Decrypt
The method ungroupify which takes one parameter, a string containing space-separated groups, and returns the string without any spaces. So if you call ungroupify(“THI SIS ARE ALL YGR EAT SEN TEN CEx”) you will return “THISISAREALLYGREATSENTENCE”
Then a function called decryptString which takes three parameters: a string to be decrypted and the integer shift value used to encrypt the string, and returns a string which contains the (normalized) plaintext.
