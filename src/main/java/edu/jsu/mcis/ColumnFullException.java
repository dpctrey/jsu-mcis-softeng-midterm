package edu.jsu.mcis;

import java.io.*;

public class ColumnFullException extends RuntimeException {
        public ColumnFullException(String msg){
            super(msg);
		}
}