package com.kayakwise.xyz.二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JayJ on 2020/3/3.
 **/
class Solution {

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
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        if (null == root) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            if (null != node.left) {
                stack.add(node.left);
                //这一点很关键，一不小心就死锁了，把父节点放入stack中，应先删除其子节点
                TreeNode n = node;
                n.left = null;
                n.right = null;
                stack.add(n);
            }else {
                list.add(node.val);
            }
            if (null != node.right) {
                stack.add(node.right);
            }

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

    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        TreeNode node1 = new TreeNode(y);
        TreeNode node2 = new TreeNode(z);
        TreeNode node3 = new TreeNode(x);
        node1.left = node2;
        node2.left = node3;
        //List<Integer> list = preorderTraversal(node1);
        List<Integer> list = inorderTraversalByItration(node1);
        System.out.println(list);

    }
}