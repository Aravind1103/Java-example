package com.dp.prototype;

/**
 * Prototype is a creation design pattern that lets you copy existing objects without making your code dependent on their classes.
 *
 * link: https://refactoring.guru/design-patterns/prototype
 */

public interface BookShop extends Cloneable {

    void printBookDetails();

    BookShop clone();
}
