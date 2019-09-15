package videoRental;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementTest {
    private Customer c;
    private String result;

    @BeforeEach
    void setUp() {
        c = new Customer("Alice");
    }

    @AfterEach
    void tearDown() {
        System.out.println(result);
    }

    @DisplayName("延滞なしのレギュラー１本")
    @Test
    void TestRentARegularMovie() {
        Movie m = new Movie("Lion King", Movie.REGULAR);
        Rental r = new Rental(m, 2);
        c.addRental(r);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for Alice\n");
        expected.append("\tLion King\t2.0\n");
        expected.append("Amount owed is 2.0\n");
        expected.append("You earned 1 frequent renter points");

        result = c.statement();
        assertEquals(expected.toString(), result);
    }

    @DisplayName("延滞ありのレギュラー１本")
    @Test
    void TestRentDelayRegularMovie() {
        Movie m = new Movie("Lion King", Movie.REGULAR);
        Rental r = new Rental(m, 3);
        c.addRental(r);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for Alice\n");
        expected.append("\tLion King\t3.5\n");
        expected.append("Amount owed is 3.5\n");
        expected.append("You earned 1 frequent renter points");

        result = c.statement();
        assertEquals(expected.toString(), result);
    }

    @DisplayName("新作１本")
    @Test
    void TestRentANewReleaseMovie() {
        Movie m = new Movie("Beauty And Beast", Movie.NEW_RELEASE);
        Rental r = new Rental(m, 2);
        c.addRental(r);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for Alice\n");
        expected.append("\tBeauty And Beast\t6.0\n");
        expected.append("Amount owed is 6.0\n");
        expected.append("You earned 2 frequent renter points");

        result = c.statement();
        assertEquals(expected.toString(), result);
    }

    @DisplayName("延滞なしの子供料金１本")
    @Test
    void TestRentAChildrenMovie() {
        Movie m = new Movie("Little Mermaid", Movie.CHILDREN);
        Rental r = new Rental(m, 3);
        c.addRental(r);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for Alice\n");
        expected.append("\tLittle Mermaid\t1.5\n");
        expected.append("Amount owed is 1.5\n");
        expected.append("You earned 1 frequent renter points");

        result = c.statement();
        assertEquals(expected.toString(), result);
    }

    @DisplayName("延滞ありの子供料金1本")
    @Test
    void TestRentDelayChildrenMovie() {
        Movie m = new Movie("Little Mermaid", Movie.CHILDREN);
        Rental r = new Rental(m, 4);
        c.addRental(r);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for Alice\n");
        expected.append("\tLittle Mermaid\t3.0\n");
        expected.append("Amount owed is 3.0\n");
        expected.append("You earned 1 frequent renter points");

        result = c.statement();
        assertEquals(expected.toString(), result);
    }

    @DisplayName("いっぱい借りた")
    @Test
    void TestRentMovies() {
        Movie lionKing = new Movie("Lion King", Movie.REGULAR);
        Rental rl = new Rental(lionKing, 2);
        c.addRental(rl);

        Movie beautyAndBeast = new Movie("Beauty And Beast", Movie.NEW_RELEASE);
        Rental rb = new Rental(beautyAndBeast, 2);
        c.addRental(rb);

        Movie littleMermaid = new Movie("Little Mermaid", Movie.CHILDREN);
        Rental rm = new Rental(littleMermaid, 3);
        c.addRental(rm);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for Alice\n");
        expected.append("\tLion King\t2.0\n");
        expected.append("\tBeauty And Beast\t6.0\n");
        expected.append("\tLittle Mermaid\t1.5\n");
        expected.append("Amount owed is 9.5\n");
        expected.append("You earned 4 frequent renter points");

        result = c.statement();
        assertEquals(expected.toString(), result);
    }

    @DisplayName("HTML形式の出力：延滞なしのレギュラー１本")
    @Test
    void TestRentARegularMovieOnHTML() {
        Movie m = new Movie("Lion King", Movie.REGULAR);
        Rental r = new Rental(m, 2);
        c.addRental(r);

        StringBuilder expected = new StringBuilder();
        expected.append("<h1>Rentals for <em>Alice</em></h1><p>\n");
        expected.append("Lion King: 2.0<br>\n");
        expected.append("<p>You owe <em>2.0</em><p>\n");
        expected.append("On this rental you earned <em>1</em> frequent renter points<p>");

        result = c.htmlStatement();
        assertEquals(expected.toString(), result);
    }
}