/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<String> vals = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            vals.add(node == null ? "null" : String.valueOf(node.val));

            if (node == null) {
                continue;
            }

            queue.addLast(node.left);
            queue.addLast(node.right);
        }
        return String.join(",", vals);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");

        if (vals.length < 1 || data.equals("null")) {
            return null;
        }

        
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        deque.add(root);

        for (int i=1 ; i < vals.length ; i+=2) {
            Integer lval = vals[i].equals("null") ? null : Integer.valueOf(vals[i]);
            Integer rval = vals[i+1].equals("null") ? null : Integer.valueOf(vals[i+1]);

            TreeNode node = deque.pollFirst();
            if (lval != null) {
                node.left = new TreeNode(lval);
                deque.addLast(node.left);
            }
            if (rval != null) {
                node.right = new TreeNode(rval);
                deque.addLast(node.right);
            }
        }

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));