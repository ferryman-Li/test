package org.qnit.common.util;

import java.io.File;

public class FileDeleteBak {
    public static void main(String[] args) {
        File file = new File("D:/test.txt");
        if (file.exists()) {
            file.delete();
        }
    }
}
