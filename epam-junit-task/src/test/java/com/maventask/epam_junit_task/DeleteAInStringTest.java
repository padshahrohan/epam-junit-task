package com.maventask.epam_junit_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteAInStringTest {

	/* To-Do List
	 *  Remove A if it is present in first 2 characters of string.
	 * 1. empty string : "" = ""
	 * 2. 1 character(if character is A or not A) : "A" = "" / "B" = "B" / "C" = "C"  
	 * 3. 2 characters : "AA" = "" / "AB" = "B" / "BA" = "B" / "BB" = "BB" / "BC" = "BC"
	 * 4. 3 characters : "AAA" = "A" / "AAB" = "B" / "ABA" = "BA" / "ABB" = "BB" / "BAA" = "BA" / "BAB" = "BB" / "BBA" = "BBA" 
	 * 5. 4 characters : "ABBA" = "BBA"
	 * 6. N characters  : "ABBBBBFRG" = "BBBBBFRG" / "AAANNNNNAAA" = "ANNNNNAAA"
	 */

	DeleteAInString d ;
	
	@BeforeEach
	void createObject() {
		d = new DeleteAInString();
	}
	
	@Test
	void test1characters() {
		
		assertEquals("", d.deleteA("A"));
		assertEquals("B", d.deleteA("B"));
	}
	
	@Test
	void testemptycharacters() {
		
		assertEquals("", d.deleteA(""));	
	}
	
	
	@Test
	void test2characters() {
		
		assertEquals("", d.deleteA(""));
		assertEquals("", d.deleteA("AA"));
		assertEquals("B", d.deleteA("BA"));
		assertEquals("BB", d.deleteA("BB"));		
	}
	
	@Test
	void test3characters() {
		
		assertEquals("A", d.deleteA("AAA"));
		assertEquals("B", d.deleteA("AAB"));
		assertEquals("BA", d.deleteA("ABA"));
		assertEquals("BB", d.deleteA("ABB"));
		assertEquals("BA", d.deleteA("BAA"));
		assertEquals("BB", d.deleteA("BAB"));
		assertEquals("BBB", d.deleteA("BBB"));
		assertEquals("BX", d.deleteA("ABX"));
	}
	
	@Test
	void test4characters() {
		
		assertEquals("AA", d.deleteA("AAAA"));
		assertEquals("BCD", d.deleteA("ABCD"));
		assertEquals("BCD", d.deleteA("BACD"));
		assertEquals("BBAA", d.deleteA("BBAA"));
		assertEquals("BAA", d.deleteA("ABAA"));
		assertEquals("BAB", d.deleteA("ABAB"));
		assertEquals("BB", d.deleteA("AABB"));
		assertEquals("BAA", d.deleteA("BAAA"));
	}
	
	@Test
	void testNcharacters() {
		
		assertEquals("AABBBBCC", d.deleteA("AAAABBBBCC"));
		assertEquals("BBAAAAACD", d.deleteA("BBAAAAACD"));
		assertEquals("BCDBACD", d.deleteA("BACDBACD"));
		assertEquals("BBAAAXYZ", d.deleteA("BBAAAXYZ"));
	}

}
