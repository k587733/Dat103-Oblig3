package no.hvl.dat103;

import static java.lang.Thread.sleep;

public class Writer implements Runnable {


    private MySemaphore wrt;
    private Buffer buffer;
    private int tall = 1;


    public Writer(MySemaphore wrt, Buffer buffer) {
        this.wrt = wrt;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do {

            wrt.vent();
            System.out.println("writing");
            try {sleep(10);}catch (InterruptedException e) {e.printStackTrace();}
            buffer.skriv("skrift" + tall);
            wrt.signal();
            System.out.println("sluttet å skrive");
            try {sleep(10);}catch (InterruptedException e) {e.printStackTrace();}
            tall++;
        } while (true);
    }

}

