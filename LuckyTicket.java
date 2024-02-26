class LuckyTicket {
    public static void main(String[] args) {
        int number_of_lucky_tickets = 0;
        for (int i = 1001; i < 1000000; i++) {
            int x = i / 100000 % 10;
            int y = i / 10000 % 10;
            int z = i / 1000 % 10;
            int m = i / 100 % 10;
            int n = i / 10 % 10;
            int k = i % 10;
            if ((x + y + z) == (m + n + k)) {
                number_of_lucky_tickets++;
            }
        }
        System.out.print(number_of_lucky_tickets);
    }
}