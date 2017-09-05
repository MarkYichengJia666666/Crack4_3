import apple.laf.JRSUIUtils;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by jiayicheng on 17/8/1.
 */
public class Node {
    ArrayList<LinkedList<TreeNode>> create(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result=new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current=new LinkedList<TreeNode>();
        if(root!=null)
        {
            current.add(root);
        }
        while(current.size()>0)
        {
            result.add(current);                  //add previous level把原来的搭进去
            LinkedList<TreeNode> parents=current;//go to next level再把原来的当成父节点
            current=new LinkedList<TreeNode>();//重置current;
            for(TreeNode parent:parents)
            {
                if(parent.left!=null)
                    current.add(parent.left);
                if(parent.right!=null)
                    current.add(parent.right);
            }
        }
        return result;
    }

    void create(TreeNode root,ArrayList<LinkedList<TreeNode>> lists,int level) {
        if (root == null)
            return;

        LinkedList<TreeNode> list = null;

        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }
        else
        {
            list=lists.get(level);
        }
        list.add(root);
        create(root.left,lists,level+1);
        create(root.right,lists,level+1);
    }

    ArrayList<LinkedList<TreeNode>> create1(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result=new ArrayList<LinkedList<TreeNode>>();
        create(root,result,0);
        return result;
    }
}
