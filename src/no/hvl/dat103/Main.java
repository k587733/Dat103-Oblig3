package no.hvl.dat103;

public class Main {

    public static void main(String[] args) {
        MySemaphore mutex = new MySemaphore(1);
        MySemaphore wrt = new MySemaphore(1);
        Buffer buffer = new Buffer();

        new Thread(new Writer(wrt, buffer)).start();
        new Thread(new Reader(mutex, wrt, buffer, 1)).start();
        new Thread(new Reader(mutex, wrt, buffer, 2)).start();
    }

}