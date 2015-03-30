import static org.junit.Assert.*;

import org.junit.Test;


public class DLinkedListTester {

	@Test
	public void test() {
			 DLinkedList<Integer> b= new DLinkedList<Integer>();
		
			 DLinkedList<Integer>.Node n = b.prepend(4);
			 assertEquals("[4]", b.toString());
			 assertEquals("[4]", b.toStringReverse());
			 assertEquals(1, b.size());
			 assertEquals(n, b.getHead());
		
			 Integer x = new Integer(5);
			 b.prepend(x);
			 assertEquals("[5, 4]", b.toString());
			 assertEquals("[4, 5]", b.toStringReverse());
			 assertEquals(2, b.size());
			 
			 DLinkedList<Integer> c= new DLinkedList<Integer>();
			 DLinkedList<Integer>.Node m = c.append(6);
			 assertEquals("[6]", c.toString());
			 assertEquals("[6]", c.toStringReverse());
			 assertEquals(1, c.size());
			 assertEquals(m, c.getTail());
			 
			 b.append(6);
			 assertEquals("[5, 4, 6]", b.toString());
			 assertEquals("[6, 4, 5]", b.toStringReverse());
			 assertEquals(3, b.size());
			 
			 DLinkedList<Integer>.Node p = b.insertBefore(7, b.getTail());
			 assertEquals("[5, 4, 7, 6]", b.toString());
			 assertEquals(b.getTail(), p.successor());
			 assertEquals(4, b.size());
			 
			 b.insertBefore(3, b.getHead());
		     assertEquals("[3, 5, 4, 7, 6]", b.toString());
		     assertEquals(5, b.size());
			
		     DLinkedList<Integer>.Node h = b.insertAfter(9, b.getHead());
		     assertEquals("[3, 9, 5, 4, 7, 6]", b.toString());
		     assertEquals(b.getHead(), h.predecessor());
		     assertEquals(6, b.size());
		     
		     b.insertAfter(1, b.getTail());
			 assertEquals("[3, 9, 5, 4, 7, 6, 1]", b.toString());
		     
		     b.remove(h);
		     assertEquals("[3, 5, 4, 7, 6, 1]", b.toString());
		     assertEquals(6, b.size());
		     
		     b.remove(b.getHead());
		     assertEquals("[5, 4, 7, 6, 1]", b.toString());
		     b.remove(b.getTail());
		     assertEquals("[5, 4, 7, 6]", b.toString());
		     
		     c.remove(m);
		     assertEquals("[]", c.toString());
		     assertEquals(0, c.size());
		     
		     
	}

}
