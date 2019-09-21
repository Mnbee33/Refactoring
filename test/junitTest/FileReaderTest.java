package junitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {
    private FileReader input;
    private FileReader empty;

    @BeforeEach
    void setUp() {
        try {
            input = new FileReader("data.txt");
            empty = newEmptyFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FileReader newEmptyFile() throws IOException {
        File empty = new File("empty.txt");
        FileOutputStream out = new FileOutputStream(empty);
        out.close();
        return new FileReader(empty);
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
        assertEquals(-1, input.read(), "read at end");
    }

    @Test
    void testReadBoundaries() throws Exception {
        assertEquals('a', input.read(), "read first char");
        int ch;
        for (int i = 0; i < 8; i++) {
            ch = (char) input.read();
        }
        assertEquals('j', input.read(), "read last char");
        assertEquals(-1, input.read(), "read at end");
        assertEquals(-1, input.read(), "read past end");
    }

    @Test
    void testEmptyRead() throws Exception {
        assertEquals(-1, empty.read());
    }

    @Test
    void testReadAfterClose() throws Exception {
        input.close();
        assertThrows(IOException.class, () -> input.read());
    }
}
