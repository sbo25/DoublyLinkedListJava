

	/** An instance is a doubly linked list. */
	public class DLinkedList<E> {
	    private Node head; // first node of linked list (null if none)
	    private Node tail; // last node of linked list (null if none)

	    private int size; // Number of values in the linked list.

	    /** Constructor: an empty linked list. */
	    public DLinkedList() {
	    }

	    /** Return the number of values in this list. */
	    public int size() {
	        return size;
	    }

	    /** Return the first node of the list (null if the list is empty). */
	    public Node getHead() {
	        return head;
	    }

	    /** Return the last node of the list (null if the list is empty). */
	    public Node getTail() {
	        return tail;
	    }

	    /** Return the value of node e of this list.
	     * Precondition: e must be a node of this list; it may not be null. */
	    public E valueOf(Node e) {
	        assert e != null;
	        return e.value;
	    }
	    
	    /** Return a representation of this list: its values, with adjacent
	     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
	     * 
	     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
	    public String toString() {
	    	
	    	Node next = head;
	    	String list = new String("[");
	    	while (next != null) {
	    		list = list + next.value.toString() + ", ";
	    		next = next.succ;
	    	}
	    	
	        return list;
	    }

	    /** Return a representation of this list: its values in reverse, with adjacent
	     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
	     * 
	     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
	    public String toStringReverse() {
	    	Node next = tail;
	    	String list = new String("[");
	    	while (next != null) {
	    		list = list + next.value.toString() + ", ";
	    		next = next.pred;
	    	}
	    	list = list + "]";
	    	list = list.replace(", ]","]");
	    	
	        return list;
	    }
	 
	    /** Insert value v in a new node at the beginning of the list and
	     * return the new node */
	    public Node prepend(E v) {
	        Node first = new Node(null, head, v);
	        
	        if (size==0) {
	        	head = tail = first;
	        }
	        else {
	        	head.pred = first;
		        head = first;
	        }
	        
	        size = size + 1;
	        
	        return first;
	    }

	    /** add value v in a new node at the end of the list and
	     * return the new node. */
	    public Node append(E v) {
	        Node last = new Node(tail, null, v);
	        
	        if (size==0) {
	        	head = tail = last;
	        }
	        else {
	        	tail.succ = last;
	        	tail = last;
	        }
	        
	        size = size +1;
	        
	        return last;
	    }

	    /** Insert value v in a new node before element e and
	     * return the new node.
	     * Precondition: e must be a node of this list; it may not be null. */
	    public Node insertBefore(E v, Node e) {
	    	
	    	Node before = new Node(e.pred, e, v);
	    	
	    	if (e == head) {
	    		prepend(v);
	    	}
	    	else {
	    		e.pred.succ = before;
	    		e.pred = before;
	    		size = size + 1;
	    	}
	        
	        return before;
	    }

	    /** Insert value v in a new node after node e and
	     * return the new node.
	     * Precondition: e must be an node of this list; it may not be null. */
	    public Node insertAfter(E v, Node e) {
	        
	    	Node after = new Node(e, e.succ, v);
	        
	    	if(e == tail) {
	        	append(v);
	        }
	        else {
	        	e.succ.pred = after;
	        	e.succ = after;
	        	size = size + 1;
	        }
	        
	        return after;
	    }

	    /** Remove node e from this list.
	     * Precondition: e must be a node of this list; it may not be null. */
	    public void remove(Node e) {
	        if (size == 1){
	        	head = tail = null;
	        }
	        else if (e == head) {
	    		head = e.succ;
	    		e.succ.pred = null;
	    	} 
	    	else if (e == tail) {
	    		tail = e.pred;
	    		e.pred.succ = null;
	    	}
	    	else {	
	    	e.pred.succ = e.succ;
	        e.succ.pred = e.pred;
	    	}
	        
	        size = size - 1;
	    } 
	    
	   
	    /*********************/

	    /** An instance is a node of this list. */
	    public class Node {
	        /** Predecessor of this node on the list (null if the list is empty). */
	        private Node pred;

	        /** The value of this element. */
	        private E value; 

	        /** Successor of this node on the list. (null if the list is empty). */
	        private Node succ; 

	        /** Constructor: an instance with predecessor p (p can be null),
	         * successor s (s can be null), and value v. */
	        private Node(Node p, Node s, E v) {
	            pred= p;
	            succ= s;
	            value= v;
	        }

	        /** Return the value of this node. */
	        public E getValue() {
	            return value;
	        }
	        
	        /** Return the predecessor of this node e in the list (null if e is the
	         * first node of this list). */
	        public Node predecessor() {
	            return pred;
	        }

	        /** Return the successor of this node in this list (null if e is the
	         * last node of this list). */
	        public Node successor() {
	            return succ;
	        }
	    }

	}


