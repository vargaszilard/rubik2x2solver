package com.puzzle;

import java.util.*;

public class Rubik extends AbstractState{

    private enum Oldal { F, L, R, B, U, D}
    private enum Szin  { W, R, B, O, Y, G}

    private Map<Oldal, Szin[][]> kocka;

    public Rubik() {
        this.kocka = new HashMap<>();

        Szin[][] f = {{Szin.W, Szin.W}, {Szin.W, Szin.W}};
        Szin[][] l = {{Szin.G, Szin.G}, {Szin.G, Szin.G}};
        Szin[][] r = {{Szin.B, Szin.B}, {Szin.B, Szin.B}};
        Szin[][] b = {{Szin.Y, Szin.Y}, {Szin.Y, Szin.Y}};
        Szin[][] u = {{Szin.O, Szin.O}, {Szin.O, Szin.O}};
        Szin[][] d = {{Szin.R, Szin.R}, {Szin.R, Szin.R}};

        this.kocka.put(Oldal.F, f);
        this.kocka.put(Oldal.L, l);
        this.kocka.put(Oldal.R, r);
        this.kocka.put(Oldal.B, b);
        this.kocka.put(Oldal.U, u);
        this.kocka.put(Oldal.D, d);
    }

    public Rubik (Rubik parent, Map<Oldal, Szin[][]> newKocka) {
        super(parent);
        this.kocka = DeepCopyCube(newKocka);
    }

    public static HashMap<Oldal, Szin[][]> DeepCopyCube(Map<Oldal, Szin[][]> cube) {
        HashMap<Oldal, Szin[][]> newCube = new HashMap<>();

        cube.forEach( (side, color) -> {
            Szin[][] newColor = new Szin[2][2];

            newColor[0][0] = color[0][0];
            newColor[0][1] = color[0][1];
            newColor[1][0] = color[1][0];
            newColor[1][1] = color[1][1];

            newCube.put(side, newColor);
        } );
        return newCube;
    }

