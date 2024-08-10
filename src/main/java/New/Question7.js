var reverse = function(x) {
    if(x === 0) return 0;
    let res = 0;
    let x_ = Math.abs(x);
    while(x_>0){
        res = res*10 + x_%10;
        x_ = Math.floor(x_/10);
    }
    let res_ = x>0? res : -1*Math.abs(res)
    return res_> 2**31-1 || res_ < (-2)**31 ? 0: res_
};

console.log(reverse(321))