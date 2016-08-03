<<<<<<< HEAD
package com.beisert.onlinecv.gwt.server.util;
=======
package com.beisert.onlinecv.util;
>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellExecute {

    private static class StreamHandler extends Thread {

        BufferedReader stdInput;

        public StreamHandler(InputStream in) {
            this.stdInput = new BufferedReader(new InputStreamReader(in));
        }

        @Override
        public void run() {
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            try {
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void run(final String cmd) {

        Thread t1 = new Thread() {
            public void run() {
                _exec(cmd);
            }
        };
        t1.start();

		  try {
            t1.join();
        } catch (InterruptedException e) {
            //Can be ignored
        }
    }

    public static void _exec(String cmd) {
        try {

            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec(cmd);
            Thread tOut = new StreamHandler(p.getInputStream());
            // read the output from the command
            Thread tErr = new StreamHandler(p.getErrorStream());
            tOut.start();
            tErr.start();

        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }

    }
}