    // FRONT CLOCKWISE
    public Map<Oldal, Szin[][]> frontCw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.F)[0][0];
        tempCube.get(Oldal.F)[0][0] = tempCube.get(Oldal.F)[0][1];
        tempCube.get(Oldal.F)[0][1] = tempCube.get(Oldal.F)[1][1];
        tempCube.get(Oldal.F)[1][1] = tempCube.get(Oldal.F)[1][0];
        tempCube.get(Oldal.F)[1][0] = temp1;

        temp1 = tempCube.get(Oldal.U)[1][0];
        temp2 = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[1][0] = tempCube.get(Oldal.L)[0][1];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.L)[1][1];
        tempCube.get(Oldal.L)[0][1] = tempCube.get(Oldal.D)[0][0];
        tempCube.get(Oldal.L)[1][1] = tempCube.get(Oldal.D)[0][1];
        tempCube.get(Oldal.D)[0][0] = tempCube.get(Oldal.R)[1][0];
        tempCube.get(Oldal.D)[0][1] = tempCube.get(Oldal.R)[0][0];
        tempCube.get(Oldal.R)[1][0] = temp1;
        tempCube.get(Oldal.R)[0][0] = temp2;

        return tempCube;
    }

    // FRONT ANTICLOCKWISE
    public Map<Oldal, Szin[][]> frontAcw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.F)[0][0];
        tempCube.get(Oldal.F)[0][0] = tempCube.get(Oldal.F)[1][0];
        tempCube.get(Oldal.F)[1][0] = tempCube.get(Oldal.F)[1][1];
        tempCube.get(Oldal.F)[1][1] = tempCube.get(Oldal.F)[0][1];
        tempCube.get(Oldal.F)[0][1] = temp1;

        temp1 = tempCube.get(Oldal.U)[1][0];
        temp2 = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[1][0] = tempCube.get(Oldal.R)[0][0];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.R)[1][0];
        tempCube.get(Oldal.R)[0][0] = tempCube.get(Oldal.D)[0][1];
        tempCube.get(Oldal.R)[1][0] = tempCube.get(Oldal.D)[0][0];
        tempCube.get(Oldal.D)[0][1] = tempCube.get(Oldal.L)[1][1];
        tempCube.get(Oldal.D)[0][0] = tempCube.get(Oldal.L)[0][1];
        tempCube.get(Oldal.L)[1][1] = temp1;
        tempCube.get(Oldal.L)[0][1] = temp2;

        return tempCube;
    }

    // RIGHT CLOCKWISE
    public Map<Oldal, Szin[][]> rightCw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.R)[0][0];
        tempCube.get(Oldal.R)[0][0] = tempCube.get(Oldal.R)[1][0];
        tempCube.get(Oldal.R)[1][0] = tempCube.get(Oldal.R)[1][1];
        tempCube.get(Oldal.R)[1][1] = tempCube.get(Oldal.R)[0][1];
        tempCube.get(Oldal.R)[0][1] = temp1;

        temp1 = tempCube.get(Oldal.U)[0][1];
        temp2 = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[0][1] = tempCube.get(Oldal.F)[0][1];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.F)[1][1];
        tempCube.get(Oldal.F)[0][1] = tempCube.get(Oldal.D)[0][1];
        tempCube.get(Oldal.F)[1][1] = tempCube.get(Oldal.D)[1][1];
        tempCube.get(Oldal.D)[0][1] = tempCube.get(Oldal.B)[0][0];
        tempCube.get(Oldal.D)[1][1] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.B)[0][0] = temp2;
        tempCube.get(Oldal.B)[1][0] = temp1;

        return tempCube;
    }

    // RIGHT ANTICLOCKWISE
    public Map<Oldal, Szin[][]> rightAcw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.R)[0][0];
        tempCube.get(Oldal.R)[0][0] = tempCube.get(Oldal.R)[0][1];
        tempCube.get(Oldal.R)[0][1] = tempCube.get(Oldal.R)[1][1];
        tempCube.get(Oldal.R)[1][0] = temp1;
        tempCube.get(Oldal.R)[1][1] = tempCube.get(Oldal.R)[1][1];

        temp1 = tempCube.get(Oldal.U)[0][1];
        temp2 = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[0][1] = tempCube.get(Oldal.B)[1][0];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.B)[0][0];
        tempCube.get(Oldal.B)[0][0] = tempCube.get(Oldal.D)[1][1];
        tempCube.get(Oldal.B)[1][0] = tempCube.get(Oldal.D)[0][1];
        tempCube.get(Oldal.D)[0][1] = tempCube.get(Oldal.F)[0][1];
        tempCube.get(Oldal.D)[1][1] = tempCube.get(Oldal.F)[1][1];
        tempCube.get(Oldal.F)[0][1] = temp1;
        tempCube.get(Oldal.F)[1][1] = temp2;

        return tempCube;
    }

    // LEFT CLOCKWISE
    public Map<Oldal, Szin[][]> leftCw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.L)[0][0];
        tempCube.get(Oldal.L)[0][0] = tempCube.get(Oldal.L)[0][1];
        tempCube.get(Oldal.L)[1][0] = temp1;
        tempCube.get(Oldal.L)[1][1] = tempCube.get(Oldal.L)[1][0];
        tempCube.get(Oldal.L)[0][1] = tempCube.get(Oldal.L)[1][1];

        temp1 = tempCube.get(Oldal.U)[0][0];
        temp2 = tempCube.get(Oldal.U)[1][0];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.F)[0][0];
        tempCube.get(Oldal.U)[1][0] = tempCube.get(Oldal.F)[1][0];
        tempCube.get(Oldal.F)[0][0] = tempCube.get(Oldal.D)[0][0];
        tempCube.get(Oldal.F)[1][0] = tempCube.get(Oldal.D)[1][0];
        tempCube.get(Oldal.D)[0][0] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.D)[1][0] = tempCube.get(Oldal.B)[0][1];
        tempCube.get(Oldal.B)[0][1] = temp2;
        tempCube.get(Oldal.B)[1][1] = temp1;

        return tempCube;
    }

    // LEFT ANTICLOCKWISE
    public Map<Oldal, Szin[][]> leftAcw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.L)[0][0];
        tempCube.get(Oldal.L)[0][0] = tempCube.get(Oldal.L)[1][0];
        tempCube.get(Oldal.L)[1][0] = tempCube.get(Oldal.L)[1][1];
        tempCube.get(Oldal.L)[1][1] = tempCube.get(Oldal.L)[0][1];
        tempCube.get(Oldal.L)[0][1] = temp1;

        temp1 = tempCube.get(Oldal.U)[0][0];
        temp2 = tempCube.get(Oldal.U)[1][0];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.U)[1][0] = tempCube.get(Oldal.B)[0][1];
        tempCube.get(Oldal.B)[0][1] = tempCube.get(Oldal.D)[1][0];
        tempCube.get(Oldal.B)[1][1] = tempCube.get(Oldal.D)[0][0];
        tempCube.get(Oldal.D)[0][0] = tempCube.get(Oldal.F)[0][0];
        tempCube.get(Oldal.D)[1][0] = tempCube.get(Oldal.F)[1][0];
        tempCube.get(Oldal.F)[0][0] = temp1;
        tempCube.get(Oldal.F)[1][0] = temp2;

        return tempCube;
    }

    // UP CW
    public Map<Oldal, Szin[][]> upCw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.U)[0][0];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.U)[1][0];
        tempCube.get(Oldal.U)[1][0] = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.U)[0][1];
        tempCube.get(Oldal.U)[0][1] = temp1;

        temp1 = tempCube.get(Oldal.F)[0][0];
        temp2 = tempCube.get(Oldal.F)[0][1];
        tempCube.get(Oldal.F)[0][0] = tempCube.get(Oldal.R)[0][0];
        tempCube.get(Oldal.F)[0][1] = tempCube.get(Oldal.R)[0][1];
        tempCube.get(Oldal.R)[0][0] = tempCube.get(Oldal.B)[0][0];
        tempCube.get(Oldal.R)[0][1] = tempCube.get(Oldal.B)[0][1];
        tempCube.get(Oldal.B)[0][0] = tempCube.get(Oldal.L)[0][1];
        tempCube.get(Oldal.B)[0][1] = tempCube.get(Oldal.L)[0][0];
        tempCube.get(Oldal.L)[0][0] = temp1;
        tempCube.get(Oldal.L)[0][1] = temp2;

        return tempCube;
    }

    // UP ACW
    public Map<Oldal, Szin[][]> upAcw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.U)[0][0];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.U)[0][1];
        tempCube.get(Oldal.U)[0][1] = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.U)[1][0];
        tempCube.get(Oldal.U)[1][0] = temp1;

        temp1 = tempCube.get(Oldal.F)[0][0];
        temp2 = tempCube.get(Oldal.F)[0][1];
        tempCube.get(Oldal.F)[0][0] = tempCube.get(Oldal.L)[0][0];
        tempCube.get(Oldal.F)[0][1] = tempCube.get(Oldal.L)[0][1];
        tempCube.get(Oldal.L)[0][0] = tempCube.get(Oldal.B)[0][1];
        tempCube.get(Oldal.L)[0][1] = tempCube.get(Oldal.B)[0][0];
        tempCube.get(Oldal.B)[0][0] = tempCube.get(Oldal.R)[0][0];
        tempCube.get(Oldal.B)[0][1] = tempCube.get(Oldal.R)[0][1];
        tempCube.get(Oldal.R)[0][0] = temp1;
        tempCube.get(Oldal.R)[0][1] = temp2;

        return tempCube;
    }

    // DOWN CW
    public Map<Oldal, Szin[][]> downCw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.D)[0][0];
        tempCube.get(Oldal.D)[0][0] = tempCube.get(Oldal.D)[0][1];
        tempCube.get(Oldal.D)[0][1] = tempCube.get(Oldal.D)[1][1];
        tempCube.get(Oldal.D)[1][1] = tempCube.get(Oldal.D)[1][0];
        tempCube.get(Oldal.D)[1][0] = temp1;

        temp1 = tempCube.get(Oldal.F)[1][0];
        temp2 = tempCube.get(Oldal.F)[1][1];
        tempCube.get(Oldal.F)[1][0] = tempCube.get(Oldal.R)[1][0];
        tempCube.get(Oldal.F)[1][1] = tempCube.get(Oldal.R)[1][1];
        tempCube.get(Oldal.R)[1][0] = tempCube.get(Oldal.B)[1][0];
        tempCube.get(Oldal.R)[1][1] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.B)[1][0] = tempCube.get(Oldal.L)[1][1];
        tempCube.get(Oldal.B)[1][1] = tempCube.get(Oldal.L)[1][0];
        tempCube.get(Oldal.L)[1][0] = temp1;
        tempCube.get(Oldal.L)[1][1] = temp2;

        return tempCube;
    }

    // DOWN ACW
    public Map<Oldal, Szin[][]> downAcw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.U)[0][0];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.U)[1][0];
        tempCube.get(Oldal.U)[1][0] = tempCube.get(Oldal.U)[1][1];
        tempCube.get(Oldal.U)[1][1] = tempCube.get(Oldal.U)[0][1];
        tempCube.get(Oldal.U)[0][1] = temp1;

        temp1 = tempCube.get(Oldal.F)[1][0];
        temp2 = tempCube.get(Oldal.F)[1][1];
        tempCube.get(Oldal.F)[1][0] = tempCube.get(Oldal.L)[1][0];
        tempCube.get(Oldal.F)[1][1] = tempCube.get(Oldal.L)[1][1];
        tempCube.get(Oldal.L)[1][0] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.L)[1][1] = tempCube.get(Oldal.B)[1][0];
        tempCube.get(Oldal.B)[1][0] = tempCube.get(Oldal.R)[1][0];
        tempCube.get(Oldal.B)[1][1] = tempCube.get(Oldal.R)[1][1];
        tempCube.get(Oldal.R)[1][0] = temp1;
        tempCube.get(Oldal.R)[1][1] = temp2;

        return tempCube;
    }

    // BACK CW
    public Map<Oldal, Szin[][]> backCw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.B)[0][0];
        tempCube.get(Oldal.B)[0][0] = tempCube.get(Oldal.B)[0][1];
        tempCube.get(Oldal.B)[0][1] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.B)[1][1] = tempCube.get(Oldal.B)[1][0];
        tempCube.get(Oldal.B)[1][0] = temp1;

        temp1 = tempCube.get(Oldal.U)[0][0];
        temp2 = tempCube.get(Oldal.U)[0][1];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.L)[1][0];
        tempCube.get(Oldal.U)[0][1] = tempCube.get(Oldal.L)[0][0];
        tempCube.get(Oldal.L)[0][0] = tempCube.get(Oldal.D)[1][0];
        tempCube.get(Oldal.L)[1][0] = tempCube.get(Oldal.D)[1][1];
        tempCube.get(Oldal.D)[1][0] = tempCube.get(Oldal.R)[1][1];
        tempCube.get(Oldal.D)[1][1] = tempCube.get(Oldal.R)[0][1];
        tempCube.get(Oldal.R)[0][1] = temp1;
        tempCube.get(Oldal.R)[1][1] = temp2;

        return tempCube;
    }

    // BACK ACW
    public Map<Oldal, Szin[][]> backAcw() {
        Map<Oldal, Szin[][]> tempCube = DeepCopyCube(this.kocka);

        Szin temp1;
        Szin temp2;

        temp1 = tempCube.get(Oldal.B)[0][0];
        tempCube.get(Oldal.B)[0][0] = tempCube.get(Oldal.B)[0][1];
        tempCube.get(Oldal.B)[0][1] = tempCube.get(Oldal.B)[1][1];
        tempCube.get(Oldal.B)[1][1] = tempCube.get(Oldal.B)[1][0];
        tempCube.get(Oldal.B)[1][0] = temp1;

        temp1 = tempCube.get(Oldal.U)[0][0];
        temp2 = tempCube.get(Oldal.U)[0][1];
        tempCube.get(Oldal.U)[0][0] = tempCube.get(Oldal.R)[0][1];
        tempCube.get(Oldal.U)[0][1] = tempCube.get(Oldal.R)[1][1];
        tempCube.get(Oldal.R)[0][1] = tempCube.get(Oldal.D)[1][1];
        tempCube.get(Oldal.R)[1][1] = tempCube.get(Oldal.D)[1][0];
        tempCube.get(Oldal.D)[1][0] = tempCube.get(Oldal.L)[0][0];
        tempCube.get(Oldal.D)[1][1] = tempCube.get(Oldal.L)[1][0];
        tempCube.get(Oldal.L)[0][0] = temp2;
        tempCube.get(Oldal.L)[1][0] = temp1;

        return tempCube;
    }

    @Override
    public Iterable<State> getPossibleMoves() {
        ArrayList<State> moves = new ArrayList<>();

        Rubik cube = new Rubik(this, this.frontCw());
        moves.add(cube);
        cube =new Rubik(this, this.frontAcw());
        moves.add(cube);

        cube = new Rubik(this, rightCw());
        moves.add(cube);
        cube = new Rubik(this, rightAcw());
        moves.add(cube);

        cube = new Rubik(this, leftCw());
        moves.add(cube);
        cube = new Rubik(this, leftAcw());
        moves.add(cube);

        cube = new Rubik(this, upCw());
        moves.add(cube);
        cube = new Rubik(this, upAcw());
        moves.add(cube);

        cube = new Rubik(this, downCw());
        moves.add(cube);
        cube = new Rubik(this, downAcw());
        moves.add(cube);

        cube = new Rubik(this, backCw());
        moves.add(cube);
        cube = new Rubik(this, backAcw());
        moves.add(cube);

        return moves;
    }

    @Override
    public boolean isSolution() {
        for(Szin[][] ol : kocka.values()) {
            Szin szn = ol[0][0];
            if(ol[0][1] != szn || ol[1][0] != szn || ol[1][1] != szn) {
                return false;
            }
        }

        return true;
    }

    @Override
    public double getHeuristic() {
        double point = 16;
        Set<Szin> szinek;

        for(Szin[][] ol : kocka.values()) {
            szinek = new HashSet<>();
            for(int i = 0; i < 2; i++) {
                szinek.addAll(Arrays.asList(ol[i]).subList(0, 2));
            }
            point -= (szinek.size()-1);
        }

        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        for(Oldal ol : kocka.keySet()) {
            if(kocka.get(ol)[0][0] != ((Rubik) o).kocka.get(ol)[0][0] || kocka.get(ol)[0][1] != ((Rubik) o).kocka.get(ol)[0][1] ||
               kocka.get(ol)[1][0] != ((Rubik) o).kocka.get(ol)[1][0] || kocka.get(ol)[1][1] != ((Rubik) o).kocka.get(ol)[1][1]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kocka);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Oldal ol : kocka.keySet()) {
            sb.append(ol);
            sb.append("\n");
            Szin[][] szn = kocka.get(ol);
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    sb.append(szn[i][j]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
