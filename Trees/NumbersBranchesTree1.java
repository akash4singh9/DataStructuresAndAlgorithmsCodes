// Ref: https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/


// Definition for a binary tree node.
class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
}

public class NumbersBranchesTree1 {

   public int sumNumbers(TreeNode A) {
      return function(A, 0, 0);
   }

   int function(TreeNode node, int cs, int ts) {
      if (node == null)
         return 0;
      if (node.left == null && node.right == null)
         ts = (ts + (cs * 10 + node.val) % 1003) % 1003;
      cs = cs * 10 + node.val;
      ts = function(node.left, cs, ts);
      ts = function(node.right, cs, ts);
      return ts;
   }

   public static void main(String[] args) {

   }
}
