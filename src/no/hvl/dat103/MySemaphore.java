package no.hvl.dat103;

import static java.lang.Thread.sleep;

public class MySemaphore {

    private int tall;

    public MySemaphore(int tall) {
        this.tall = tall;
    }

    public void vent() {
        while (this.tall <= 0) {
            //do nothing
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.tall--;
    }
    public void signal() {
        this.tall++;
    }

    public int getTall() {
        return this.tall;
    }
}

