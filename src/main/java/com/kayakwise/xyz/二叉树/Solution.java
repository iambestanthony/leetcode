package com.kayakwise.xyz.二叉树;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by JayJ on 2020/3/3.
 **/
class Solution {


        int x = 1, y = 2, z = 3;
        TreeNode node1 = new TreeNode(x);
        TreeNode node2 = new TreeNode(y);
        TreeNode node3 = new TreeNode(z);
        node1.right = node2;
        node2.left = node3;
        //List<Integer> list = preorderTraversal(node1);
        List<Integer> list = postorderTraversalByRecursive(node1);
        System.out.println(list);

    }

    /**
     * 二叉树的层次遍历  即使用广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
    }

    /**
     * 后序遍历递归
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalByRecursive(TreeNode root) {
        List<Integer> list = podtorder(root);
        Collections.reverse(list)
        return list;
    }

    private static List<Integer> podtorder(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        list.add(root.val);

        if (root.right != null) {
            list.addAll(podtorder(root.right));
        }
        if (root.left != null) {
            list.addAll(podtorder(root.left));
        }
        return list;
    }


    /**
     * 后序遍历循环
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalByItration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    /**
     * 中序遍历 递归遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalByRecursive(TreeNode root) {
        //递归遍历
        //LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if (null == root) {
            return list;
        }

        if (null != root.left) {
            list.addAll(inorderTraversalByRecursive(root.left));
        }
        list.add(root.val);
        if (null != root.right) {
            list.addAll(inorderTraversalByRecursive(root.right));
        }
        return list;
    }

    /**
     * 中序遍历 迭代
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalByItration(TreeNode root) {
        //迭代遍历
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            list.add(stack.peek().val);
            root = stack.pop().right;
        }

        return list;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (null == root) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if (null != node.right) {
                stack.add(node.right);
            }
            if (null != node.left) {
                stack.add(node.left);
            }
        }
        return list;
    }

}