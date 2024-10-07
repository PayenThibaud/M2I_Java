// premiere solution

// function isPalindrom(word){
//     word = word.trim().toLowerCase();
//     let reverseWord = "";
//     for (let end = word.length-1; end >= 0; end--){
//         reverseWord += word[end];
//     }
//     return word === reverseWord;
// }

// console.log(isPalindrom("abcbazz"))
// console.log(isPalindrom("abcba"))

// deuxieme solution

// function isPalindrom(word){
//     word = word.trim().toLowerCase();
//     for (let i = 0; i <= word.length-1 / 2; i++){
//         if(word[i] !== word[word.length - i -1]){
//             return false;
//         }
//     } 
//     return true;
// }

// console.log(isPalindrom("abcbazz"))
// console.log(isPalindrom("abcba"))


// troisieme solution

// function isPalindrom(word){
//     return word === word.split("").reverse().join("");
// }

// let isPalindrom = (word) => word === word.split("").reverse().join("");

// console.log(isPalindrom("abcbazz"))
// console.log(isPalindrom("abcba"))

// quatrieme solution

function detectPalindrome(text){
    text = text.split(' ').join('');
    let txet = text.split("").reverse().join("");
return text == txet;
}

console.log(detectPalindrome("abcbazz"))
console.log(detectPalindrome("abcba"))