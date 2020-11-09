package no.hvl.dat103;

import java.util.*;

public class Buffer {

    private List<String> list;
    private int readCount;
    private Random rand = new Random();


    public Buffer() {
        readCount = 0;
        list = new ArrayList<>();
    }


    public void skriv(String s) {

        list.add(s);
        //System.out.println("add " + s + " to list");
    }



    public boolean listIsEmpty() {
        return list.isEmpty();
    }

    public List<String> getList() {
        return list;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String les() {
        int randomTall = rand.nextInt(list.size());
        return list.get(randomTall);
    }
}