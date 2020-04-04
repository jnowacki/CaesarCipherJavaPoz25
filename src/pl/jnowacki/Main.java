package pl.jnowacki;


import java.util.Scanner;

public class Main {

    private final static int CHARACTER_COUNT = 26;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String action;

        System.out.println("Wybierz akcje: [z]aszyfruj, [o]odszyfruj, [k]oniec ");

        while (!"k".equalsIgnoreCase(action = input.nextLine())) {

//wersja swith-case:
//            String word;
//            int offSet;
//
//            switch (action) {
//                case "z":
//                case "Z":
//                    word = getWord(input);
//                    offSet = getOffset(input);
//
//                    System.out.println("Zaszyfrowane slowo to: " + encrypt(word, offSet));
//                    break;
//                case "o":
//                case "O":
//                    word = getWord(input);
//                    offSet = getOffset(input);
//
//                    System.out.println("Odszyfrowane slowo to: " + decrypt(word, offSet));
//                    break;
//                default:
//                    System.out.println("Nieznana akcja");
//            }

            if ("z".equalsIgnoreCase(action)) {

                String word = getWord(input);
                int offSet = getOffset(input);

                System.out.println("Zaszyfrowane slowo to: " + encrypt(word, offSet));

            } else if ("o".equalsIgnoreCase(action)) {
                String word = getWord(input);
                int offSet = getOffset(input);

                System.out.println("Odszyfrowane slowo to: " + decrypt(word, offSet));
            } else {
                System.out.println("Nieznana akcja");
            }

            System.out.println("Wybierz akcje: [z]aszyfruj, [o]odszyfruj, [k]oniec ");
        }

        System.out.println("Do zobaczenia!");
    }

    private static String getWord(Scanner input) {
        System.out.println("Podaj slowo: ");
        return input.nextLine().toLowerCase();
    }

    private static int getOffset(Scanner input) {
        System.out.println("Podaj przesuniecie: ");
        return Integer.parseInt(input.nextLine());
    }

    private static String encrypt(String word, int offset) {

        StringBuilder stringBuilder = new StringBuilder(word.length());

        for (int i = 0; i < word.length(); i++) {
            stringBuilder
                    .append((char) ((word.charAt(i) - 'a' + offset) % CHARACTER_COUNT + 'a'));
        }

        return stringBuilder.toString();
    }

    private static String decrypt(String word, int offset) {

        int newOffset = CHARACTER_COUNT - offset % CHARACTER_COUNT;

        return encrypt(word, newOffset);
    }
}
