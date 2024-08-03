let iterationFunction = function(s, l, r){
    if(l === r) return true;
    if(r - l === 1) return s[r] === s[l];
    if(s[l] === s[r]){
        return iterationFunction(s, l+1, r-1);
    }
    return false;
};
let longestPalindrome = function (s) {
    if (s.length === 1 || s.length === 0) return s;
    let res = s[0];
    let num = 1;
    for (var i = 0; i < s.length - num; i++) {
        for (let j = s.length - 1; j > i; j--) {
            const f = iterationFunction(s, i, j);
            if (f) {
                if (num < j - i + 1) {
                    num = j - i + 1;
                    res = s.slice(i, j + 1);
                }
                break;
            }
        }
    }
    return res;
};

longestPalindrome("bb")