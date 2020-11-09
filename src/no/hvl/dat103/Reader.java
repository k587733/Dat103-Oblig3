package no.hvl.dat103;

import static java.lang.Thread.sleep;

public class Reader implements Runnable {


    private MySemaphore mutex, wrt;
    private Buffer buffer;
    private int idTall;

    public Reader(MySemaphore mutex, MySemaphore wrt, Buffer buffer, int idTall) {
        this.mutex = mutex;
        this.wrt = wrt;
        this.buffer = buffer;
        this.idTall = idTall;

    }

    @Override
    public void run() {
        do {
            mutex.vent();
            buffer.setReadCount(buffer.getReadCount() + 1);
            if(buffer.getReadCount() == 1) {
                wrt.vent();
            }
            mutex.signal();
            System.out.println("READER" + idTall + " LESER: " + buffer.les());
            mutex.vent();
            buffer.setReadCount(buffer.getReadCount() - 1);
            if(buffer.getReadCount() == 0) {
                wrt.signal();
            }
            mutex.signal();
            try {sleep(100);}catch (InterruptedException e) {e.printStackTrace();}


        } while (true);
    }

}
