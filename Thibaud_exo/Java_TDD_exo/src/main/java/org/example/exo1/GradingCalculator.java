package org.example.exo1;

public class GradingCalculator {
    public int score;
    public int attendancePercentage;

    public GradingCalculator(int score, int attendancePercentage) {
        this.score = score;
        this.attendancePercentage = attendancePercentage;
    }

    public char getGrade() {
        if(score > 90 && attendancePercentage > 70) return 'O';
        else if(score > 80 && attendancePercentage > 60) return  'O';
        else if (score > 60 && attendancePercentage > 60) return  'O';
        else return 'O';
    }
}