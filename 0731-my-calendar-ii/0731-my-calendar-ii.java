class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> doubleBookings;

    public MyCalendarTwo() {
         bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] interval : doubleBookings) {
            if (Math.max(startTime, interval[0]) < Math.min(endTime, interval[1])) {
                return false;
            }
        }
        
        for (int[] interval : bookings) {
            if (Math.max(startTime, interval[0]) < Math.min(endTime, interval[1])) {
                doubleBookings.add(new int[] { Math.max(startTime, interval[0]), Math.min(endTime, interval[1]) });
            }
        }
        
        bookings.add(new int[] { startTime, endTime });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */