class Solution {
    // #1 Try : Bruteforce was O(N^2)
    // #2 Try : using prefix + suffix algorithm to solve in O(N)
    // #3 Try (extended requirement of O(1) SC ) : using only prefix product and a variable (var will act as suffix)
    public int[] productExceptSelf(int[] nums) {
        int[] pf = new int[nums.length]; // prefix product arr

        // setting up prefix product
        pf[0] = 1; // initialize first element as 1 as prev element does not exist
        for(int i = 1; i < nums.length; i++) {
            pf[i] = pf[i-1] * nums[i-1]; // product of prefix product of prev element x prev element of input arr
        }

        // setting up answer array to return -> looped reversed to properly update suffix product var
        int sf = 1; // suffix product end element
        for(int i = nums.length - 1; i >= 0; i--) {
            pf[i] *= sf; // answer would be the product of pf and sf element
            sf *= nums[i]; // update suffix product variable by product of current value x current input arr element
        }

        return pf;
    }
}