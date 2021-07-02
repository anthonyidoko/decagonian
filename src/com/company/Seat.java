package com.company;

public class Seat {

    private String [][] seatList;
    private int cinemaSeatRows;
    private int cinemaSeatColumns;

    public String[][] getSeatList() {
        return seatList;
    }

    public void setSeatList(String[][] seatList) {
        this.seatList = seatList;
    }

    public int getCinemaSeatRows() {
        return cinemaSeatRows;
    }

    public void setCinemaSeatRows(int cinemaSeatRows) {
        this.cinemaSeatRows = cinemaSeatRows;
    }

    public int getCinemaSeatColumns() {
        return cinemaSeatColumns;
    }

    public void setCinemaSeatColumns(int cinemaSeatColumns) {
        this.cinemaSeatColumns = cinemaSeatColumns;
    }

    public String [][] showSeat(String [][] seatList, int cinemaSeatRows, int cinemaSeatColumns){
        for (int i = 0; i < cinemaSeatRows; i ++){
            for(int j = 0; j < cinemaSeatColumns; j++){
                seatList[i][j] = " S  ";
            }
        }
        return seatList;
    }
}

