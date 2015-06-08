package tests;

import com.artem.binarysearchtree.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {
    @Test
     public void addShouldAddToEmptyTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        assertEquals("100", binarySearchTree.toString());
    }

    @Test
    public void addShouldHandleExistingValue() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(100);
        assertEquals("100", binarySearchTree.toString());
    }

    @Test
    public void addShouldAddToTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.add(125);
        binarySearchTree.add(175);
        assertEquals("25, 50, 75, 100, 125, 150, 175", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleEmptyTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.remove(100);
        assertEquals("", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.remove(100);
        assertEquals("", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleRootWithRightChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(150);
        binarySearchTree.remove(100);
        assertEquals("150", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleRootWithLeftChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.remove(100);
        assertEquals("50", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleRootWithBothChildren() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.remove(100);
        assertEquals("50, 150", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleNodeWithoutChildren() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.remove(50);
        assertEquals("100, 150", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleNodeWithLeftChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(25);
        binarySearchTree.remove(50);
        assertEquals("25, 100, 150", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleNodeWithRightChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(75);
        binarySearchTree.remove(50);
        assertEquals("75, 100, 150", binarySearchTree.toString());
    }

    @Test
    public void removeShouldHandleNodeWithBothChildren() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.remove(50);
        assertEquals("25, 75, 100, 150", binarySearchTree.toString());
    }

    @Test(expected = NullPointerException.class)
    public void getMinValueShouldHandleEmptyTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.getMinValue();
    }

    @Test
    public void getMinValueShouldHandleRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        assertEquals(100, binarySearchTree.getMinValue());
    }

    @Test
    public void getMinValueShouldHandleRootWithRightChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(150);
        assertEquals(100, binarySearchTree.getMinValue());
    }

    @Test
    public void getMinValueShouldHandleRootWithLeftChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(75);
        assertEquals(75, binarySearchTree.getMinValue());
    }

    @Test
    public void getMinValueShouldHandleTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.add(125);
        binarySearchTree.add(175);
        assertEquals(25, binarySearchTree.getMinValue());
    }

    @Test(expected = NullPointerException.class)
    public void getMaxValueShouldHandleEmptyTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.getMaxValue();
    }

    @Test
    public void getMaxValueShouldHandleRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        assertEquals(100, binarySearchTree.getMaxValue());
    }

    @Test
    public void getMaxValueShouldHandleRootWithRightChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(150);
        assertEquals(150, binarySearchTree.getMaxValue());
    }

    @Test
    public void getMaxValueShouldHandleRootWithLeftChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(75);
        assertEquals(100, binarySearchTree.getMaxValue());
    }

    @Test
    public void getMaxValueShouldHandleTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.add(125);
        binarySearchTree.add(175);
        assertEquals(175, binarySearchTree.getMaxValue());
    }

    @Test
    public void containsShouldHandleEmptyTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertFalse(binarySearchTree.contains(100));
    }

    @Test
    public void containsShouldHandleTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(50);
        binarySearchTree.add(150);
        binarySearchTree.add(25);
        binarySearchTree.add(75);
        binarySearchTree.add(125);
        binarySearchTree.add(175);
        assertTrue(binarySearchTree.contains(25));
        assertTrue(binarySearchTree.contains(50));
        assertTrue(binarySearchTree.contains(150));
        assertTrue(binarySearchTree.contains(25));
        assertTrue(binarySearchTree.contains(75));
        assertTrue(binarySearchTree.contains(125));
        assertTrue(binarySearchTree.contains(175));
    }
}
