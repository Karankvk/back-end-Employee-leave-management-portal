package com.bsolsystems.employeeLeaveManagementPortal.Encryption;

public class PasswordEncryption {
    public static String encryption(String str) {
        String EncryptedString = "";
        try {
            for (int i = 0; i < str.length(); i++) {
                char ch = Character.valueOf(str.charAt(i));
                switch (ch) {
                    case 'a':
                        EncryptedString = EncryptedString + "८";
                        break;
                    case 'b':
                        EncryptedString = EncryptedString + "५";
                        break;
                    case 'c':
                        EncryptedString = EncryptedString + "२";
                        break;
                    case 'd':
                        EncryptedString = EncryptedString + "ह";
                        break;
                    case 'e':
                        EncryptedString = EncryptedString + "७";
                        break;
                    case 'f':
                        EncryptedString = EncryptedString + "४";
                        break;
                    case 'g':
                        EncryptedString = EncryptedString + "१";
                        break;
                    case 'h':
                        EncryptedString = EncryptedString + "स";
                        break;
                    case 'i':
                        EncryptedString = EncryptedString + "९";
                        break;
                    case 'j':
                        EncryptedString = EncryptedString + "६";
                        break;
                    case 'k':
                        EncryptedString = EncryptedString + "३";
                        break;
                    case 'l':
                        EncryptedString = EncryptedString + "०";
                        break;
                    case 'm':
                        EncryptedString = EncryptedString + "ष";
                        break;
                    case 'n':
                        EncryptedString = EncryptedString + "श";
                        break;
                    case 'o':
                        EncryptedString = EncryptedString + "ळ";
                        break;
                    case 'p':
                        EncryptedString = EncryptedString + "र";
                        break;
                    case 'q':
                        EncryptedString = EncryptedString + "य";
                        break;
                    case 'r':
                        EncryptedString = EncryptedString + "ॿ";
                        break;
                    case 's':
                        EncryptedString = EncryptedString + "फ";
                        break;
                    case 't':
                        EncryptedString = EncryptedString + "न";
                        break;
                    case 'u':
                        EncryptedString = EncryptedString + "थ";
                        break;
                    case 'v':
                        EncryptedString = EncryptedString + "व";
                        break;
                    case 'w':
                        EncryptedString = EncryptedString + "ल";
                        break;
                    case 'x':
                        EncryptedString = EncryptedString + "ॺ";
                        break;
                    case 'y':
                        EncryptedString = EncryptedString + "म";
                        break;
                    case 'z':
                        EncryptedString = EncryptedString + "ब";
                        break;
                    case ' ':
                        EncryptedString = EncryptedString + " ";
                        break;
                    case '.':
                        EncryptedString = EncryptedString + '3';
                        break;
                    case ',':
                        EncryptedString = EncryptedString + "1";
                        break;
                    case '(':
                        EncryptedString = EncryptedString + '4';
                        break;
                    case ')':
                        EncryptedString = EncryptedString + "7";
                        break;
                    case '?':
                        EncryptedString = EncryptedString + "2";
                        break;
                    case '!':
                        EncryptedString = EncryptedString + "8";
                        break;
                    case '-':
                        EncryptedString = EncryptedString + "6";
                        break;
                    case '%':
                        EncryptedString = EncryptedString + "9";
                        break;
                    case '1':
                        EncryptedString = EncryptedString + "r";
                        break;
                    case '2':
                        EncryptedString = EncryptedString + "k";
                        break;
                    case '3':
                        EncryptedString = EncryptedString + "b";
                        break;
                    case '4':
                        EncryptedString = EncryptedString + "e";
                        break;
                    case '5':
                        EncryptedString = EncryptedString + "q";
                        break;
                    case '6':
                        EncryptedString = EncryptedString + "h";
                        break;
                    case '7':
                        EncryptedString = EncryptedString + "u";
                        break;
                    case '8':
                        EncryptedString = EncryptedString + "y";
                        break;
                    case '9':
                        EncryptedString = EncryptedString + "w";
                        break;
                    case '0':
                        EncryptedString = EncryptedString + "ॐ";
                        break;
                    case '@':
                        EncryptedString = EncryptedString + "©";
                        break;
                    case '#':
                        EncryptedString = EncryptedString + "⨌";
                        break;
                    case '$':
                        EncryptedString = EncryptedString + "⨕";
                        break;
                    case 'A':
                        EncryptedString = EncryptedString + "अ";
                        break;
                    case 'B':
                        EncryptedString = EncryptedString + "्";
                        break;
                    case 'C':
                        EncryptedString = EncryptedString + "ई";
                        break;
                    case 'D':
                        EncryptedString = EncryptedString + "ी";
                        break;
                    case 'E':
                        EncryptedString = EncryptedString + "ऋ";
                        break;
                    case 'F':
                        EncryptedString = EncryptedString + "ृ";
                        break;
                    case 'G':
                        EncryptedString = EncryptedString + "ॡ";
                        break;
                    case 'H':
                        EncryptedString = EncryptedString + "ॣ";
                        break;
                    case 'I':
                        EncryptedString = EncryptedString + "आ";
                        break;
                    case 'J':
                        EncryptedString = EncryptedString + "ा";
                        break;
                    case 'K':
                        EncryptedString = EncryptedString + "उ";
                        break;
                    case 'L':
                        EncryptedString = EncryptedString + "ु";
                        break;
                    case 'M':
                        EncryptedString = EncryptedString + "ॠ";
                        break;
                    case 'N':
                        EncryptedString = EncryptedString + "ॄ";
                        break;
                    case 'O':
                        EncryptedString = EncryptedString + "ए";
                        break;
                    case 'P':
                        EncryptedString = EncryptedString + "े";
                        break;
                    case 'Q':
                        EncryptedString = EncryptedString + "इ";
                        break;
                    case 'R':
                        EncryptedString = EncryptedString + "ि";
                        break;
                    case 'S':
                        EncryptedString = EncryptedString + "ऊ";
                        break;
                    case 'T':
                        EncryptedString = EncryptedString + "ू";
                        break;
                    case 'U':
                        EncryptedString = EncryptedString + "ऌ";
                        break;
                    case 'V':
                        EncryptedString = EncryptedString + "ॢ";
                        break;
                    case 'W':
                        EncryptedString = EncryptedString + "ऐ";
                        break;
                    case 'X':
                        EncryptedString = EncryptedString + "ै";
                        break;
                    case 'Y':
                        EncryptedString = EncryptedString + "ओ";
                        break;
                    case 'Z':
                        EncryptedString = EncryptedString + "ो";
                        break;
                    default:
                        EncryptedString = EncryptedString + "⨞";
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return EncryptedString;
    }

    public static String decryption(String str) {
        String DecryptedString = "";
        try {
            for (int i = 0; i < str.length(); i++) {
                char ch = Character.valueOf(str.charAt(i));
                switch (ch) {
                    case '©':
                        DecryptedString = DecryptedString + "@";
                        break;
                    case '⨌':
                        DecryptedString = DecryptedString + "#";
                        break;
                    case '⨕':
                        DecryptedString = DecryptedString + "$";
                        break;
                    case '3':
                        DecryptedString = DecryptedString + ".";
                        break;
                    case '1':
                        DecryptedString = DecryptedString + ",";
                        break;
                    case '4':
                        DecryptedString = DecryptedString + "(";
                        break;
                    case '7':
                        DecryptedString = DecryptedString + ")";
                        break;
                    case '2':
                        DecryptedString = DecryptedString + "?";
                        break;
                    case '8':
                        DecryptedString = DecryptedString + "!";
                        break;
                    case '6':
                        DecryptedString = DecryptedString + "_";
                        break;
                    case '9':
                        DecryptedString = DecryptedString + "%";
                        break;
                    case 'r':
                        DecryptedString = DecryptedString + "1";
                        break;
                    case 'k':
                        DecryptedString = DecryptedString + "2";
                        break;
                    case 'b':
                        DecryptedString = DecryptedString + "3";
                        break;
                    case 'e':
                        DecryptedString = DecryptedString + "4";
                        break;
                    case 'q':
                        DecryptedString = DecryptedString + "5";
                        break;
                    case 'h':
                        DecryptedString = DecryptedString + "6";
                        break;
                    case 'u':
                        DecryptedString = DecryptedString + "7";
                        break;
                    case 'y':
                        DecryptedString = DecryptedString + "8";
                        break;
                    case 'w':
                        DecryptedString = DecryptedString + "9";
                        break;
                    case 'ॐ':
                        DecryptedString = DecryptedString + "0";
                        break;
                    case 'अ':
                        DecryptedString = DecryptedString + "A";
                        break;
                    case '्':
                        DecryptedString = DecryptedString + "B";
                        break;
                    case 'ई':
                        DecryptedString = DecryptedString + "C";
                        break;
                    case 'ी':
                        DecryptedString = DecryptedString + "D";
                        break;
                    case 'ऋ':
                        DecryptedString = DecryptedString + "E";
                        break;
                    case 'ृ':
                        DecryptedString = DecryptedString + "F";
                        break;
                    case 'ॡ':
                        DecryptedString = DecryptedString + "G";
                        break;
                    case 'ॣ':
                        DecryptedString = DecryptedString + "H";
                        break;
                    case 'आ':
                        DecryptedString = DecryptedString + "I";
                        break;
                    case 'ा':
                        DecryptedString = DecryptedString + "J";
                        break;
                    case 'उ':
                        DecryptedString = DecryptedString + "K";
                        break;
                    case 'ु':
                        DecryptedString = DecryptedString + "L";
                        break;
                    case 'ॠ':
                        DecryptedString = DecryptedString + "M";
                        break;
                    case 'ॄ':
                        DecryptedString = DecryptedString + "N";
                        break;
                    case 'ए':
                        DecryptedString = DecryptedString + "O";
                        break;
                    case 'े':
                        DecryptedString = DecryptedString + "P";
                        break;
                    case 'इ':
                        DecryptedString = DecryptedString + "Q";
                        break;
                    case 'ि':
                        DecryptedString = DecryptedString + "R";
                        break;
                    case 'ऊ':
                        DecryptedString = DecryptedString + "S";
                        break;
                    case 'ू':
                        DecryptedString = DecryptedString + "T";
                        break;
                    case 'ऌ':
                        DecryptedString = DecryptedString + "U";
                        break;
                    case 'ॢ':
                        DecryptedString = DecryptedString + "V";
                        break;
                    case 'ऐ':
                        DecryptedString = DecryptedString + "W";
                        break;
                    case 'ै':
                        DecryptedString = DecryptedString + "X";
                        break;
                    case 'ओ':
                        DecryptedString = DecryptedString + "Y";
                        break;
                    case 'ो':
                        DecryptedString = DecryptedString + "Z";
                        break;
                    case '८':
                        DecryptedString = DecryptedString + "a";
                        break;
                    case '५':
                        DecryptedString = DecryptedString + "b";
                        break;
                    case '२':
                        DecryptedString = DecryptedString + "c";
                        break;
                    case 'ह':
                        DecryptedString = DecryptedString + "d";
                        break;
                    case '७':
                        DecryptedString = DecryptedString + "e";
                        break;
                    case '४':
                        DecryptedString = DecryptedString + "f";
                        break;
                    case '१':
                        DecryptedString = DecryptedString + "g";
                        break;
                    case 'स':
                        DecryptedString = DecryptedString + "h";
                        break;
                    case '९':
                        DecryptedString = DecryptedString + "i";
                        break;
                    case '६':
                        DecryptedString = DecryptedString + "j";
                        break;
                    case '३':
                        DecryptedString = DecryptedString + "k";
                        break;
                    case '०':
                        DecryptedString = DecryptedString + "l";
                        break;
                    case 'ष':
                        DecryptedString = DecryptedString + "m";
                        break;
                    case 'श':
                        DecryptedString = DecryptedString + "n";
                        break;
                    case 'ळ':
                        DecryptedString = DecryptedString + "o";
                        break;
                    case 'र':
                        DecryptedString = DecryptedString + "p";
                        break;
                    case 'य':
                        DecryptedString = DecryptedString + "q";
                        break;
                    case 'ॿ':
                        DecryptedString = DecryptedString + "r";
                        break;
                    case 'फ':
                        DecryptedString = DecryptedString + "s";
                        break;
                    case 'न':
                        DecryptedString = DecryptedString + "t";
                        break;
                    case 'थ':
                        DecryptedString = DecryptedString + "u";
                        break;
                    case 'व':
                        DecryptedString = DecryptedString + "v";
                        break;
                    case 'ल':
                        DecryptedString = DecryptedString + "w";
                        break;
                    case 'ॺ':
                        DecryptedString = DecryptedString + "x";
                        break;
                    case 'म':
                        DecryptedString = DecryptedString + "y";
                        break;
                    case 'ब':
                        DecryptedString = DecryptedString + "z";
                        break;
                    case ' ':
                        DecryptedString = DecryptedString + " ";
                        break;
                    default:
                        DecryptedString = DecryptedString + "⨞";
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return DecryptedString;
    }
}
