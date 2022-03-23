package com.puzzle;

public class Main {

    public static void main(String[] args) {
        Rubik cube = new Rubik();
        Rubik cube2 = new Rubik(cube, cube.frontCw());
        //Rubik cube3 = new Rubik(cube2, cube2.leftCw());
        //Rubik cube4 = new Rubik(cube3, cube3.rightCw());
        //Rubik cube5 = new Rubik(cube4, cube4.frontAcw());
        //Rubik cube6 = new Rubik(cube5, cube5.backCw());
        //Rubik cube7 = new Rubik(cube6, cube6.rightAcw());
        //Rubik cube8 = new Rubik(cube7, cube7.frontCw());
        //Rubik cube9 = new Rubik(cube8, cube8.backAcw());
        Rubik cube10 = new Rubik(cube2, cube2.leftCw());
        System.out.println(cube10);

        BreadthSolver solver = new BreadthSolver();
        System.out.println(solver.solve(cube10));
    }
}
