package junitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {
    private FileReader input;

    @BeforeEach
    void setUp() {
        try {
            input = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("テストファイルがopenできない");
        }
    }

    @AfterEach
    void tearDown() {
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("テストファイルをcloseするときにエラー");
        }
    }

    @Test
    void testRead() throws Exception {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) input.read();
        }
        assertEquals('d', ch);
    }

    @Test
    void testReadAtEnd() throws Exception {
        int ch = -1234;
        for (int i = 0; i < 10; i++) {
            ch = (char) input.read();
        }
        assertEquals(-1, input.read());
    }
}
