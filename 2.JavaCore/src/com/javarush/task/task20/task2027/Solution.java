package com.javarush.task.task20.task2027;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword,  "home" , "same");
        for(Word w : words){
            System.out.println(w);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();
        for(String word : words) {
            char[] c = word.toCharArray();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == (int) c[0]) {
                        try {
                            int a = i;
                            int b = j;
                            if (crossword[a - 1][b - 1] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        a--;
                                        b--;
                                        if (crossword[a - 1][b - 1] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b - 1 , a - 1);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a][b - 1] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        b--;
                                        if (crossword[a][b - 1] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j,i);
                                    s.setEndPoint(b - 1, a);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a + 1][b - 1] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        a++;
                                        b--;
                                        if (crossword[a + 1][b - 1] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b - 1,a + 1);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a + 1][b] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        a++;
                                        if (crossword[a + 1][b] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b , a + 1);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a + 1][b + 1] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        a++;
                                        b++;
                                        if (crossword[a + 1][b + 1] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b + 1,a + 1);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a][b + 1] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        b++;
                                        if (crossword[a][b + 1] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b + 1,a);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a - 1][b + 1] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        b++;
                                        a--;
                                        if (crossword[a - 1][b + 1] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b + 1,a - 1);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            if (crossword[a - 1][b] == (int) c[1]) {
                                try {
                                    for (int n = 2; n < c.length; n++) {
                                        a--;
                                        if (crossword[a - 1][b] == (int) c[n]) {
                                            continue;
                                        } else
                                            throw new ArrayIndexOutOfBoundsException();
                                    }
                                    Word s = new Word(word);
                                    s.setStartPoint(j, i);
                                    s.setEndPoint(b,a - 1);
                                    wordList.add(s);
                                    a = i;
                                    b = j;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    a = i;
                                    b = j;
                                    continue;
                                }
                            }
                            } catch(ArrayIndexOutOfBoundsException e){
                                continue;
                            }
                        }
                    }
                }
            }
        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
