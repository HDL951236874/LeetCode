/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var TwoSum = function(nums,target){
    var map = new Map();
    for (let i = 0; i < nums.length; i++) {
        var val = target-nums[i];
        if(map.has(val)){
            return [map.get(val), i]
        }else {
            map.set(nums[i], i);
        }
    }
}

