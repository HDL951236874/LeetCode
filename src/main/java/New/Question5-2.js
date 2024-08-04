
let longestPalindrome = function (s) {
    if(s.length <=1) return s;

    let res = '';
    for (let i = 0; i < s.length-1; i++) {
        var check1 = check(s, i, i);
        var check2 = check(s,i,i+1);
        if(check1.length>res.length) res = check1;
        if(check2.length>res.length) res = check2;
    }
    return res;
};
var check = function(s,l,r){
    while(l>=0 && r<=s.length-1 && s[l] === s[r]){
        l--;
        r++;
    }
    return s.slice(l+1,r);
}

console.log(longestPalindrome('babad'))