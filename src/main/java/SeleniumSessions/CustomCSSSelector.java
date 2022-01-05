package SeleniumSessions;

public class CustomCSSSelector {

//	css is slightly faster than xpath because it starts searching from the tag, wherese  xpath is slower since it starts from the parent tags, 
//	but gives more options and flexibility by xpath Axes for complex DOMs.
	
	public static void main(String[] args) {
/*
 * 	for id: # {id value}
 * #username  --> # is used for id
 * input#username
 * input[id='username']
 * input[id='username'][type='email'] --> same as "and" operator in xpath
 * 
 * 	for class: . it starts with .
 * .w3-row.w3-center.w3-small
 * htmltaq.w3-row.w3-center.w3-small
 * input.w3-row.w3-center.w3-small
 * input.w3-row.
 * input.w3-small
 * 
 * text:
 * input[id^='username'] --> starting text
 * input[id$='username'] or input[id$='name'] --> ending text
 * 
 * contains: 
 * input[id*='username']
 * input[id*='user']
 * 
 * parent to child:
 * div>input[#username]
 * div.w3.small>input#username --> combination of parent with class attribute to child tag with id attribute
 *  
 * 
 * 
 * 
 * 
 */

	}

}
