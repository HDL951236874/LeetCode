var lengthOfLongestSubstring = function(s) {
    if(s.length === 0) return 0;
    let set = new Set();
    let queue = [];
    let res = 1;
    for(let i = 0;i<s.length;i++){
        if(set.has(s[i])){
            res = queue.length>res ? queue.length : res;
            while(true){
                var char = queue.shift();
                set.delete(char);
                if(char === s[i]){
                    break;
                }
            }
        }
        queue.push(s[i]);
        set.add(s[i]);

    }
    return queue.length>res ? queue.length : res;
};

console.log(lengthOfLongestSubstring(
    "pwwkew"))