
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
        var l = new ListNode();
        l.next = new ListNode();
        var l_start = l.next;
        var add = 0;
        while(l1!= null || l2!=null || add!==0){
            let val1 = l1!==null? 0:l1.val;
            let val2 = l2!==null? 0:l2.val;
            let sum = val1 + val2 +add;
            if(sum >= 10){
                l_start.val = sum -10;
                add = 1;
            }else {
                l_start.val = sum;
                add = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            if(l1!= null || l2!=null || add!==0){
            l_start.next = new ListNode();
            l_start = l_start.next;}
        }
        return l.next;
};