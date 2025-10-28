package theater.model;

public class TheaterModel {
    private Seat[][] seats;
    private int rows;
    private int cols;

    public TheaterModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seats = new Seat[rows][cols];
        initializeSeats();
    }

    private void initializeSeats(){
        for (int i = 0; i < rows; i++) {
            char rowLetter = (char)('A'+i);
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(rowLetter+String.valueOf(j+1));
            }
        }
    }

    public Seat[][] getSeats() {
        return seats;
    }
    // 여기 뜯어보기
    public boolean isValid(String seatId){
        if(seatId == null || seatId.length()<2) return false;

        seatId = seatId.toUpperCase();
        char row = seatId.charAt(0);
        int rowIndex = row - 'A';

        try {
            int colIndex = Integer.parseInt(seatId.substring(1))-1;
            return rowIndex>=0 && rowIndex<rows
                    && colIndex>=0&&colIndex<cols;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isReserved(String seatId){
        Seat seat  = findSeat(seatId);
        return seat !=null && seat.isReserved();
        // 널이 아니고 예약된 좌석이면 true

    }

    private Seat findSeat(String seatId) {
        if(!isValid(seatId)) return null;
        seatId = seatId.toUpperCase();
        int row = seatId.charAt(0)-'A';
        int col = Integer.parseInt(seatId.substring(1))-1;
        return seats[row][col];
    }

    public boolean reserve(String seatId){
        Seat seat = findSeat(seatId);
        if(seat==null||seat.isReserved()) return false;
        seat.reserve();
        return true;
    }

    public boolean cancel(String seatId){
        Seat seat = findSeat(seatId);
        if(seat==null||!seat.isReserved()) return false;
        seat.cancel();
        return true;
    }

    public int getTotalSeats(){
        return rows*cols;
    }
    public int getReservedCount(){
        int count =0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if(seat.isReserved()) count++;
            }
        }
        return count;
    }

    public int getAvailableCount(){
        return getTotalSeats()-getReservedCount();
    }
}

