/***************************************************************
Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1

push(int element) - push the element to top
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
**************************************************************/
/***************************************************************
public class Solution {
  private Stack<Integer> s1 = new Stack<Integer>(); // input

  private Stack<Integer> s2 = new Stack<Integer>(); // buffer & output;
  
  private int globalMin;

  public Solution() {
    // write your solution here
  }
  
  public int pop() {
  	if (s1.empty()) {
  		return -1;	
  	}
  	else if (s2.empty()) {
  		return s1.pop();
  	}
  	else {
  		int temp = s1.pop();
  		if (temp == globalMin) {
  			globalMin = s2.pop();
  			return temp;
  		}
  		else {
  			return s2.pop();
  		}
  	}
  }
  
  public void push(int element) {
  	if (s1.empty()) {
  		s1.push(element);
  		globalMin = element;	
  	}
  	else {
  		s1.push(element);
  		if (element < globalMin) {
	  		int temp = globalMin;
	  		globalMin = element;
	  		element = temp;
	  	}
	  }
  	s2.push(element);
  }

  public int top() {
  	if (s1.empty()) {
  		return -1;	
  	}
  	else {
  		return s1.peek();
  	}
  }
  
  public int min() {
  	if (s1.empty() || s2.empty()) {
  		globalMin = -1;
  	}
    return globalMin;
  }
}

Input: null

input: push(6),min(),push(5),push(9),top(),min(),pop(),min(),top().min(),pop(),min()
output: [6, 9, 5, 9, 5, 5, 5, 6, 6]
expected:<[6, 9, 5, 9, 5, 5, 5, 5, 6]> 
 but was:<[6, 9, 5, 9, 5, 5, 5, 6, 6]>
**************************************************************************/
public class Solution {
  private Deque<Integer> stack = new ArrayDeque<>();
  private Deque<Integer> minStack = new ArrayDeque<>();

  public Solution() {

  }

  public Integer pop () {
    if (stack.isEmpty()) {
      return null
    }
    int temp = stack.pollFirst();
    if (temp == minStack.peekFirst()) {
      minStack.pollFirst();
    }
    return temp;
  }

  public void push(int ele) {
    if (minStack.isEmpty() || ele <= minStack.peekFirst()) {
      minStack.offerFirst(ele);
    }
    stack.offerFirst(ele);
  }

  public Integer top() {
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peekFirst();
  }

  public Integer min() {
    if (minStack.isEmpty()) {
      return null;
    }
    return minStack.pollFirst();
  }

}