QueueByTwoStacks.java
/***************************************
Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.

C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.

Assumptions

The elements in the queue are all Integers.
size() should return the number of elements buffered in the queue.
isEmpty() should return true if there is no element buffered in the queue, false otherwise.
**********************************************/

public class Solution {
  private Stack<Integer> s1 = new Stack<Integer>(); // input
  private Stack stack2<Integer> s2 = new Stack<Integer>(); // buffer && output
  private int size = 0;

  public Solution() {
    // Write your solution here.
    size = sizeOfS1 + sizeOfS2;

  }
  
  public Integer poll() {
  	if (this.isEmpty()) {
  		return -1;
  	}    
  	else {
  		// if (s1.empty()) {
  		// 	s2.pop();
  		// 	size -= 1;
  		// }
  		// else {
  		// 	while (!s1.empty()) {
  		// 		s2.push(s1.pop());	
  		// 	}
  		// 	s2.pop();
  		// 	size -= 1;
  		// }
  		if(s2.empty()) {
  			while (!s1.empty()) {
  				s2.push(s1.pop());
  			}
  		}
  	}
  	size -= 1;
  	return s2.pop();
  }
  
  public void offer(int element) {
    s1.push(element);
    size += 1;
  }
  
  public Integer peek() {
  	if (this.isEmpty()) {
  		return -1;
  	}    
  	else {
  		if(s2.empty()) {
  			while (!s1.empty()) {
  				s2.push(s1.pop());
  			}
  			return s2.peak();
  		}
  	}
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    if (s1.empty() == true && s2.empty == true) {
    	return true;
    }
    else {
    	return false;
    }
  }
}


Input: null

input: offer(1),peek(),size(),isEmpty(),poll(),peek(),size(),isEmpty()
output: [1, 1, false, 1, null, 1, true]
expected:<[1, 1, false, 1, null, 0, true]>
but was:<[1, 1, false, 1, null, 1, true]>