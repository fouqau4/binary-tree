package com.jszheng.searchtree;

import com.jszheng.base.BinaryTree;
import com.jszheng.manipulator.BinTreeManipulator;
import com.jszheng.search.SearchResult;

public abstract class AbstractBstManipulator<T extends BinarySearchTree> extends BinTreeManipulator<T> {

    public AbstractBstManipulator(Class dataType) {
        super(dataType);
    }

    @Override
    protected void addDeleteOp() {
        super.addDeleteOp();
        addOperation("delete", bt -> {
            Object input = getInput("Delete Data:");
            bt.delete((Comparable) input);

            printTree();
        });
    }

    @Override
    protected void comment() {
        System.out.println("[註]: 二元搜尋樹");
        System.out.println("Delete 操作，預設採用中序前驅節點\n");
    }

    protected void addSearchOp() {
        super.addSearchOp();
        addOperation("search max", bt -> searchExtrema(bt, true));
        addOperation("search min", bt -> searchExtrema(bt, false));
    }

    private void searchExtrema(BinaryTree bt, boolean searchMax) {
        BinarySearchTree bst = ((BinarySearchTree) bt);
        SearchResult result = searchMax ? bst.searchMax() : bst.searchMin();

        if (result != null && result.getNode() != null)
            System.out.println((searchMax ? "Max: " : "Min: ")
                    + bst.getNodeString(result.getNode()));
    }
}