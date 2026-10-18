package cse213._starhotel_2311978;

import java.time.LocalDate;

public class Room {

    private int roomNo, capacity, ratePerNightinUSD;
    private String roomType;
    private boolean isSeaViewRoom;
    private LocalDate lastRenovationDate;

    public Room(int roomNo, int capacity, int ratePerNightinUSD, String roomType, boolean isSeaViewRoom, LocalDate lastRenovationDate) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.ratePerNightinUSD = ratePerNightinUSD;
        this.roomType = roomType;
        this.isSeaViewRoom = isSeaViewRoom;
        this.lastRenovationDate = lastRenovationDate;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRatePerNightinUSD() {
        return ratePerNightinUSD;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isSeaViewRoom() {
        return isSeaViewRoom;
    }

    public LocalDate getLastRenovationDate() {
        return lastRenovationDate;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRatePerNightinUSD(int ratePerNightinUSD) {
        this.ratePerNightinUSD = ratePerNightinUSD;
    }

    public void setLastRenovationDate(LocalDate lastRenovationDate) {
        this.lastRenovationDate = lastRenovationDate;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", capacity=" + capacity +
                ", ratePerNightinUSD=" + ratePerNightinUSD +
                ", roomType='" + roomType + '\'' +
                ", isSeaViewRoom=" + isSeaViewRoom +
                ", lastRenovationDate=" + lastRenovationDate +
                '}';
    }
}
