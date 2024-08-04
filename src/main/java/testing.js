var dp = Array.from(Array(4),()=>{return Array.from(Array(4), ()=>{return false})})
console.log(dp);
dp[0][1] = true;
console.log(dp);