class Solution {
    public boolean doesAliceWin(String s) {
        return java.util.regex.Pattern.compile("[aeiou]").matcher(s).find();
    }
}