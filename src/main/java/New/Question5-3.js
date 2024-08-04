let longestPalindrome = function (s) {
    if(s.length<=1) return s;
    var dp = Array.from(Array(s.length),()=>{return Array.from(Array(s.length), ()=>{return false})})
    var num = 1;
    var res = s[0];
    for (let i = 0; i < s.length; i++) {
        dp[i][i] = true;
        for (let j = 0; j < i; j++) {
            if(s[i] === s[j] && (i-j<=2 || dp[j+1][i-1]) ){
                dp[j][i] = true;
                if(num < i-j+1){
                    num = i-j+1;
                    res = s.slice(j,i+1);
                }
            }
        }
    }
    return res;
}
