package trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTree {
    private class MyNode{
        private int value;
        private MyNode left;
        private MyNode right;

        public MyNode(int value) {
            this.value = value;
        }

        public void setLeft(MyNode left) {
            this.left = left;
        }

        public void setRight(MyNode right) {
            this.right = right;
        }

        public MyNode getLeft() {
            return left;
        }

        public MyNode getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyNode myNode = (MyNode) o;

            if (value != myNode.value) return false;
            if (left != null ? !left.equals(myNode.left) : myNode.left != null) return false;
            return right != null ? right.equals(myNode.right) : myNode.right == null;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }

    MyNode sumNodes(MyNode root){

        MyNode base = root;
        int sum = getSum(root);
        int recalced = recalc(root, sum);

        return base;

    }

    int getSum(MyNode root){
        if(null == root){
            return 0;
        }
        return root.value + getSum(root.getLeft()) + getSum(root.getRight());
    }

    int recalc(MyNode node, int sum){
        if(node.getLeft() == null && node.getRight() == null){
            int sumOfGreaterVls = sum - node.getValue();
            node.setValue(sumOfGreaterVls);
            return sumOfGreaterVls;
        }

        if(node.getLeft() != null){
            sum = recalc(node.getLeft(), sum) - node.getValue();
            node.setValue(sum);
        }

        if(node.getRight() != null){
            sum = recalc(node.getRight(), sum);
        }
        return sum;
    }

    @Test
    public void testTreeSum(){
        MyNode root = new MyNode(5);
        root.setLeft(new MyNode(3));
        root.setRight(new MyNode(7));
        root.getLeft().setLeft(new MyNode(2));
        root.getLeft().setRight(new MyNode(4));
        root.getRight().setLeft(new MyNode(6));
        root.getRight().setRight(new MyNode(8));

        MyNode root2 = new MyNode(21);
        root2.setLeft(new MyNode(30));
        root2.setRight(new MyNode(8));
        root2.getLeft().setLeft(new MyNode(33));
        root2.getLeft().setRight(new MyNode(26));
        root2.getRight().setLeft(new MyNode(15));
        root2.getRight().setRight(new MyNode(0));

        assertEquals(root2, sumNodes(root));
        sumNodes(root2);
        ;
    }
}
