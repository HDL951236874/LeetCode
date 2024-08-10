/*
* first part is divided by 2 numRows - 2
* second part is divided by 2 numRows + 1
* ....
*
* */
var convert = function(s, numRows) {
    if(numRows === 1) return s;
    let res = '';
    for(let i = 0;i < numRows;i++){
        if(i === 0 || i === numRows-1){
            let index = i;
            while(index<s.length){
                res+=s[index];
                index += 2*numRows - 2;
            }
        }
        else {
            let index1 = i;
            let index2 = 2*numRows-2-i;
            while(true){
                if(index1<s.length){
                    res+=s[index1];
                    index1 += 2*numRows - 2;
                }
                if(index2 < s.length){
                    res+=s[index2];
                    index2 += 2*numRows - 2;
                }
                if(index1>= s.length && index2>=s.length){
                    break;
                }
            }
        }
    }
    return res
};

console.log(convert('A',1))