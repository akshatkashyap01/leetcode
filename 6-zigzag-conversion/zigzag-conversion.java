class Solution {
    public String convert(String s, int r) {
        if(r == 1 || r >= s.length()) return s;
        List<Character>[] rows = new ArrayList[r];
        for(int i = 0; i < r; i++) rows[i] = new ArrayList<>();

        int direction = 1, row = 0;
        for(int i = 0; i < s.length(); i++) {
            rows[row].add(s.charAt(i));
            if(row == 0) direction = 1;
            else if(row == r - 1) direction = -1;
            row += direction;
        }

        StringBuilder sb = new StringBuilder();
        for(List<Character> rowChar : rows) {
            for(char c : rowChar) sb.append(c);
        }

        return sb.toString();
    }
}