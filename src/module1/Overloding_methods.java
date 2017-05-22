package module1;

import de.fhpotsdam.unfolding.UnfoldingMap;

public class Overloding_methods {
	
	/*
	 * itt az UnfoldingMap-nek azt az overload-olt változatát használjuk
	 * amelyiknek hat paramétere van.
	 * De van olyan method-ja is amiben csak egy paraméter van lsd:
	 * http://unfoldingmaps.org/javadoc/
	 */
	map1 = new UnfoldingMap(this, 50, 50, 350, 500, provider);
}

/*
 * Nem megengedett, hogy a név, paraméterlista megegyezzen és 
 * csak a return type térjen el.
*/

public double distance(SimpleLocation other) {
	
}
/*ez az alsó nem megengedett, mert a compiler javac egyszerre használja
* a return type-ot és a paraméterlistát az overloaded method kiválasztására
* és itt csak a return type tér el a fentitől:
*/	
public int distance(SimpleLocation other) {

}

/*
 * Question:
 * When it is OK to have an overloaded method 
 * (i.e., method with the same name as another method)
 * that has a different return type?
 * Answer:
 * Only when the parameter list is also different.
 * 
 * The two parts of a method signature are the method name and the 
 * parameter list (number, type, and order of parameters)
 * As long as the parameter list differs, java allows you to overload
 * the method, and even change the return type because the return type
 * is not part of the method signature (it is ignored).
 */