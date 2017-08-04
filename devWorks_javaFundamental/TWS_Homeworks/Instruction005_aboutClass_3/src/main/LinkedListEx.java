package main;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListEx {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList<String>();	// string을 담는 LinkedList 객체화.
		
		ll.add("This is a ");						// LinkedList 안에 값을 넣을때는
		ll.add("Linked list. ");					// add를 이용한다.
		ll.add("You know what I'm saying?");
		
		Iterator<String> llLoop = ll.iterator();	// ll객체의 iterator()메소드를 활용해서 Iterator객체를 가져온다.
		while(llLoop.hasNext()) {					// 가져온 Iterator객체의 hasNext, next메소드를 활용해서
			System.out.println("llLoop객체의 hasNext()메소드의 현재 값 : " + llLoop.hasNext());
			System.out.println(llLoop.next());		// 리스트의 내용을 출력한다.
		}
		System.out.println("");
		/* hasNext()
		 * 현재 저장한 위치에서 다음 데이터가 있는지 없는지를 확인한다. 
		 * 리턴은 true/false
		 * true :	다음 데이터가 있다.
		 * false :	다음 데이터가 없다.
		 * 참고>
		 * hasNext를 쓰지 않을 경우, 리스트의 마지막 데이터를 넘어서
		 * 없는 데이터를 찾으려고 할 수 있다. 그러면 noSuchElementException이 발생할 수 있다.
		 * 그러므로 hasNext()를 쓰던가, try/catch로 예외처리를 해 주자.
		*/
		
		/* next()
		 * 다음 데이터를 가져온다.
		*/
		
		
		/* removeLast()메소드
		 * linkedList객체의 마지막 데이터를 지운다.
		*/
		System.out.println("removeLast()test");
		ll.removeLast();
		llLoop = ll.iterator();	
		while(llLoop.hasNext()) {					
			System.out.println(llLoop.next());		
		}
		System.out.println("");
		
		/* addLast()메소드
		 * linkedList객체의 마지막 데이터를 더한다.
		*/
		System.out.println("addLast()test");
		ll.addLast("Last data's back!");
		llLoop = ll.iterator();	
		while(llLoop.hasNext()) {					
			System.out.println(llLoop.next());		
		}
		System.out.println("");
		
	}

}
