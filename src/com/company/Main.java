package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int recur = 0;

    private int m = 4;
    private int n = 4;
    int z = m-1;
    int s = n-1;

    private String[][] stringArray = new String[][]{{"7", "8", "9", "10"}, {"6", "1", "2", "11"}, {"5", "4", "3", "12"}, {"16", "15", "14", "13"}};
    private List<String> listOfData = new ArrayList<>();

    private int tempx;
    private int tempy;
    private Boolean smt;

    static String consol;



    public static void main(String[] args) {
        System.out.println("Clockwise ucun 1 daxil edin \nAntiClockWise ucun 2 daxil edin \nInOut ucun 3 daxil edin");

        Scanner c = new Scanner(System.in);
        consol = c.nextLine();

        Main m = new Main();
        m.start1();
    }


    private void start1() {
        int startx = m / 2;
        int starty = n / 2;

        tempx = startx;
        tempy = starty;

        if (m>n && recur==1){
            tempx-=1;
        }
        if (m<n && recur==1){
            tempy-=1;
        }


        if ((m%2==0 && n%2 == 0)&& recur == 0) {
            tempx -= 1;
            tempy -= 1;
            System.out.println(tempx + " " + tempy);
        }
        if ((m%2== 0 && n%2==0)&& recur == 1) {
            tempx -= 1;
            System.out.println(tempx + " " + tempy);
        }
        if ((m%2==0 && n%2== 0)&&recur == 2) {
            tempy -= 1;
            System.out.println(tempx + " " + tempy);
        }
        if ((m%2 == 0 && n%2 == 0)&&recur == 3) {
            System.out.println(tempx + " " + tempy);
        }

        listOfData.add(stringArray[tempx][tempy]);

        if (consol.equals("1") || consol.equals("3")) {
            ClockWiseMovement(true);
        } else if (consol.equals("2")) {
            ClockWiseMovement(false);
        }


        if (consol.equals("3")) {
            Collections.reverse(listOfData);
        }

        String listdata = String.join(", ", listOfData);

        System.out.println(listdata);

        if (((m%2 == 0 && n%2 == 0)&& recur<3)||(m!=n && recur<1)) {
            recur += 1;
            listOfData.clear();
            start1();
        }
    }

    private void ClockWiseMovement(Boolean movement) {
        int tempnm = m + n;


        if (m == 4 && n == 3) {
            tempnm = m + n - 2;
        }
        for (int i = 1; i < tempnm; i++) {
            int tempi = i;
            smt = true;
            while (tempi >= 1) {
                if (i % 2 == 1) {
                    if (smt) {
                        try {
                            tempy += 1;
                            listOfData.add(stringArray[tempx][tempy]);
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }

                        if (tempi-- == 1) {
                            smt = false;
                            tempi = i;
                        }
                        continue;
                    } else {
                        if (movement) {
                            try {
                                tempx += 1;
                                listOfData.add(stringArray[tempx][tempy]);
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        } else {
                            try {
                                tempx -= 1;
                                listOfData.add(stringArray[tempx][tempy]);
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    }
                    tempi--;
                } else {
                    if (smt) {
                        try {
                            tempy -= 1;
                            listOfData.add(stringArray[tempx][tempy]);
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        if (tempi-- == 1) {
                            smt = false;
                            tempi = i;
                        }
                        continue;
                    } else {

                        if (movement) {
                            try {
                                tempx -= 1;
                                listOfData.add(stringArray[tempx][tempy]);
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        } else {
                            try {
                                tempx += 1;
                                listOfData.add(stringArray[tempx][tempy]);
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    }
                    tempi--;
                }
            }

        }
    }


}
