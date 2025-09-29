package org.asupranovich.leetcode.str;

public class Lc168ExcelSheetColumnTitle {

    public static void main(String[] args) {
        Lc168ExcelSheetColumnTitle solution = new Lc168ExcelSheetColumnTitle();
        String title = solution.convertToTitle(701);
        System.out.println(title);
    }

    public String convertToTitle(int columnNumber) {
        var nameBuilder = new StringBuilder();
        do {
            columnNumber--;
            nameBuilder.append(getChar(columnNumber % 26));
            columnNumber = columnNumber / 26;
        } while (columnNumber > 0);
        return nameBuilder.reverse().toString();
    }

    private char getChar(int number) {
        return (char)('A' + number);
    }

}
