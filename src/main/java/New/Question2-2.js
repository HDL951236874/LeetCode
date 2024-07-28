
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}
var addTwoNumbers = function (l1, l2){
    var l_start = new ListNode();
    l_start.next = new ListNode();
    l = l_start.next;
    var add = 0;
    while(true){
        var val1 = l1 !== null? l1.val : 0;
        var val2 = l2 !== null? l2.val : 0;
        var sum = val1 + val2 + add;
        if(sum>=10){
            l.val = sum -10;
            add = 1;
        }else {
            l.val = sum;
            add = 0;
        }
        l1 = l1 !== null? l1.next : null;
        l2 = l2 !== null? l2.next : null;
        if(l1 === null && l2 ===null && add ===0){
            break
        }
        else {
            l.next = new ListNode();
            l = l.next;
        }
    }
    return l_start.next;
}