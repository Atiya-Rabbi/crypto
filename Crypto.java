import java.util.Scanner;
import java.util.*;

class Crypto{
Scanner input = new Scanner(System.in);
//method 1
public static String normalizeText(String text){
text = text.replaceAll("[^a-zA-Z]","").toUpperCase();
return text;
}

//method 2
public static char[] caesarify(int key, String norm){
char[] alpha = new char[26];
for(int i = 0; i < 26; i++){
alpha[i] = (char)(65 + i);
}

int len_norm = norm.length();
char[] charss = norm.toCharArray();
int val =0;
for(int j=0; j<len_norm; j++){

for(int k =0; k<26; k++){
if(charss[j] == alpha[k]){
val = k+key;
if(k+key>25)
val = k+key-26;
charss[j] = alpha[val];
break;
}
}
}
return charss;

}

//method 3
public static char[] groupify(char[] str, int chunk){
int ln_str = str.length,new_ln,x_pace=0;

if((ln_str- (chunk *(ln_str/chunk)))!=0)
new_ln = (ln_str/chunk)+ln_str;
else
new_ln = ln_str+ (ln_str/chunk)-1; 

if((ln_str- ((ln_str/chunk) * chunk))!=0)
x_pace = chunk - (ln_str- ((ln_str/chunk) * chunk));

int mem = new_ln + x_pace;
char[] new_str = new char[mem];

int gap=0,q=0;

try{

for(int m=0; m<new_ln;m++){

if(gap == chunk){
gap=0;
new_str[q]= ' ';
new_str[++q]= str[m]; 
}

else if((m == ln_str)&&(x_pace!=0)){
int n =q;

for(int p =0; p<x_pace; p++){
new_str[n]='x';
n++;
}
}

else{
new_str[q] = str[m];
}

gap++;
q++;
}
}catch(ArrayIndexOutOfBoundsException e){}

return new_str;
}

//method 4
public static char[] encryptString(String normal_str, int k, int l_p_g){



//calling method 1
normal_str= normalizeText(normal_str);


//calling method 2
char[] csr = caesarify(k,normal_str);

//calling method 3

csr = groupify(csr, l_p_g);
return csr;


}

//method 5
public static String ungroupify(char[] en_string){
int len_of_str = en_string.length;
String encrypt = String.valueOf(en_string);
encrypt = encrypt.replaceAll("\\s","");
encrypt = encrypt.replaceAll("x","");
return encrypt;
}

//method 6
public static char[] decryptString(char[] string_rcv,int decrypt_key){
String str_rcv = ungroupify(string_rcv);
int length_str = str_rcv.length();
char[] char_rcv = str_rcv.toCharArray();
char[] alphabets = new char[26];
for(int d =0;d<26; d++){
alphabets[d] = (char)(65+d);
}
int value =0;
for(int e =0; e<length_str;e++){
for(int f =0; f<26; f++){
if(char_rcv[e] == alphabets[f]){
value=f-decrypt_key;
if(value<0)
value = 26+value;
char_rcv[e] = alphabets[value];
break;
}
}
}
return char_rcv;
}

//main method
public static void main(String ...args){

System.out.print("Enter your text: ");
Scanner input = new Scanner(System.in);
String str = input.nextLine();
System.out.print("Enter the key value: ");
int key = input.nextInt();
System.out.print("Enter number of letter per group: ");
int lttr = input.nextInt();
char[] cyphertext = encryptString(str,key,lttr);
System.out.print("Encrypted text: ");
System.out.println(cyphertext);
char[] plaintext = decryptString(cyphertext, key);
System.out.print("Decrypted text: ");
System.out.println(plaintext);
}
}